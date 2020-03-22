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
    import {typeData, classifyIdDict} from "../../NavData";
    import {PaginationParams} from "@types";
    import {reqQueryShop} from "@/requests/manage/manage.requests";
    import {finalize} from "rxjs/operators";

    @Component({})
    export default class extends Vue {
        navLabel: string[] = [];
        types: string[] = [];
        routeIdName: string = "";

        @Watch("$route.path", {immediate: true})
        watchRouteId(path: string) {
            let routeId = (this.$route.params || {}).id;
            if (!routeId) return;
            this.routeIdName = routeId = decodeURIComponent(routeId);

            const dataItem: any = typeData.find((i: any) => i.id == routeId);
            if (!dataItem) {
                console.debug("not found dataId");
                return;
            }
            this.navLabel = dataItem.navLabel;
            this.types = dataItem.types;
            this.currentPage = 1;
            this.loading = true;
            this.pageChange({
                currentPage: this.currentPage,
                pageSize: this.pageSize
            }, () => {
                this.loading = false;
            })
        }

        mounted() {

        }

        shopList: any = [];
        total: number;
        currentPage: number = 1;
        pageSize: number = 15;
        loading: boolean = false;

        pageChange(p: PaginationParams, cb?: any) {
            reqQueryShop({
                currentPage: p.currentPage,
                pageSize: p.pageSize,
                ...(this.types && this.types.length ? {
                    query: {
                        vestIns: this.types.map((type: string) => classifyIdDict[type])
                    }
                } : {})
            }).subscribe((result: any) => {
                this.shopList = result.list;
                cb && cb();
            }, err => {
                cb && cb();
            })
        }

        navClick(i: any) {
            this.$router.push(`/info/${i.id}`)
        }

    }
</script>
<style scoped src="./shop-list-page.scss" lang="scss"></style>