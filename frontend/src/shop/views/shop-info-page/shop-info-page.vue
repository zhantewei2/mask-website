<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-22 18:55:34
-->

<template src="./shop-info-page.html">
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Watch} from "vue-property-decorator";
    import {reqShopInfo} from "@/requests/manage/manage.requests";

    export interface Shop {
        name: string;
        createDate: string;
    }


    @Component({})
    export default class extends Vue {
        shopId: string = "";
        loading: boolean = false;
        shop: any = {};
        shopName: string = "";
        vestName: string = "";
        tableData: any[] = [];

        @Watch("$route.path", {immediate: true})
        watchRouteId(path: string) {
            const shopId = (this.$route.params || {}).id;
            if (!shopId) return;
            this.getShopInfo(this.shopId = shopId)
        }

        handleInfo(result: any) {
            this.shopName = result.name;
            result.vestName = this.vestName = result.vestRef.name;
            this.tableData = [this.shop];
            result.GWNW = (result.GW || "") + "/" + (result.NW || "");
            this.handleInfoContent(result);
        }
        handleInfoContent(result:any){
          result.info=result.info.replace(/\n/g,"</br>");
        }

        getShopInfo(shopId: string) {
            this.loading = true;
            reqShopInfo(shopId).subscribe((result: any) => {
                this.loading = false;
                this.shop = result;
                this.handleInfo(result);
            }, () => {
                this.loading = false;
                this.$store.dispatch("err", "mask info load failure!");
            })
        }

        showImage(url: string) {
            this.$visitImage(url);
        }
    }
</script>
<style scoped src="./shop-info-page.scss" lang="scss"></style>
