<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhantewei
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-25 10:54:41
-->

<template src="./shopNavManage-page.html">
</template>

<script lang="ts">
import Vue from "vue";
import {Component} from "vue-property-decorator";
import {reqQueryShopNavItem} from "@/requests/manage/homeShopNav.requests";
import {fromEvent, Observable, Observer, Subscription} from "rxjs";
import ItemUpdateComponent from "../shopNavItemUpdate-component/shopNavItemUpdate-component.vue";

@Component({
    computed:{
    },
    components:{
        "self-item-update":ItemUpdateComponent
    }
})
export default class extends Vue{
    isSort:boolean=false;
    type:"nav"|"carousel"="nav";
    selectItem:any="";
    navList:any[]=[];
    loading:boolean=false;

    activeItem:any="";
    documentClick:Subscription;
    mounted(){
        this.getList(this.type);
        this.documentClick=fromEvent(document.documentElement,"click").subscribe((e:any)=>{
            const target=e.target;
            if(this.infoItem){
                if(!this.infoItem.el.contains(target)&&this.infoItem.el!=target){
                    this.leaveInfo();
                }
            }
        });
    }

    beforeDestroy(){
        this.documentClick.unsubscribe();
    }
    beforeHandleList(list:any[]){
        list.forEach(i=>{
            i.coverShow=false;
            i.infoShow=false;
            i.el=null;
        })
    }
    afterHandleList(list:any[]){
        list.forEach(i=>{
            delete i.coverShow;
            delete i.infoShow;
            delete i.el;
        })
    }
    getList(type:"nav"|"carousel"|undefined=undefined){
        this.loading=true;
        reqQueryShopNavItem(type).subscribe(result=>{
            this.loading=false;
            this.beforeHandleList(result);
            this.navList=result;
        },()=>{
            this.loading=false;
            this.$store.dispatch("err","列表获取失败");
        })
    }
    clearItem(i:any){
        if(i){
            i.coverShow=false;
        }
        this.activeItem=undefined;

    }
    itemMouseEnter(i:any){

        if(this.activeItem!=i){
            this.clearItem(this.activeItem);
        }
        i.coverShow=true;
        this.activeItem=i;
    }

    itemLeave(e:Event,i:any){
        i&&this.clearItem(i);
    }

    /**
     * info
     */

    infoItem:any=null;
    itemInfo(e:any,i:any) {
        if(this.infoItem){
            return;
        }
        i.infoShow=true;
        i.el=e.currentTarget;
        this.infoItem=i;
    }
    leaveInfo(){
        if(this.infoItem){
            this.infoItem.infoShow=false;
            this.infoItem=null;
        }
    }
}
</script>
<style scoped src="./shopNavManage-page.scss" lang="scss"></style>