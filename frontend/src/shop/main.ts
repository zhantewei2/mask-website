import Vue from 'vue'
import "../types";
import "../ice";
import "../utils/Http";
import App from './ShopApp.vue';
import ElementUi from "element-ui";
import "../styles/main.scss";
import "../components/components.module";
import VueRouter from "vue-router";

import router from "./router/main.routes";
import store from "./store/index";
import "./components.module";

Vue.config.productionTip = false;
Vue.use(ElementUi);


new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');