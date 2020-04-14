<template>
    <show-home-page>
        <router-view/>
    </show-home-page>
</template>
<script lang="ts">
    import {Component, Prop, Vue} from "vue-property-decorator";
    import ShowHomePage from "./commonViews/show-home-page/show-home-page.vue";

    @Component({
        components: {
            "show-home-page": ShowHomePage
        }
    })
    export default class extends Vue {
        @Prop({default: ""}) name!: string;

        constructor() {
            super();
        }

        unsubscribe: any;

        created() {

        }

        mounted() {
            this.unsubscribe = this.$store.subscribeAction(({type, payload}: any) => {
                //err
                if (type === "err") {
                    this.$message.error(payload);
                    //logout success
                } else if (type == "user/logoutSuccess") {
                    this.$router.push("/login");
                    this.$store.dispatch("alert", {
                        type: "success",
                        content: "登出成功"
                    })
                    //message
                } else if (type == "message") {
                    (this.$message as any)[payload.type].call(this, payload.content);
                    //alert
                } else if (type == "alert") {
                    this.$notify({
                        type: payload.type,
                        message: payload.content,
                        title: "",
                        duration: 2000
                    });
                    //login success
                } else if (type == "user/loginSuccess") {
                    this.$store.dispatch("alert", {
                        type: "success",
                        content: "欢迎登录"
                    })
                    //login expired
                } else if (type == "user/logExpired") {
                    this.$store.dispatch("alert", {
                        type: "warning",
                        content: "用户登录已过期，请重新登录"
                    });
                    this.$router.push("/login");
                } else if (type == "success") {
                    this.$message.success(payload);

                    //nav type handler
                } else if (type == "navList") {
                    this.$router.push(`/list/${encodeURIComponent(payload)}`);

                }else if(type=="href"){
                    window.open(payload);
                }
            });
        }

        beforeDestroy() {
            this.unsubscribe();
        }
    }
</script>
<style lang="scss">
</style>
