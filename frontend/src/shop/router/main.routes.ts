import Vue from 'vue'
import VueRouter from 'vue-router'
import ShopMainPage from "../views/shop-main-page/shop-main-page.vue";
import ShopListPage from "../views/shop-list-page/shop-list-page.vue";
import ShopInfoPage from "../views/shop-info-page/shop-info-page.vue";
import ConCatUsPage from "../views/shop-cancat-us-page/shop-cancat-us-page.vue";

Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: "/", component: ShopMainPage,
        },
        {
            path: "/list/:id", component: ShopListPage
        },
        {
            path: "/info/:id", component: ShopInfoPage
        },
        {
            path: "/concatUs", component: ConCatUsPage
        }
    ]
});

export default router
