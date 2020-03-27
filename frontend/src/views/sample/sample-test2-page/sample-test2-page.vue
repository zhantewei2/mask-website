<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-2-17 14:40:1
-->

<template src="./sample-test2-page.html">
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";

@Component({})
export default class extends Vue{
    value1:string="";
    data1:string="";
    data2:string="";
    data:Array<string>=new Array<string>(20).fill("1");

     mounted(){
         console.log("sample-test2 mounted");
     }
     toggle:boolean=true;
     change(){
         this.toggle=!this.toggle;
     }
}
</script>
<style scoped src="./sample-test2-page.scss" lang="scss"></style>