import {http} from "ztwx-fire-ui/http";

export interface UpdateParams<T> {
    id: any;
    body: T;
}


export const findClassList = (main: boolean | undefined = undefined) => {
    return http.xhr("get", "manage/queryShopClass",
        main === undefined ? undefined : {main: main ? 1 : 0});
};

export interface InsertShopParams {
    name: string;
    isMain: boolean;
    parentClass: number;
}

export const insertShopClass = (p: InsertShopParams) => {
    return http.xhr("post", "manage/m/insertShopClass", p);
};

export interface UpdateShopClassParams {
    name?: string;
    id: number;
    enabled?: number;
    parentClass?:number;
    toOrder?:number;
}


export const updateShopClass = (p: UpdateShopClassParams) => {
    return http.xhr("post", "manage/m/updateShopClass", p);
};
export const updateShopClassMulti=(list:UpdateShopClassParams[])=>
    http.xhr("post","manage//m/updateShopClassMultiple",{
        list
    });


export const reqInsertShop = (p: any) => {
    return http.xhr("post", "shop/m/insertShop", p);
};

export interface QueryShopParams {
    currentPage: number;
    pageSize: number;
    query?: any;
}

export const reqQueryShop = (p: QueryShopParams) => {
    return http.xhr("post", "shop/queryShop", p);
};

export const reqShopInfo = (id: string) => {
    return http.xhr("post", "shop/shopInfo", {
        id
    });
};

export const reqRemoveShop = (id: string) => {
    return http.xhr("post", "shop/m/deleteShop", {
        id
    })
};

export const reqUpdateShop = (p: UpdateParams<any>) => {
    return http.xhr("post", "shop/m/updateShop", p);
};