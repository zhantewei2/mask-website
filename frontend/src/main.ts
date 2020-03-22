import Vue from 'vue'
import "./types";
import "./ice";
import "./utils/Http";
import "./utils/lib/SessionLib";
import App from './App.vue';
import router from './router'
import store from './store'
import ElementUi from "element-ui";
import "./styles/main.scss";
import "./components/components.module";
import VueRouter from "vue-router";
import {http} from "@/utils/Http";

Vue.config.productionTip = false;
Vue.use(ElementUi);


new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
