import {http} from "@ztwx/http";
import {UpdateById, UpdateMulti} from "@/requests/manage/publicReq.interface";

export interface HomeShopNavItem{
    id?:number;
    name?:string;
    des?:string;
    createDate?:string;
    img?:string;
    classifyId?:string;
    href?:string;
    toOrder?:number;
    type?:string;
}


export const reqInsertShopNav=(p:HomeShopNavItem)=>{
    return http.xhr("post","manage/m/insertShopHomeNav",p)
};

export const reqUpdateShopNavItem=(p:UpdateById<HomeShopNavItem,number>)=>{
  return http.xhr("post","manage/m/updateShopHomeNav",p);
};

export const reqUpdateShopNavItemMulti=(p:UpdateMulti<HomeShopNavItem>)=>{
    return http.xhr("post","manage/m/updateShopHomeNavMulti",p)
};

export const reqDeleteShopNavItem=(id:number)=>{
    return http.xhr("post","manage/m/deleteShopHomeNavItem",{id})
};

export const reqQueryShopNavItem=(type:string|undefined=undefined)=>{
    return http.xhr("post","manage/queryShopHomeNavList",{
        type
    })
};
