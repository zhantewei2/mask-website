<!--
    auto created by @ztwx vue template!!

    @pageAuthor  :  zhan
    @AuthorEmail :  zhantewei@gmail.com
    @pageCreated :  2020-2-17 14:1:1
-->

<template src="./login-page.html">
</template>

<script lang="ts">
import Vue from "vue";
import {Component} from "vue-property-decorator";
import {projectName,providerName} from "@config";

@Component({})
export default class extends Vue{
    projectName:string=projectName;
    providerName:string=providerName;

    //登录相关
    account:string="";
    password:string="";
    saveAccount:boolean=false;

    loading:boolean=false;
    pageLogin(){
        if(this.loading)return;

        if(!this.account||!this.password){
            this.$store.dispatch("err","账号密码填写不全");
            return;
        }
        this.loading=true;
        this.$store.dispatch("user/loginFromAccount",{
            "username":this.account,
            "password":this.password
        })
    }

    actionUnsubscribe:any;
    created(){
        this.actionUnsubscribe=this.$store.subscribeAction((action,state)=>{
            if(action.type==="user/loginSuccess"){
                this.$router.push("/home/weclome");
                this.loading=false;
            }
            if(action.type=="user/loginFailure"){
                this.$store.dispatch("err","账号或密码错误");
                this.loading=false;
            }

        });
    }

    mounted(){
        /**
         * element input cant not bind keypress event
         */
        const pass:Vue=(this.$refs as any).pass;
        const input:HTMLInputElement|null=pass.$el.querySelector("input");
        if(!input)return;
        input.addEventListener("keypress",(e:any)=>{
            const charCode=e.which||e.keyCode;
            if(charCode==13)this.pageLogin();
        })
    }

    beforeDestroy(){
        this.actionUnsubscribe();
    }

}
</script>
<style scoped src="./login-page.scss" lang="scss"></style>