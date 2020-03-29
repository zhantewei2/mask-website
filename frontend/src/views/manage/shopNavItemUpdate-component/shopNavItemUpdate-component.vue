<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhantewei
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-25 16:56:7
-->

<template>
    <div class="manage-shop-nav-update">
        <Form :form="updateForm">
        <transition name="animate-slide-toggle-left">
        <article class="manage-shop-nav-update-article" v-if="!isUpdateImg">
            <main>
                <Row>
                    <Cell>
                        <Label :class="{changed:updateForm.controllerDict.name.changed}">名称</Label>
                        <Value v-form-controller="'name'">
                            <el-input v-model="updateForm.value.name"/>
                        </Value>
                    </Cell>
                </Row>
                <Row v-if="!updateForm.value.href">
                    <Cell>
                        <Label :class="{changed:updateForm.controllerDict.classifyId.changed}">导航类</Label>
                        <business-select-shop-classify v-model="updateForm.value.classifyId"/>
                    </Cell>
                </Row>
                <Row v-if="!updateForm.value.classifyId">
                    <Cell>
                        <Label :class="{changed:updateForm.controllerDict.href.changed}">外部连接</Label>
                        <Value>
                            <el-input v-model="updateForm.value.href"/>
                        </Value>
                    </Cell>
                </Row>
            </main>
            <footer class="ice-line text-center">
                <el-button @click="toUpdateValue" v-if="updateForm.isChanged" type="primary" plain size="mini">更新</el-button>
                <el-button @click="resetValueForm" v-if="updateForm.isChanged" type="primary" plain size="mini">重置</el-button>
                <el-button v-if="!updateForm.isChanged" type="text" @click="updateImgToggle()" size="mini">更换图片
                    <i class="za za-right"></i>
                </el-button>
                <el-popconfirm
                           @onConfirm="deleteItem"
                        title="确定删除"
                >
                    <span
                        slot="reference"

                    v-if="!updateForm.isChanged" v-cm-ripple class="ice-avatar medium rel bg-lucency-error">
                        <i class="za za-delete"></i>
                    </span>
                </el-popconfirm>
            </footer>
        </article>
        </transition>
        <transition name="animate-slide-toggle-right">
            <article class="manage-shop-nav-update-article" v-if="isUpdateImg">
                <Value class="flex-center" v-form-controller="'img'">
                    <baidu-upload v-model="updateForm.value.img" />
                </Value>
                <footer class="text-center">
                    <el-button size="mini" type="text" @click="updateImgClose" :disabled="imgUpdateLoading">
                        <span class="center">
                                <i class="za za-left"></i>返回
                        </span>
                    </el-button>
                    <el-button
                        :disabled="imgUpdateLoading"
                        @click="resetValueForm" size="mini" type="primary" pain v-if="updateForm.controllerDict.img.changed">
                        重置
                    </el-button>

                    <el-button
                    @click="saveImg"
                    v-if="updateForm.controllerDict.img.changed&&updateForm.value.img" size="mini" type="primary" plain>保存图片</el-button>
                </footer>
            </article>
        </transition>
        </Form>
        <yo-mini-loader :show="requestLoading"/>
    </div>
</template>

<script lang="ts">
import Vue from "vue";
import {Component, Prop, Watch} from "vue-property-decorator";
import {Form,requiredValidator} from "ztwx-fire-ui/form";
import {Subscription} from "rxjs";
import {reqDeleteShopNavItem, reqUpdateShopNavItem} from "@/requests/manage/homeShopNav.requests";

@Component({})
export default class extends Vue{
    updateForm:Form=new Form([
        {id:"name",validator:[new requiredValidator("不能为空")]},
        {id:"img",validator:[new requiredValidator("必须设置图片")]},
        {id:"classifyId",validator:[]},
        {id:"href",validator:[]},
    ]);
    originItem:any={};
    isUpdateImg:boolean=false;
    requestLoading:boolean=false;


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
    deleteItem(){

        this.requestLoading=true;
        reqDeleteShopNavItem(this.originItem.id).subscribe(res=>{
            this.requestLoading=false;
            this.$emit("delete");
            this.$store.dispatch("success",'删除成功');
        },()=>{
            this.requestLoading=false;
            this.$store.dispatch("err","删除失败");
        })
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
        this.updateForm.resetOriginValue();
        this.isUpdateImg=false;
    }
    valueUpdateLoading:boolean=false;
    imgUpdateLoading:boolean=false;

    toUpdateValue(){
        const isPass:boolean=this.updateForm.checkValidators();
        if(!isPass)return;
        const updateValue=this.updateForm.getUpdatedValue();
        if(!updateValue)return;

        if(updateValue.href)delete updateValue.classifyId;
        if(updateValue.classifyId)delete updateValue.href;

        this.valueUpdateLoading=true;
        const btnLoad=this.$iceBtnLoad();
        reqUpdateShopNavItem({
            id:this.originItem.id,
            body:updateValue
        }).subscribe(()=>{
            this.updateForm.updateOriginValue(updateValue);
            this.valueUpdateLoading=false;
            btnLoad.cancel();
            Object.assign(this.originItem,updateValue);
            this.$store.dispatch("success","更新成功");
        },err=>{
            btnLoad.cancel();
            this.valueUpdateLoading=false;
            this.$store.dispatch("err",err);
        })
    }
    saveImg(){
        const img=this.updateForm.value.img;
        this.imgUpdateLoading=true;
        const updateValue:any={img};
        const btnLoad=this.$iceBtnLoad();
        reqUpdateShopNavItem({
            id:this.originItem.id,
            body:updateValue
        }).subscribe(()=>{
            this.imgUpdateLoading=false;
            this.updateForm.updateOriginValue(updateValue);
            Object.assign(this.originItem,updateValue);
            btnLoad.cancel();
            this.imgUpdateLoading=false;
        },err=>{
            btnLoad.cancel();
            this.imgUpdateLoading=false;
        })
    }
}
</script>
<style scoped src="./shopNavItemUpdate-component.scss" lang="scss"></style>