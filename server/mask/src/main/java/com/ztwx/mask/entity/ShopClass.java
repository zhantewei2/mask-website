package com.ztwx.mask.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ShopClass {
    @NotNull
    private int id;
    private String name;
    private Integer enabled;
    private Integer main;
    private Integer parentClass;
    private ShopClass parentClassRef;
}
