<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-22 16:36:31
-->

<template src="./shop-main-page.html">
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component} from "vue-property-decorator";
    import {mediaObserver, MediaRef} from "../../store/media.subject";
    import {shopClassify} from "../../ShopClassify";
    @Component({})
    export default class extends Vue {
        carouselData: any = [];
        isMobile: boolean = false;
        mediaOrder: any;
        baseInfo:any;
        mounted() {
            this.mediaOrder = mediaObserver.subscribe((i: MediaRef) => {
                this.isMobile = i.mobile;
            });

            this.carouselData=shopClassify.homeCarouselList;
            this.mainList=shopClassify.homeNavList;
            this.baseInfo=shopClassify.baseDict;
            this.itdName=this.baseInfo.websiteName;
            this.itdContent=this.baseInfo.webDes;
        }

        beforeDestroy() {

            this.mediaOrder && this.mediaOrder.unsubscribe();
        }

        nav(i: any) {

            if(i.classifyId){
                this.$store.dispatch("navList",i.classifyId);
            }
            else if(i.href){
                this.$store.dispatch("href",i.href);
            }
        }

        mainList:any = [];
        itdName:string = "";
        itdContent:string;
    }
</script>
<style scoped src="./shop-main-page.scss" lang="scss"></style>
