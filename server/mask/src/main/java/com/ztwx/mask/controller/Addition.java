package com.ztwx.mask.controller;

import com.ztwx.mask.service.Mail;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api("Addition")
@RestController
@RequestMapping("/addition")
public class Addition {

    @Autowired
    private Mail mail;

    @PostMapping("/sendMail")
    public boolean sendMail(){
        mail.sendMail();
        return true;
    }
}
