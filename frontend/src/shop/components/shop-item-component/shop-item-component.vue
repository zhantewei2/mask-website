<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-22 18:59:2
-->

<template>
    <div :class="[
        primary?'shop-item-card-primary':'shop-item-card-secondary'
    ]">
        <lazy-image @click="click" class="shop-item-image" :src="itemRef.img"/>
        <header @click="click">
            {{itemRef.name}}
        </header>
        <footer v-if="!primary">
            <el-button @click="click" type="primary">Learn More</el-button>
        </footer>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Prop} from "vue-property-decorator";

    export interface ItemRef {
        img: string;
        name: string;
        infoId?: string; //to info
        listId?: string; // to list
    }

    @Component({})
    export default class extends Vue {
        @Prop({}) itemRef: ItemRef;
        @Prop({default: false}) primary: boolean;

        click(e: any) {
            this.$emit("navClick", "")
        }

    }
</script>
<style scoped src="./shop-item-component.scss" lang="scss"></style>