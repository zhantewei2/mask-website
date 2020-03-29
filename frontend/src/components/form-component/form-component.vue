<!--
    auto created by @ztwx vue template!!
    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-3-20 2:10:29
-->

<template>
    <div class="ice-form-tag yo-form"
     :class="[size?'yo-form-size-'+size:'']"
    >
        <slot></slot>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import {Component, Prop, Watch} from "vue-property-decorator";
    import {Controller, Form} from "ztwx-fire-ui/form";

    @Component({
        name: "ice-form"
    })
    export default class extends Vue {
        @Prop()size:"mini"|undefined;
        formName: string = "ice-form";
        @Prop({}) form: Form;

        @Watch("form", {immediate: true})
        watchForm(form: Form) {
            this.controllerDict = form.controllerDict;
        }

        controllerDict: any = {};

        findFormIds(children: any): any {
            const controllers: any = [];
            const find = (children: any) => {
                if (!children || !children.length) return;
                children.forEach((child: any) => {
                    if (child.$attrs["form-id"]) {
                        controllers.push(child);
                    } else {
                        find(child.$children);
                    }
                })
            };
            find(children);
            return controllers;

        }
    }
</script>
<style scoped src="./form-component.scss" lang="scss"></style>