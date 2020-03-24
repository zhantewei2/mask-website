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
        navData: any = []
        navList(j:any){
            this.$store.dispatch("navList",j.name);
        }
        navHref(i: any) {
            if (i.href) this.$router.push(i.href);
        }
        mounted(){
            this.navData=shopClassify.navData;
        }
    }
</script>
<style scoped src="./show-home-page.scss" lang="scss"></style>