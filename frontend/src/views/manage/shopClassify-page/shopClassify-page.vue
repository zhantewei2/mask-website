<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-20 0:23:26
-->

<template src="./shopClassify-page.html">
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component} from "vue-property-decorator";
    import {Form, requiredValidator} from "ztwx-fire-ui/form";
    import {findClassList, insertShopClass, updateShopClass} from "@/requests/manage/manage.requests";
    import {tap} from "rxjs/operators";

    @Component({})
    export default class extends Vue {
        form: Form = new Form([
            {id: "name", validator: [new requiredValidator("必须填写名称")]}
        ]);
        lists: any[] = [];
        tableLoading: boolean = false;
        showUpdate: boolean = false;
        updateObj: any = {};

        /**
         * 新增
         */
        add() {
            const isPass: boolean = this.form.checkValidators();
            if (isPass) {
                const btnLoad = this.$iceBtnLoad();
                const value: any = this.form.value;
                insertShopClass(value)
                    .subscribe(res => {
                        this.$store.dispatch("success", "insert success!!");
                        this.getClass();
                        btnLoad.cancel();
                        this.form.reset();
                    }, (err: any) => {
                        btnLoad.cancel();
                        console.debug(err);
                        this.$store.dispatch("err", "insert failure!!");
                    })
            }
        }

        mounted() {
            this.getClass();
        }

        getClass() {
            this.tableLoading = true;
            findClassList().subscribe((result: any) => {
                this.lists = result;
                this.tableLoading = false;
            })
        }

        toDelete(i: any) {
            updateShopClass({id: i.id, enabled: 0}).subscribe(() => {
                this.$store.dispatch("success", "delete success");
                const index = this.lists.findIndex(item => item.id == i.id);
                if (index < 0) return;
                this.lists.splice(index, 1);
            }, () => {
                this.$store.dispatch("err", "delete failure");
            })
        }

        toUpdate(i: any) {
            this.showUpdate = true;
            this.updateObj = {...i};
        }

        closeUpdate() {
            this.showUpdate = false;
            this.updateObj = {};
        }

        confirmUpdate() {
            const originItem = this.lists.find((i: any) => i.id === this.updateObj.id);
            if (this.updateObj.name === originItem.name) return;
            const {id, name} = this.updateObj;
            const btnLoad = this.$iceBtnLoad();
            updateShopClass({id, name}).subscribe(() => {
                btnLoad.cancel();
                Object.assign(originItem, this.updateObj);
                this.$store.dispatch("success", "update success");
                this.closeUpdate();
            }, () => {
                btnLoad.cancel();
                this.$store.dispatch("err", "update failure");
                this.closeUpdate();
            })
        }
    }
</script>
<style scoped src="./shopClassify-page.scss" lang="scss"></style>