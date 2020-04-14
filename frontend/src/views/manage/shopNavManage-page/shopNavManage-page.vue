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
import {Component, Prop} from "vue-property-decorator";
import {reqQueryShopNavItem, reqUpdateShopNavItemMulti} from "@/requests/manage/homeShopNav.requests";
import {forkJoin, fromEvent, Observable, Observer, Subscription} from "rxjs";
import ItemUpdateComponent from "../shopNavItemUpdate-component/shopNavItemUpdate-component.vue";

@Component({
    computed:{
        "sortChanged":function(){
            const self:any=this;
            return !!self.sortChange();
        }
    },
    components:{
        "self-item-update":ItemUpdateComponent
    }
})
export default class extends Vue{
    isSort:boolean=false;
    @Prop({default:"nav"})type:'nav'|'carousel';
    selectItem:any="";
    navList:any[]=[];
    loading:boolean=false;
    constructor() {
        super();
        (this.navList as any)=null;
    }


    mounted(){

        this.getList(this.type);
    }
    beforeHandleList(list:any[]){
        list.forEach(i=>{
            i.coverShow=false;
            i.infoShow=true;
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
            this.navList=result.sort((pre:any,next:any)=>pre.toOrder-next.toOrder);
        },()=>{
            this.loading=false;
            this.$store.dispatch("err","列表获取失败");
        })
    }
    itemMouseEnter(i:any){
        i.coverShow=true;
    }

    itemLeave(e:Event,i:any){
        i.coverShow=false;
    }

    originList:any=[];
    // sortItemActive:any="";
    sortStart(){
        if(!this.navList)return;
        this.navList.forEach(i=>i.infoShow=false);
        this.originList=JSON.parse(JSON.stringify(this.navList));
        this.isSort=true;

    }
    sortClose() {
        if(!this.navList)return;
        this.isSort=false;
        this.navList.forEach(i => i.infoShow = true);
    }
    sortMove(i:any,before:boolean){
        if(!this.navList)return;
        // this.sortItemActive=i;
        const activeIndex=this.navList.findIndex(j=>j===i);
        if(before&&i<=0)return;
        if(!before&&i>=this.navList.length-1)return;
        const nextItemIndex=before?activeIndex-1:activeIndex+1;
        let nextItem:any=this.navList[nextItemIndex];
        const tmp=nextItem;
        const tmpOrder=nextItem.toOrder;
        nextItem.toOrder=i.toOrder;
        i.toOrder=tmpOrder;
        this.navList.splice(nextItemIndex,1,i);
        this.navList.splice(activeIndex,1,nextItem);
    }
    sortChange():any[]|undefined{
        if(!this.navList)return;
        const changedList:any[]=[];
        this.originList.forEach((i:any)=>{
            const nowItem=this.navList.find(j=>j.id===i.id);
            if(nowItem.toOrder!=i.toOrder)changedList.push(nowItem);
        });
        return changedList.length?changedList:undefined;
    }
    sortConfirm(){
        const sortList=this.sortChange();
        if(!sortList)return;
        const btnLoad=this.$iceBtnLoad();
        reqUpdateShopNavItemMulti({
            list:sortList.map(i=>({
                id:i.id,
                toOrder:i.toOrder
            }))
        }).subscribe(result=>{
            btnLoad.cancel();
            this.originList=JSON.parse(JSON.stringify(this.navList));
            this.$store.dispatch("success","更改成功");
        },()=>{
            btnLoad.cancel();
            this.$store.dispatch("err","修改失败");
        })
    }

    sortRest(){
        this.navList=JSON.parse(JSON.stringify(this.originList));
    }
    sortCancel(){
        if(this.sortChange()){
            this.$confirm("顺序已经发生变更，是否取消更改，并返回。").then(()=>{
                this.sortRest();
                this.sortClose();
            }).catch(()=>{

            })
        }else{
            this.sortClose();
        }
    }

    /**
     * info
     */
    itemInfo(e:any,i:any) {
        i.infoShow=!i.infoShow;
    }

    deleteItem(i:any,index:number){
        this.navList&&this.navList.splice(index,1);
    }
}
</script>
<style scoped src="./shopNavManage-page.scss" lang="scss"></style>