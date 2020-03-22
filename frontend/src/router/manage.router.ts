import { IceRouterConfig } from "./iceRouterConfig.interface";
const routes:IceRouterConfig[]=[
    {path:"shopList",component:()=>import("../views/manage/shopList-page/shopList-page.vue"),pageName:"商品列表"},
    {path:"shopClassify",component:()=>import("../views/manage/shopClassify-page/shopClassify-page.vue"),pageName:"商品类别管理"},
    {path:"shopAdd",component:()=>import("../views/manage/shopAdd-page/shopAdd-page.vue"),pageName:"新增商品"}
];
export default routes;