package com.ztwx.mask.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
public class UserEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String account;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @NotBlank
    private String password;
    private Date createDate;
    private Date lastLogin;
    private Date updateDate;
    private String ticket;
}
