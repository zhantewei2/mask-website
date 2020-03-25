<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhantewei
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-25 16:56:7
-->

<template>
    <div>
        <Form :form="updateForm">
            <Row>
                <Cell>
                    <Label>名称</Label>
                    <Value>
                        <el-input v-model="updateForm.value.name"/>
                    </Value>
                </Cell>
            </Row>
            <Row>
                <Cell>
                    <Label>导航类</Label>
                    <business-select-shop-classify v-model="updateForm.value.classifyId"/>
                </Cell>
            </Row>
        </Form>
    </div>
</template>

<script lang="ts">
import Vue from "vue";
import {Component, Prop, Watch} from "vue-property-decorator";
import {Form,requiredValidator} from "ztwx-fire-ui/form";

@Component({})
export default class extends Vue{
    updateForm:Form=new Form([
        {id:"name",validator:[new requiredValidator("不能为空")]},
        {id:"img",validator:[new requiredValidator("必须设置图片")]},
        {id:"classifyId",validator:[]},
    ]);

    @Prop()item:any;
    @Watch("item",{immediate:true})
    watchItem(v:any){
        if(!v)return;
        ["name","img","classifyId"].forEach(key=>{
            this.updateForm.value[key]=v[key];
        });
    }
    classifyId:number|string="";

}
</script>
<style scoped src="./shopNavItemUpdate-component.scss" lang="scss"></style>