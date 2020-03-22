<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-2-17 14:39:54
-->

<template src="./sample-test1-page.html">
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import sampleData from "./sample-data";
import {PaginationParams} from "@types";
import {of} from "rxjs";
import {delay, finalize} from "rxjs/operators";
import {loginExpired} from "../../../requests/core/core.requests";


@Component({})
export default class extends Vue{
    /**
     * 请求按钮响应案例
     */
    click(){
        /**
         * 开始请求接口，按钮转动
         */
        const btnLoad=this.$iceBtnLoad();
        /**
         * 接口请求完毕，关闭转动
         */
        setTimeout(()=>btnLoad.cancel(),1500);
    }
    expired(){
        loginExpired().subscribe(()=>{});
    }

    /**
     * table 表格案例
     * 发起请求，获得表格数据
     */
    tableData:any=[];
    total:number=100;
    tableLoading:boolean=false;
    handlePageChange(e:PaginationParams){
        this.tableLoading=true;
        of(sampleData)    //模拟数据请求，返回sampleData
            .pipe(
                delay(250),   //延迟250毫秒
                finalize(()=>this.tableLoading=false)  //处理loading 为结束状态
        )
        .subscribe(data=>{
            this.tableData = sampleData
        },err=>{

        })
    }
}
</script>
<style scoped src="./sample-test1-page.scss" lang="scss"></style>
