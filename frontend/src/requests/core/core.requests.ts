import {http} from "@ztwx/http";
import {Observable,of,throwError} from "rxjs";
import {mergeMap} from "rxjs/operators";


/**
 * 用户账号密码登录
 * @param params
 */
export interface LoginParams{
    username:string;
    password:string;
}
export interface LoginResult{
    ticket:string;
    account:string;
    id:string;
    lastLogin:string;
    name:string;
}
export const loginFromAccount=(params:LoginParams):Observable<LoginResult>=>{

    return http.xhr("post","manage/login",params); //从后台请求数据
};

/**
 * 用户从ticket中登录
 * @param ticket
 */
export const loginFromTicket=(ticket:string):Observable<LoginResult>=>{
    return http.xhr("post","/manage/m/loginFromTicket");
};

/**
 * 用户登出
 */
export const logout=():Observable<any>=>{
    // return of(true).pipe(mergeMap(()=>throwError("11")))
    return of(true);
};

export const loginExpired=():Observable<any>=>{
    return http.xhr("post","/manage/m/loginExpired");
};
