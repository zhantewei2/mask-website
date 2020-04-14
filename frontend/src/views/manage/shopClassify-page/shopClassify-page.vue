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
    import {Form, requiredValidator} from "@ztwx/form";
    import {
        findClassList,
        insertShopClass,
        updateShopClass,
        updateShopClassMulti
    } from "@/requests/manage/manage.requests";
    import {tap} from "rxjs/operators";

    @Component({
        computed: {
            "showSelectParent": function () {
                const self: any = this;
                return !self.form.value.isMain;
            }
        }
    })
    export default class extends Vue {
        form: Form = new Form([
            {id: "name", validator: [new requiredValidator("必须填写名称")]},
            {id: "isMain", value: false, validator: []},
            {id: "parentClass", validator: []}
        ]);
        normalUpdateForm: Form = new Form([
            {id: "name", validator: [new requiredValidator("必须填写名称")]},
            {id: "parentClass", validator: []}
        ]);
        mainUpdateForm: Form = new Form([
            {id: "name", validator: [new requiredValidator("必须填写名称")]}
        ]);


        classLists: any[] = [];
        lists: any[] = [];
        listMain:any[]=[];
        listMainOrigin:any[]=[];
        listNormal:any[]=[];
        tableLoading: boolean = false;
        showUpdate: boolean = false;
        showUpdateMain: boolean = false;
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
                        this.getMainClass();
                        btnLoad.cancel();
                        this.form.reset();
                    }, (err: any) => {
                        btnLoad.cancel();
                        console.debug(err);
                        this.$store.dispatch("err", "insert failure!!");
                    })
            }
        }

        reset() {
            this.form.reset();
        }

        mounted() {
            this.getMainClass();
            this.getClass();
            this.form.valueChange.subscribe((value: any) => {
                if (value.isMain.value && value.parentClass.value) {
                    value.parentClass.reset();
                }
            })
        }

        getMainClass() {
            findClassList(true).subscribe((result: any) => {
                this.classLists = result;
            })
        }

        getClass() {
            this.tableLoading = true;
            findClassList().subscribe((result: any) => {
                const resultMain: any[] = [];
                const resultNormal: any[] = [];
                result.forEach((i: any) => {
                    i.mainV = i.main ? "是" : "否";
                    i.parentClassName = (i.parentClassRef || {}).name;
                    i.main ? resultMain.push(i) : resultNormal.push(i);
                });
                this.listMain=this.sortListMain(resultMain);
                this.listMainOrigin=JSON.parse(JSON.stringify(resultMain));
                this.listNormal=resultNormal;
                this.lists = resultMain.concat(resultNormal);
                this.tableLoading = false;
            })
        }
        sortListMain(listMain:any[]):any[]{
            return listMain.sort((pre:any,next:any)=>pre.toOrder-next.toOrder)
        }
        tableRowClassHandle({row, rowIndex}: any) {
            if (row.main) return "bg-light-assist";
            return "";
        }

        toDelete(i: any) {
            /**
             *  delete validator
             * */

            if (i.main) {
                const existsOrder: boolean = this.lists.findIndex(i => i.parentClass = i.id) >= 0;
                if (existsOrder) {
                    this.$store.dispatch("err", "无法删除一个非空子类的大类");
                    return;
                }
            }

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
            if (!i.main) {
                this.showUpdate = true;
                this.normalUpdateForm.value.name = i.name;
                this.normalUpdateForm.value.parentClass = i.parentClass;
            } else {
                this.showUpdateMain = true;
                this.mainUpdateForm.value.name = i.name;
            }
            this.updateObj = i;
        }

        closeUpdate() {
            this.showUpdateMain = this.showUpdate = false;
            this.updateObj = {};
        }

        filterUpdateParams(params: any) {
            const _params = {...params};
            if (_params.parentClass === "") _params.parentClass = 0;
            return _params;
        }

        confirmUpdate(main: boolean) {
            const form: Form = main ? this.mainUpdateForm : this.normalUpdateForm;
            const isPass: boolean = form.checkValidators();
            if (!isPass) return;
            const value: any = form.value;
            const updateParams: any = {};
            for (let key in value) {
                if (value[key] != this.updateObj[key]) updateParams[key] = value[key];
            }
            if (Object.keys(updateParams).length < 1) return;
            const btnLoad = this.$iceBtnLoad();
            const filterParams = this.filterUpdateParams(updateParams);
            filterParams.id = this.updateObj.id;
            updateShopClass(filterParams).subscribe(() => {
                btnLoad.cancel();
                Object.assign(this.updateObj, updateParams);
                this.$store.dispatch("success", "update success");
                /**
                 * 处理归属子集数据一致性
                 */
                if (main) {
                    this.lists.forEach((i: any) => {
                        if (i.parentClass == this.updateObj.id) i.parentClassName = this.updateObj.name;
                    })
                } else {
                    const parentClass = filterParams.parentClass;
                    if (parentClass) {
                        this.updateObj.parentClassName = this.lists.find((i: any) => i.id == parentClass).name;
                    } else if (parentClass === 0) {
                        this.updateObj.parentClassName = "";
                    }
                }

                this.closeUpdate();
            }, () => {
                btnLoad.cancel();
                this.$store.dispatch("err", "update failure");
                this.closeUpdate();
            })
        }
        moveMain(row:any,up:boolean){
            const rowIndex=this.listMain.findIndex(i=>i.id==row.id);

            const replaceIndex=up?rowIndex-1:rowIndex+1;
            if(replaceIndex<0||replaceIndex>=this.listMain.length)return;
            const replaceItem=this.listMain[replaceIndex];
            //replace
            const tempOrder=replaceItem.toOrder;
            replaceItem.toOrder=row.toOrder;
            row.toOrder=tempOrder;

            this.listMain[rowIndex]=replaceItem;
            this.listMain[replaceIndex]=row;

            this.lists=this.listMain.concat(this.listNormal);
            this.checkMainList();
        }
        mainOrderChangedList:any[]=[];
        confirmMainOrderLoading:boolean=false;

        checkMainList(){

            let originMathed:any;
            const changedList=[];
            for(let nextItem of this.listMain){
                originMathed=this.listMainOrigin.find(i=>i.id==nextItem.id);
                if(originMathed.toOrder!=nextItem.toOrder){
                    changedList.push(nextItem);
                }
            }
            this.mainOrderChangedList=changedList;
        }
        confirmMainOrderChanged(){
            this.confirmMainOrderLoading=true;
            updateShopClassMulti(
                this.mainOrderChangedList.map(i=>({
                    id:i.id,
                    toOrder:i.toOrder
                })))
            .subscribe(result=>{
                this.confirmMainOrderLoading=false;
                this.mainOrderChangedList=[];
                this.getClass();
                this.$store.dispatch("success","更新成功");
            },()=>{
                this.confirmMainOrderLoading=false;
                this.$store.dispatch("err","更新失败");
                this.resetMainOrderChanged();
            })
        }
        resetMainOrderChanged(){
            this.listMain=JSON.parse(JSON.stringify(this.listMainOrigin));
            this.lists=this.listMain.concat(this.listNormal);
            this.mainOrderChangedList=[];
        }
    }
</script>
<style scoped src="./shopClassify-page.scss" lang="scss"></style>
