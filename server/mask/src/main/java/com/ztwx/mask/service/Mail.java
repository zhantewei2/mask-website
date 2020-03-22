package com.ztwx.mask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mail {
    @Autowired
    public JavaMailSender emailSender;

    public void sendMail(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("iowa_email_01@163.com");
        mailMessage.setTo("327730684@qq.com");
        mailMessage.setSubject("testOne");
        mailMessage.setText("hello world");

        emailSender.send(mailMessage);
    }
}
