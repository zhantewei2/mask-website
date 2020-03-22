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
    import {reqQueryShop} from "@/requests/manage/manage.requests";

    @Component({})
    export default class extends Vue {
        data: any = [];
        tableLoading: boolean = false;
        queryVestIn: number = 0;
        currentPage: number = 1;
        pageSize: number = 10;
        total: number = 0;

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
                this.data = result.list;
                this.total = result.total;
                this.currentPage = result.currentPage;
            }, () => {
                this.tableLoading = false;
            })
        }

    }


</script>
<style scoped src="./shopList-page.scss" lang="scss"></style>