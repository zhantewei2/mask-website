<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhantewei2
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-29 19:54:46
-->

<template src="./keyValue-page.html">
</template>

<script lang="ts">
import Vue from "vue";
import {Component} from "vue-property-decorator";

import {reqDeleteKeyValue, reqQueryKeyValueMulti} from "@/requests/core/baseKeyValue.request";
import InsertKeyValueComponent from "../insertKeyValue-component/insertKeyValue-component.vue";

@Component({
    components:{
        "self-insert-key-value":InsertKeyValueComponent
    }
})
export default class extends Vue{
    listData:any[]=[];
    tableLoading:boolean=false;
    mounted(){
        this.getKeyValueList();
    }


    getKeyValueList(){
        this.tableLoading=true;
        reqQueryKeyValueMulti([]).subscribe(listData=>{
            this.tableLoading=false;
            this.listData=listData;
        },()=>{
            this.tableLoading=false;
        })
    }
    onInserted(){
        this.getKeyValueList();
    }
    itemDelete(i:any){
        // this.tableLoading=true;
        reqDeleteKeyValue(i.k).subscribe(()=>{
            this.tableLoading=false;
            this.$store.dispatch("success","删除成功");
            const index=this.listData.findIndex(j=>j.k===i.k);
            if(index>=0)this.listData.splice(index,1);

        },(e)=>{
            this.tableLoading=false;
            this.$store.dispatch("err",e);
        })
    }
    updateDate:any=null;
    itemUpdate(i:any){
        this.updateDate=i;
        this.updateShow=true;
    }
    updateShow:boolean=false;
    updateCompleted(){
        this.updateShow=false;
    }
}
</script>
<style scoped src="./keyValue-page.scss" lang="scss"></style>