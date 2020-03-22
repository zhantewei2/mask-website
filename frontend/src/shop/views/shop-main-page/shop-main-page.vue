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
    import {carouselData} from "../../CarouselData";
    import {mediaObserver, MediaRef} from "../../store/media.subject";

    @Component({})
    export default class extends Vue {
        carouselData: any = carouselData;
        isMobile: boolean = false;
        mediaOrder: any;

        mounted() {
            this.mediaOrder = mediaObserver.subscribe((i: MediaRef) => {

                this.isMobile = i.mobile;
            })
        }

        beforeDestroy() {

            this.mediaOrder && this.mediaOrder.unsubscribe();
        }

        navList(i: any) {
            this.$store.dispatch("navList", i.id);
        }

        mainList = [
            {name: "CE Masks", img: "image/ce-home.jpg", id: "CE"},
            {name: "NIOSH Masks", img: "image/NIOSH-home.jpg", id: "AS/NZS"},
            {name: "AS/NZS Masks", img: "image/AS-home.jpg", id: "NIOSH"}

        ]

        clickMainItem(i: any) {
            this.$store.dispatch("navList", i.id);
        }

        itdName = "DASHENG MASKS SERIES";
        itdContent = "The company passed the ISO9001 international quality management system certification. Dasheng masks dozens of models for the European standard EN149 and get FFP1, FFP2 and FFP3 quality level certification respectively; dozens of models for AS / NZS 1716 Standards  Australia and the United States NEISON, NIOSH N95, N99 standard international certification.Double victory license mesh valve masks and face cloth masks and other national PatentOffice.";

    }
</script>
<style scoped src="./shop-main-page.scss" lang="scss"></style>