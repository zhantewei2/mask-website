import { NavListItem } from "../ice";

/**
 * 注意 path 去掉/home，取/home 后的路径 .
 */
export const navData: NavListItem[] = [
    {
        label: "系统管理", children: [
            {
                label: "系统管理", children: [
                    {
                        label: "商品管理", children: [
                            { label: "新增商品", path: "shopAdd" },
                            { label: "商品类型管理", path: "shopClassify" },
                            { label: "商品列表", path: "shopList" },
                        ]
                    },
                    {
                        label:"首页管理",children:[
                            {label:"首页导航图列表",path:"shopNavManage"},
                            {label:"首页轮播列表",path:"shopCarousel"},
                            {label:"新增商品轮播导航",path:"shopNav"}
                        ]
                    },
                    {
                        label:'基本信息',path:"keyValue"
                    }
                ]
            },
        ]
    },
];
