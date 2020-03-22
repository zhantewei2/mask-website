package com.ztwx.mask.config.interceptors;

import com.ztwx.mask.config.Setting;
import com.ztwx.mask.entity.UserEntity;
import com.ztwx.mask.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.cm.pro.HttpException.ReqBad;
import org.cm.pro.HttpException.ReqBadEnum;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SessionInterceptor extends HandlerInterceptorAdapter {
    UserService userService;
    Setting setting;
    public SessionInterceptor(
            UserService userService,
            Setting setting
    ){
        this.userService=userService;
        this.setting=setting;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest req,
            HttpServletResponse res,
            Object handle
    ){
        String sessionValue;
        try {
            sessionValue = req.getHeader(setting.ticket);
            if(sessionValue==null)throw new Exception();
        }catch (Exception e){
            throw new ReqBad(ReqBadEnum.NotAuth);
        }

        UserEntity userEntity=userService.userLoginFromTicket(sessionValue);
        req.setAttribute("userEntity",userEntity);
        req.setAttribute("ticket",userEntity.getTicket());
        return true;
    }
}
