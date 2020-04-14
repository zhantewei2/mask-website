<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-20 0:23:50
-->

<template src="./shopAdd-page.html">
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Prop} from "vue-property-decorator";
    import {Form, requiredValidator, minValidator} from "@ztwx/form";
    import {findClassList, reqInsertShop, reqUpdateShop} from "@/requests/manage/manage.requests";


    @Component({

    })
    export default class extends Vue {
        @Prop({}) formValue: any;
        updateId: string = "";
        form: Form = new Form([
            {id: "name", validator: [new requiredValidator("必须填写商品名")]},
            {id: "price", validator: [new minValidator("必须大于0", 1)]},
            {id: "img", validator: [new requiredValidator("必须上传图片")]},
            {id: "vestIn", validator: [new requiredValidator("必须选择类别")]},
            {id: "type", validator: []},
            {id: "box", validator: []},
            {id: "ctn", validator: []},
            {id: "dimension", validator: []},
            {id: "GW", validator: []},
            {id: "NW", validator: []}
        ]);

        submit() {
            const isPass: boolean = this.form.checkValidators();
            if (!isPass) return;
            const btnLoad = this.$iceBtnLoad();
            const value: any = this.form.value;
            this.form.value.imgs = this.form.value.img;
            if (value.price) value.price = Number(value.price);

            if (!this.updateId) {


                reqInsertShop(value)
                    .subscribe(() => {
                        btnLoad.cancel();
                        this.form.reset();
                        this.$store.dispatch("success", "新增商品成功");
                    }, (e) => {
                        btnLoad.cancel();
                        this.$store.dispatch("err", e);
                    })
            } else {
                reqUpdateShop({
                    id: this.updateId,
                    body: value
                }).subscribe(() => {
                    btnLoad.cancel();
                    /**
                     * handle vestIn
                     */

                    if (this.formValue.vestRef && (this.formValue.vestIn != value.vestIn)) {
                        value.vestRef = this.vestInList.find(i => i.id == value.vestIn);
                    }
                    this.$emit("shopUpdated", value);
                    this.$store.dispatch("success", "修改成功");
                    this.form.reset();
                }, e => {
                    btnLoad.cancel();
                    this.$store.dispatch("err", e);
                })
            }
        }

        handleVestIn() {

        }

        reset() {
            this.form.reset();
        }

        mounted() {
            this.getVestInList();
            if (this.formValue) {
                const formKeys: string[] = Object.keys(this.form.controllerDict);
                for (let key in this.formValue) {
                    if (formKeys.indexOf(key) >= 0) this.form.value[key] = this.formValue[key];
                }
                this.updateId = this.formValue.id;
            }
        }

        vestInList: any[] = [];

        getVestInList() {
            findClassList(false).subscribe((list: any) => {
                this.vestInList = list;
            })
        }

    }
</script>
<style scoped src="./shopAdd-page.scss" lang="scss"></style>
