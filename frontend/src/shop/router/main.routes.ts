import Vue from 'vue'
import VueRouter, {Route} from 'vue-router'
import ShopMainPage from "../views/shop-main-page/shop-main-page.vue";
import ShopListPage from "../views/shop-list-page/shop-list-page.vue";
import ShopInfoPage from "../views/shop-info-page/shop-info-page.vue";
import ConCatUsPage from "../views/shop-cancat-us-page/shop-cancat-us-page.vue";
import ErrPage from "../views/err-page/err-page.vue";

Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: "/", component: ShopMainPage,
        },
        {
            path: "/list/:id", component: ShopListPage,
        },
        {
            path: "/info/:id", component: ShopInfoPage,
        },
        {
            path: "/concatUs", component: ConCatUsPage,
        },
        {
            path:"/err",component: ErrPage
        }
    ]
});


export default router
