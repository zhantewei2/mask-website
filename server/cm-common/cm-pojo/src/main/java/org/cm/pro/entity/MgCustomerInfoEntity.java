package org.cm.pro.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 创建者: GQ
 * 创建时间:2019/12/10 2:38 PM
 */
@Getter
@Setter
@ToString
@ApiModel("中台客户信息 用于客户统一视图")
public class MgCustomerInfoEntity implements Serializable {

    @ApiModelProperty("来源渠道类型")
    private String sourceChannelSubtype;

    @ApiModelProperty("来源活动类型")
    private String sourceActivityType;

    @ApiModelProperty("客户姓名")
    private String customerName;

    @ApiModelProperty("电话号")
    private String cellphone;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("身高")
    private String height;

    @ApiModelProperty("体重")
    private String weight;

    @ApiModelProperty("身份证号")
    private String idNo;

    @ApiModelProperty("爱好")
    private String hobby;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("性格")
    private String disposition;

    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("所在省")
    private String locationProvince;

    @ApiModelProperty("所在市")
    private String locationCity;

    @ApiModelProperty("预算")
    private String intentionBudget;

    @ApiModelProperty("行业")
    private String industry;

    @ApiModelProperty("职务")
    private String profession;

    @ApiModelProperty("沟通态度")
    private String communicationAttitude;
}
