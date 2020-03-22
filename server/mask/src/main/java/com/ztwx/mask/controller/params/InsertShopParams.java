package com.ztwx.mask.controller.params;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class InsertShopParams {
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;
    @NotBlank
    private String name;

    private Float price;
    @NotBlank
    private String img;
    @NotNull
    private Integer vestIn;
    private String type;
    @NotBlank
    private String imgs;
    private String box;
    private String ctn;
    private String dimension;
    private Integer GW;
    private Integer NW;

    public void setPrice(Object v){
        int i=((Integer)v).intValue();
        this.price=(float)i;
    }
}
