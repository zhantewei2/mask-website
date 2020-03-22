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
    import {Component} from "vue-property-decorator";
    import {Form, requiredValidator, minValidator} from "ztwx-fire-ui/form";
    import {findClassList, reqInsertShop} from "@/requests/manage/manage.requests";

    @Component({})
    export default class extends Vue {
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
            reqInsertShop(value)
                .subscribe(() => {
                    btnLoad.cancel();
                    this.form.reset();
                    this.$store.dispatch("success", "新增商品成功");
                }, (e) => {
                    btnLoad.cancel();
                    this.$store.dispatch("err", e);
                })
        }

        reset() {
            this.form.reset();
        }

        mounted() {
            this.getVestInList();
        }

        vestInList: any[] = [];

        getVestInList() {
            findClassList().subscribe((list: any) => {
                this.vestInList = list;
            })
        }

    }
</script>
<style scoped src="./shopAdd-page.scss" lang="scss"></style>