<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-22 16:36:40
-->

<template src="./shop-list-page.html">
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Watch} from "vue-property-decorator";
    import {PaginationParams} from "@types";
    import {reqQueryShop} from "@/requests/manage/manage.requests";
    import {shopClassify} from "../../ShopClassify";

    @Component({})
    export default class extends Vue {
        types: string[] = [];
        dataItem:any={};

        @Watch("$route.path", {immediate: true})
        watchRouteId(path: string) {
            let routeId = (this.$route.params || {}).id;
            if (!routeId) return this.emptyData();
            routeId = decodeURIComponent(routeId);
            const dataItem=shopClassify.classList.find(i=>i.id==routeId);

            if (!dataItem ||!dataItem.types||!dataItem.types.length) {
                return this.emptyData();
            }
            this.dataItem=dataItem;
            this.types = dataItem.types;
            this.currentPage = 1;
            this.pageChange({
                currentPage: this.currentPage,
                pageSize: this.pageSize
            }, () => {
            })
        }
        emptyData(){
            this.shopList=[];
        }
        mounted() {

        }

        shopList: any = [];
        total: number=0;
        currentPage: number = 1;
        pageSize: number = 15;
        loading: boolean = false;

        pageChange(p: PaginationParams, cb?: any) {
            this.loading=true;
            reqQueryShop({
                currentPage: p.currentPage,
                pageSize: p.pageSize,
                ...(this.types && this.types.length ? {
                    query: {
                        vestIns: this.types
                    }
                } : {})
            }).subscribe((result: any) => {
                this.shopList = result.list;
                this.currentPage=result.currentPage;
                this.total=result.total;
                cb && cb();
                this.loading=false;
            }, err => {
                cb && cb();
                this.emptyData();
                this.loading=false;
            })
        }

        navClick(i: any) {
            this.$router.push(`/info/${i.id}`)
        }

    }
</script>
<style scoped src="./shop-list-page.scss" lang="scss"></style>