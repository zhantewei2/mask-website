package com.ztwx.mask.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Shop {
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;
    private String name;
    private Float price;
    private String img;
    private Integer vestIn;
    private Date createDate;
    private Date updateDate;


    private String type;
    private String imgs;
    private String box;
    private String ctn;
    private String dimension;
    private Integer GW;
    private Integer NW;
    private ShopClass vestRef;
}
