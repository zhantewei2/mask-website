<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-22 15:53:18
-->

<template src="./show-home-page.html">
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component} from "vue-property-decorator";
    import {navData} from "../../NavData";
    import {shopClassify} from "../../ShopClassify";
    @Component({})
    export default class extends Vue {
        logoImg:string="image/shop-logo.png";

        navData: any = [];
        baseInfo:Record<string,string>={};

        footerNavList:any[]=[];
        navList(j:any){
            this.$store.dispatch("navList",j.id);
        }
        navHref(i: any) {
            if (i.href) this.$router.push(i.href);
        }
        mounted(){
            this.navData=shopClassify.navData;
            this.baseInfo=shopClassify.baseDict;
            this.footerNavList=shopClassify.classList.filter((i:any)=>i.main);
            console.log(this.footerNavList)
        }
        footerValueKeyList=[
            {icon:"email",k:"email"},
            {icon:"address",k:"concatAddress"}
        ];

        navMainType(i:any){
            this.$store.dispatch("navList",i.id);
        }

    }
</script>
<style scoped src="./show-home-page.scss" lang="scss"></style>