import { IceRouterConfig } from "./iceRouterConfig.interface";
const routes:IceRouterConfig[]=[
    {path:"shopList",component:()=>import("../views/manage/shopList-page/shopList-page.vue"),pageName:"商品列表"},
    {path:"shopClassify",component:()=>import("../views/manage/shopClassify-page/shopClassify-page.vue"),pageName:"商品类别管理"},
    {path:"shopAdd",component:()=>import("../views/manage/shopAdd-page/shopAdd-page.vue"),pageName:"新增商品"},
    {path:"shopCarousel",pageName:"首页轮播列表",component:()=>import("../views/manage/shopCarousel-page/shopCarousel-page.vue")},
    {path:"shopNav",pageName:"新增商品轮播导航",component:()=>import("../views/manage/shopHomeNavItem-page/shopHomeNavItem-page.vue")},
    {path:"shopNavManage",pageName:"首页导航图列表",component:()=>import("../views/manage/shopNavManage-page/shopNavManage-page.vue")}

];
export default routes;