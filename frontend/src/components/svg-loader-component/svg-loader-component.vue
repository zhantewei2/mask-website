<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-23 1:11:25
-->

<template>
   <span>
        <transition name="animate-abs-fade">
        <div class="yo-loading-block"
             :class="[top?'yo-loading-fix':'']"
             v-if="show" v-once>
            <img :style="{
                top:top||undefined
            }" class="svg" src="image/load.svg"/>
        </div>
        </transition>
    </span>
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Prop} from "vue-property-decorator";

    @Component({})
    export default class extends Vue {
        @Prop({default: false}) show: boolean;
        @Prop({}) top: string;
    }
</script>
