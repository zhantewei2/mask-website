<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-21 15:2:36
-->

<template>
    <div class="yo-baidu-uploader" :class="{cover:!!showData}">
        <span @click="clear" v-if="showData" class="close-upload">
            <i class="fa fa-close"></i>
        </span>
        <i class="icon-upload fa fa-uploadMax"></i>
        <input ref="input" class="input-upload" type="file" @change="change"/>
        <img v-if="showData" class="img-exhibition" :src="showData">
        <yo-mini-loader :show="imgLoading"></yo-mini-loader>
        <div class="cover" @click="visitImg">
            <i class="fa fa-search"></i>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Emit, Prop, Watch} from "vue-property-decorator";
    import {fileCompress, dataURLtoBlob} from "ztwx-fire-ui/utils";
    import {upload} from "./baidu";
    import md5 from "js-md5";

    @Component({})
    export default class extends Vue {
        showData: string = "";
        prefixPath: string = "maskShop/";
        @Prop({}) value: string;

        @Watch("value", {immediate: true})
        watchValue(v: string) {
            this.showData = v;
        }

        @Emit()
        error(errMessage: string) {
            this.clear();
        }

        setShowData(v: string) {
            this.$emit("input", this.showData = v);
        }

        setLoading() {
            this.imgLoading = true;
            this.$emit("input", "");
        }

        clearLoading() {
            this.imgLoading = false;
        }

        imgLoading: boolean = false;

        clear() {
            this.setShowData("");
            (this.$refs as any).input.value = "";
        }

        visitImg() {
            this.$visitImage(this.showData);
        }

        change(e: any) {
            const file: File | undefined = e.target.files && e.target.files[0];
            if (!file) return this.clear();
            fileCompress.compressImgFromFile(file)
                .then(([filename, result]) => {
                    // this.setShowData(result);
                    filename = this.prefixPath + md5(result) + ".jpg";

                    dataURLtoBlob(result)
                        .then((blob: any) => {
                            this.setLoading();
                            return upload(filename, blob);
                        })
                        .then(r => {
                            this.clearLoading();
                            this.setShowData(r);
                        })
                        .catch((err) => {
                            this.clearLoading();
                            this.error(err);
                        })
                })
                .catch(([filename, err]) => {
                    console.debug(err);
                    this.error(err);
                })
        }

        uploadFile() {

        }
    }
</script>
