package com.ztwx.mask.config.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrossInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            HttpServletRequest req,
            HttpServletResponse res,
            Object handle
    ){
        String method=req.getMethod();
        String url=req.getHeader("Origin");
        if(method.equals("OPTIONS")){
            Matcher m= Pattern.compile("https?://[^/]*").matcher(url);
            if(m.find()){
                res.setHeader("Access-Control-Allow-Origin",m.group(0));
                res.setHeader("Access-Control-Allow-Credentials","true");
                res.setHeader("Access-Control-Allow-Methods","GET,PUT,POST,OPTIONS");
                res.setHeader("Access-Control-Allow-Headers","Content-Type,cm_helper_auth,ztwx-ticket");
                res.setStatus(200);
            }
        }
        return true;
    }

}
