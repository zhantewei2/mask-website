package com.ztwx.mask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(value="setting.yml",encoding="utf-8")
public class Setting {
    @Value("${ice-ticket}")
    public String ticket;

    @Value("${ice-ticket-expires}")
    public Long ticketExpires;
}
