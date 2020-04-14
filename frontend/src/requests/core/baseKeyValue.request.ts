import {http} from "@ztwx/http";

export interface KeyValue{
    k:string;
    v:string;
}

export const reqDeleteKeyValue=(key:string)=>{
    return http.xhr("post","manage/deleteKeyValue",{id:key});
};

export const reqQueryKeyValue=(key:string)=>{
    return http.xhr("post","manage/queryKeyValue",{id:key});
};
export const reqQueryKeyValueMulti=(keys:string[])=>{
    return http.xhr("post","manage/queryKeyValueMulti",{list:keys})
};
export const reqUpdateKeyValue=(keyValue:KeyValue)=>{
    return http.xhr("post","manage/updateKeyValue",keyValue);
};

export const reqInsertKeyValue=(keyValue:KeyValue)=>{
    return http.xhr("post","manage/insertKeyValue",keyValue)
};
