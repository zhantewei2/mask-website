import {http} from "ztwx-fire-ui/http";
import {Observable, of, throwError} from "rxjs";


export const findClassList = () => {
    return http.xhr("get", "manage/queryShopClass");
};

export interface InsertShopParams {
    name: string;
}

export const insertShopClass = (p: InsertShopParams) => {
    return http.xhr("post", "manage/m/insertShopClass", p);
};

export interface UpdateShopParams {
    name?: string;
    id: number;
    enabled?: number;
}


export const updateShopClass = (p: UpdateShopParams) => {
    return http.xhr("post", "manage/m/updateShopClass", p);
};


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
}