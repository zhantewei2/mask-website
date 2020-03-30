import {http} from "ztwx-fire-ui/http";

export const queryAllInfo=()=>{
    return http.xhr("post","shop/allInfo");
};