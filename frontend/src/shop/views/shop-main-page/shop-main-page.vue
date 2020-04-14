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

        mounted() {
            this.mediaOrder = mediaObserver.subscribe((i: MediaRef) => {
                this.isMobile = i.mobile;
            });

            this.carouselData=shopClassify.homeCarouselList;
            this.mainList=shopClassify.homeNavList;
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
        itdName = "DASHENG MASKS SERIES";
        itdContent = "The company passed the ISO9001 international quality management system certification. Dasheng masks dozens of models for the European standard EN149 and get FFP1, FFP2 and FFP3 quality level certification respectively; dozens of models for AS / NZS 1716 Standards  Australia and the United States NEISON, NIOSH N95, N99 standard international certification.Double victory license mesh valve masks and face cloth masks and other national PatentOffice.";

    }
</script>
<style scoped src="./shop-main-page.scss" lang="scss"></style>