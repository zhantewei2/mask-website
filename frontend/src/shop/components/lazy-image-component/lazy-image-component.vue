<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-22 21:7:10
-->

<template>
    <div ref="img" @click="click" class="ice-image-loader-wrapper">
        <div class="img an-fade-in"
             v-if="canLoad"
             :style="{
            backgroundImage:'url('+src+')'
             }">
        </div>
        <slot></slot>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Prop} from "vue-property-decorator";
    import {LazyManage} from "./LazyManage";

    const lazyManage = new LazyManage();

    @Component({})
    export default class extends Vue {
        @Prop({}) height: number;
        @Prop({}) width: number;
        @Prop({}) src: string;
        lazyOrder: any;
        canLoad: boolean = false;
        isLoaded: boolean = false;
        boundDistance: number = 30;

        mounted() {
            const imgEl: HTMLElement = (this.$refs as any).img;
            if (!imgEl) return;
            const imgElTop = lazyManage.getTop(imgEl);
            this.lazyOrder = lazyManage.windowScroller.subscribe(({scrollTop, scrollBottom}) => {
                if (imgElTop <= scrollBottom - this.boundDistance) this.loadImg();
            })
        }

        click(e: any) {
            this.$emit("click", e);
        }

        loadImg() {
            if (this.isLoaded) return;
            this.canLoad = true;
        }

        beforeDestroy() {
            this.lazyOrder && this.lazyOrder.unsubscribe();
        }
    }
</script>
<style scoped src="./lazy-image-component.scss" lang="scss"></style>