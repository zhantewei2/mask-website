<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-20 0:23:15
-->

<template src="./shopList-page.html">
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component} from "vue-property-decorator";
    import {PaginationParams} from "@types";
    import {reqQueryShop, reqRemoveShop, reqShopInfo} from "@/requests/manage/manage.requests";
    import ShopAddPage from "../shopAdd-page/shopAdd-page.vue";

    @Component({
        components: {
            "shop-add": ShopAddPage
        }
    })
    export default class extends Vue {
        data: any = [];
        tableLoading: boolean = false;
        queryVestIn: number = 0;
        currentPage: number = 1;
        pageSize: number = 10;
        total: number = 0;
        updateItem: any = null;
        visibleUpdate: boolean = false;

        mounted() {
            this.pageChange({currentPage: this.currentPage, pageSize: this.pageSize});

        }

        pageChange(p: PaginationParams) {
            this.tableLoading = true;
            reqQueryShop({
                currentPage: p.currentPage,
                pageSize: p.pageSize,
                query: this.queryVestIn ? {
                    vestIn: this.queryVestIn
                } : undefined
            }).subscribe((result: any) => {
                this.tableLoading = false;
                this.total = result.total;
                this.currentPage = result.currentPage;
                this.handleList(result.list);
                this.data = result.list;
            }, () => {
                this.tableLoading = false;
            })
        }

        handleList(list: any[]) {
            list && list.length && list.forEach(i => {
                i.className = (i.vestRef || {}).name;
            })
        }

        updateShop(i: any) {
            reqShopInfo(i.id).subscribe((info)=>{
              this.updateItem = info;
              this.visibleUpdate = true;
            });
        }

        shopUpdated(newValue: any) {
            this.visibleUpdate = false;
            Object.assign(this.updateItem, newValue);
            this.handleList([this.updateItem]);
        }

        deleteShop(i: any) {
            this.tableLoading = true;
            reqRemoveShop(i.id).subscribe(() => {
                this.tableLoading = false;
                this.$store.dispatch("success", "remove successful");
                const index = this.data.findIndex((item: any) => item == i);
                this.data.splice(index, 1);

            }, () => {
                this.tableLoading = false;
                this.$store.dispatch("err", "remove error");
            })
        }

    }


</script>
<style scoped src="./shopList-page.scss" lang="scss"></style>
