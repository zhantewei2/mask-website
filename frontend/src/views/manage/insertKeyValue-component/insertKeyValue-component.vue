<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhantewei2
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-29 23:35:43
-->

<template>
    <div >
        <Form :size="isUpdate?'small':''" :form="insertForm">
        <Row >
            <Cell>
                <Label :class="{changed:isUpdate&&insertForm.controllerDict.k.changed}">名称</Label>
                <Value v-form-controller="'k'">
                    <el-input :disabled="isUpdate" v-model="insertForm.value.k"/>
                </Value>
            </Cell>
            <Cell v-if="!isUpdate">
                <Label>值</Label>
                <Value v-form-controller="'v'">
                    <el-input v-model="insertForm.value.v"/>
                </Value>
            </Cell>
        </Row>
        <Row v-if="isUpdate">
            <Cell>
                <Label :class="{changed:isUpdate&&insertForm.controllerDict.v.changed}">值</Label>
                <Value v-form-controller="'v'">
                    <el-input v-model="insertForm.value.v"/>
                </Value>
            </Cell>
        </Row>
        <Row>
            <Cell>
                <Label :class="{changed:isUpdate&&insertForm.controllerDict.des.changed}">描述</Label>
                <Value>
                    <el-input v-model="insertForm.value.des"/>
                </Value>
            </Cell>
        </Row>
        </Form>
        <Aside class="text-center">
            <el-button :disabled="!insertForm.isChanged" @click="update" v-if="isUpdate" type="primary"> 修改</el-button>
            <el-button @click="submit" v-if="!isUpdate" type="primary">提交</el-button>
            <el-button @click="reset" >重置</el-button>
        </Aside>
    </div>
</template>

<script lang="ts">
import Vue from "vue";
import {Component, Prop, Watch} from "vue-property-decorator";
import {Form, requiredValidator} from "ztwx-fire-ui/form";
import {KeyValue, reqInsertKeyValue, reqUpdateKeyValue} from "@/requests/core/baseKeyValue.request";

@Component({})
export default class extends Vue{
    @Prop({default:false}) isUpdate:boolean;

    @Prop({})updateData:KeyValue;
    @Watch('updateData',{immediate:true})
    watchUpdateData(v:KeyValue){
        console.log(1,v);
        if(!v)return;
        this.insertForm.setOriginValue(v);
        this.originItem=v;
    }
    originItem:any;

    insertForm:Form=new Form([
        {id:'k',validator:[new requiredValidator("必须填写名称")]},
        {id:"v",validator:[new requiredValidator('不能为空')]},
        {id:"des",validator:[]}
    ]);
    mounted(){

    }
    submit(){
        const isPass:boolean=this.insertForm.checkValidators();
        if(!isPass)return;
        reqInsertKeyValue((this.insertForm.value as any)).subscribe(()=>{
            this.$store.dispatch("success",'新增成功');
            this.insertForm.reset();
            this.$emit("insert");
        },err=>{
            console.log(err);
            this.$store.dispatch("err","新增失败");
        })
    }
    update(){
        const isPass:boolean=this.insertForm.checkValidators();
        if(!isPass)return;
        const updateDate:any=this.insertForm.getUpdatedValue();
        if(!updateDate)return;
        const btnLoad=this.$iceBtnLoad();
        reqUpdateKeyValue({
            k:this.originItem.k,
            ...updateDate
        })
            .subscribe(()=>{
                btnLoad.cancel();
                this.insertForm.updateOriginValue(updateDate);
                Object.assign(this.originItem,updateDate);
                console.log(this,this.$store);
                this.$store.dispatch("success","修改成功");
                this.$emit("update");
            },(e)=>{
                btnLoad.cancel();
                this.$store.dispatch("err",e);
            })
    }
    reset(){
        !this.isUpdate?this.insertForm.reset():this.insertForm.resetOriginValue();
    }
}
</script>
