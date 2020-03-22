package com.ztwx.mask.config;

import lombok.extern.slf4j.Slf4j;
import org.cm.pro.utils.ZTWUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Slf4j
@Configuration
public class BeanConfiguration {
//    @Bean
//    public JavaMailSender getJavaMailSender(){
//        JavaMailSenderImpl mailSende=new JavaMailSenderImpl();
//
//    }
    @Autowired
    private Setting setting;

    @Bean
    public ZTWUser ztwUser(){
        return new ZTWUser("ztwxKey","ztwxIV",setting.ticketExpires);
    }

}
