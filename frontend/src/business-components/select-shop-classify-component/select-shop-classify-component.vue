<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhantewei
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-25 17:31:50
-->

<template>
    <el-select :value="selectValue" @change="valueChange" clearable>
        <el-option
            v-for="i in list"
            :key="i.id"
            :label="i.name"
            :value="i.id"
        >
            {{i.name}}
            <span v-if="i.main" style="margin-left:10px">
                <el-tag type="warning">主类</el-tag>
            </span>
        </el-option>
    </el-select>
</template>

<script lang="ts">
import Vue from "vue";
import {Component, Prop, Watch} from "vue-property-decorator";
import {findClassList} from "@/requests/manage/manage.requests";

@Component({})
export default class extends Vue{
    selectValue:any="";
    @Prop({})value:any;
    @Watch("value",{immediate:true})
    watchValue(v:any){
        console.log("v",v);
        this.selectValue=v;
    }
    list:any=[];
    valueChange(v:any){
        this.$emit("input",v);
    }

    mounted(){
        findClassList().subscribe((list:any)=>{
            this.list=list;
        },()=>{
            this.$store.dispatch("err","get list of class failure");
        })
    }
}
</script>
<style scoped src="./select-shop-classify-component.scss" lang="scss"></style>