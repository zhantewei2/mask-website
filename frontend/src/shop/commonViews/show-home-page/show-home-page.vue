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

    @Component({})
    export default class extends Vue {
        navData: any = navData;
        navList(j:any){
            this.$store.dispatch("navList",j.id);
        }
        navHref(i: any) {
            if (i.href) this.$router.push(i.href);
        }
    }
</script>
<style scoped src="./show-home-page.scss" lang="scss"></style>