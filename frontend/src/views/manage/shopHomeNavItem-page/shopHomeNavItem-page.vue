<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhantewei
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-24 15:9:41
-->

<template src="./shopHomeNavItem-page.html">
</template>

<script lang="ts">
import Vue from "vue";
import {Component} from "vue-property-decorator";
import {Form, requiredValidator} from "ztwx-fire-ui/form";
import {findClassList} from "@/requests/manage/manage.requests";
import {reqInsertShopNav} from "@/requests/manage/homeShopNav.requests";

@Component({})
export default class extends Vue{
    itdAdd:string=`
    添加首页 轮播图、及下方导航图。
    `;
    classifyList:any[]=[];
    insertShopForm:Form=new Form([
        {id:"name",validator:[new requiredValidator("必须填写名称")]},
        {id:"img",validator:[new requiredValidator("必须上传图片")]},
        {id:"type",value:'nav',validator:[new requiredValidator("必须选择图片类型")]},
        {id:"href",validator:[]},
        {id:"classify",validator:[]}
    ]);

    useNav:string="";
    itdImg:any={
        "nav":"推荐图片尺寸 : 250x200",
        "carousel":"推荐图片尺寸 : 1920x454"
    };
    mounted(){
        findClassList().subscribe(classifylist=>{
            this.classifyList=classifylist;
        });
        this.insertShopForm.valueChange.subscribe((v:any)=>{
            if((this.useNav=="classify"&&!v.classify.value)||(this.useNav=="href"&&!v.href.value)){
                this.useNav="";
            }
            else if(v.classify.value){
                this.useNav='classify';
            }
            else if(v.href.value){
                this.useNav="href";
            }
        })
    }
    add(){
        const isPass:boolean=this.insertShopForm.checkValidators();
        if(!isPass)return;
        const value:any={...this.insertShopForm.value};
        value.classifyId=value.classify;
        const btnLoad=this.$iceBtnLoad();
        reqInsertShopNav(value)
        .subscribe(()=>{
            this.$store.dispatch("success","新增成功");
            btnLoad.cancel();
        },(e)=>{
            this.$store.dispatch("err",e);
            btnLoad.cancel();
        })

    }
    reset(){
        this.insertShopForm.reset();
    }
}
</script>
<style scoped src="./shopHomeNavItem-page.scss" lang="scss"></style>