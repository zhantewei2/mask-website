import {session} from "../../utils/Session";
import {http} from "../../utils/Http";
import {Module,ActionContext} from "vuex";

import {loginFromAccount,loginFromTicket,LoginParams,LoginResult,logout} from "../../requests/core/core.requests";


export interface UserState{
    account:string;
    name:string;      //用户名称
    positionName?:string;  //岗位名称
    positionNum?:number;  //岗位编码
    ticket:string;        //用户ticket
    header:string;      //用户头像
    lastLogin:string;
}


const store:Module<UserState,any>={
    namespaced:true,
    state:{
        account:"",
        name:"",
        ticket:"",
        header:"",
        positionName:"管理员",
        lastLogin:""
    },
    mutations:{
        changeUserInfo(state:UserState,userInfo:UserState){
            Object.assign(state,userInfo);
            if(userInfo.ticket){
                //修改http 请求器的ticket
                http.setTicketValue(userInfo.ticket);
                //修改session值
                session.setSession(userInfo.ticket);
            }
        },
        clearUser(state:UserState){
            http.setTicketValue("");
            session.clearSession();
        }
    },
    actions:{
        /**
         * 用户登录
         * @param commit
         * @param params
         */
        loginFromAccount(
            {commit,dispatch}:ActionContext<UserState, any>,
            params:LoginParams
        ){
            loginFromAccount(params).subscribe((result:LoginResult)=>{
                //保存用户信息
                commit("changeUserInfo",result);
                //发送登录成功状态
                dispatch("loginSuccess")
            },()=>dispatch("loginFailure"))
        },
        /**
         * 用户登录从ticket
         * @param commit
         * @param ticket
         */
        loginFromTicket(
            {commit}:ActionContext<UserState, any>,
            {ticket,callback }:any
        ){
            loginFromTicket(ticket).subscribe((result:LoginResult)=>{
                //保存用户信息
                /**
                 * 回调函数，注意返回用户ticket
                 */

                commit("changeUserInfo",result);
                callback(result.ticket);
            },()=>callback(""))
        },
        /**
         * 登录失败
         */
        loginFailure(){},
        /**
         * 该状态由登录页面，或多个effects监听
         */
        loginSuccess(){},
        /**
         * 登出empty action
         */
        logoutSuccess(){},
        /** 用户登出
         *
         * @param commit
         */
        logout(
            {commit,dispatch}:ActionContext<UserState, any>
        ){
            logout().subscribe(()=>{
                commit("clearUser");
                dispatch("logoutSuccess");
            },()=>{})
        },
        logExpired({commit}){
            commit("clearUser");
        }
    }

};

export default store;