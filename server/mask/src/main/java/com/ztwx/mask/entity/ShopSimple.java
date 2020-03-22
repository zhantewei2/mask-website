package com.ztwx.mask.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ShopSimple {
    @JsonSerialize(using= ToStringSerializer.class)
    private long id;
    private String name;
    private Float price;
    private String img;
    private Integer vestIn;
    private Date createDate;
    private Date updateDate;
    private ShopClass vestRef;
}
