<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-22 22:44:59
-->

<template>
    <div class="shop-itd">
        <div class="name">
            <slot name="name"></slot>
        </div>
        <div class="content">
            <slot name="content"></slot>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Prop} from "vue-property-decorator";

    @Component({})
    export default class extends Vue {
        @Prop({}) name: string;
        @Prop({}) content: string;
    }
</script>
<style scoped src="./itd-component.scss" lang="scss"></style>