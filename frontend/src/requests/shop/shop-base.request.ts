import {http} from "@ztwx/http";

export const queryAllInfo=()=>{
    return http.xhr("post","shop/allInfo");
};
