<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhantewei
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-24 15:9:21
-->

<template src="./shopCarousel-page.html">
</template>

<script lang="ts">
import Vue from "vue";
import {Component} from "vue-property-decorator";
  import ShopNavManage from "../shopNavManage-page/shopNavManage-page.vue";
@Component({
        components:{
            "self-shop-nav-manage":ShopNavManage
        }
})
export default class extends Vue{

}
</script>
<style scoped src="./shopCarousel-page.scss" lang="scss"></style>