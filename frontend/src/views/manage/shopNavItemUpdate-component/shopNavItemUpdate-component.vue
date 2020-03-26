<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhantewei
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-25 16:56:7
-->

<template>
    <div class="manage-shop-nav-update">
        <transition name="animate-slide-toggle-left">
        <article class="manage-shop-nav-update-article" v-if="!isUpdateImg">
            <Form :form="updateForm">
                <Row>
                    <Cell>
                        <Label>名称</Label>
                        <Value v-form-controller="'name'">
                            <el-input v-model="updateForm.value.name"/>
                        </Value>
                    </Cell>
                </Row>
                <Row>
                    <Cell v-if="!updateForm.value.href">
                        <Label>导航类</Label>
                        <business-select-shop-classify v-model="updateForm.value.classifyId"/>
                    </Cell>
                </Row>
                <Row>
                    <Cell v-if="!updateForm.value.classifyId">
                        <Label>外部连接</Label>
                        <Value>
                            <el-input v-model="updateForm.value.href"/>
                        </Value>
                    </Cell>
                </Row>
            </Form>
            <footer class="ice-line text-center">
                <el-button @click="toUpdateValue" v-if="updateForm.isChanged" type="primary" plain size="mini">更新</el-button>
                <el-button @click="resetValueForm" v-if="updateForm.isChanged" type="primary" plain size="mini">重置</el-button>
                <el-button v-if="!canUpdated" type="text" @click="updateImgToggle()" size="mini">更换图片
                    <i class="za za-right"></i>
                </el-button>
            </footer>
        </article>
        </transition>
        <transition name="animate-slide-toggle-right">
            <article class="manage-shop-nav-update-article" v-if="isUpdateImg">
                <div>
                    <baidu-upload v-model="updateForm.value.img" />
                </div>
                <footer class="text-center">
                    <el-button type="text" @click="updateImgClose">
                        <span class="center">
                                <i class="za za-left"></i>返回
                        </span>
                    </el-button>
                    <el-button v-if="imgChange" size="mini" type="primary" plain>保存图片</el-button>
                </footer>

            </article>
        </transition>

    </div>
</template>

<script lang="ts">
import Vue from "vue";
import {Component, Prop, Watch} from "vue-property-decorator";
import {Form,requiredValidator} from "ztwx-fire-ui/form";
import {Subscription} from "rxjs";
import {reqUpdateShopNavItem} from "@/requests/manage/homeShopNav.requests";

@Component({})
export default class extends Vue{
    updateForm:Form=new Form([
        {id:"name",validator:[new requiredValidator("不能为空")]},
        {id:"img",validator:[new requiredValidator("必须设置图片")]},
        {id:"classifyId",validator:[]},
        {id:"href",validator:[]},
    ]);

    originItem:any={};
    canUpdated:boolean=false;
    isUpdateImg:boolean=false;
    imgChange:boolean=false;

    resetValueForm(){
        this.updateForm.resetOriginValue();
    }

    @Prop()item:any;
    @Watch("item",{immediate:true})
    watchItem(v:any){
        if(!v)return;
        this.originItem=v;
        this.updateForm.setOriginValue(v);
    }

    close(){
        this.$emit("close",this.originItem);
    }

    updateValue(){

    }
    updateImgToggle(){
        this.isUpdateImg=!this.isUpdateImg;
    }
    updateImgClose(){
        this.isUpdateImg=false;
    }
    valueUpdateLoading:boolean=false;
    imgUpdateLoading:boolean=false;

    toUpdateValue(){
        const isPass:boolean=this.updateForm.checkValidators();
        if(!isPass)return;
        const updateValue=this.updateForm.getUpdatedValue();
        if(!updateValue)return;

        if(updateValue.href)updateValue.classifyId=0;
        if(updateValue.classifyId)updateValue.href="";

        this.valueUpdateLoading=true;
        reqUpdateShopNavItem({
            id:this.originItem.id,
            body:updateValue
        }).subscribe(()=>{
            this.updateForm.updateOriginValue(updateValue);
            this.valueUpdateLoading=false;
            Object.assign(this.originItem,updateValue);
            this.$store.dispatch("success","更新成功");
        },err=>{
            this.valueUpdateLoading=false;
            this.$store.dispatch("err",err);
        })
    }
}
</script>
<style scoped src="./shopNavItemUpdate-component.scss" lang="scss"></style>