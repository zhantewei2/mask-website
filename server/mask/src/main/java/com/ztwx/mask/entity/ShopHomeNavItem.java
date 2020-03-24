package com.ztwx.mask.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
public class ShopHomeNavItem {
    private Integer id;

    @NotBlank
    private String name;
    private String des;
    private Date createDate;
    @NotBlank
    private String img;
    private Integer classifyId;
    private String href;
    private Integer toOrder;
    private String type;
}
