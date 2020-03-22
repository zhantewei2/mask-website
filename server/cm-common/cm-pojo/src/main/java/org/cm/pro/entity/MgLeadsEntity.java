package org.cm.pro.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建者: GQ
 * 创建时间:2019/12/4 5:02 PM
 */
@Getter
@Setter
@ToString
@ApiModel("中台线索实体")
public class MgLeadsEntity implements Serializable {

    @ApiModelProperty("线索id")
    private String leadsId;

    @ApiModelProperty("公司id")
    private Long companyId;

    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date fileDate;

    @ApiModelProperty("线索状态")
    private String leadsStatus;

    @ApiModelProperty("线索类型")
    private String leadsType;

    @ApiModelProperty("来源业务类型 线索")
    private String sourceBusinessTypeLeads;

    @ApiModelProperty("来源业务id")
    private String sourceBusinessId;

    @ApiModelProperty("来源渠道类型")
    private String sourceChannelClass;

    @ApiModelProperty("来源渠道大类")
    private String sourceChannelType;

    @ApiModelProperty("来源渠道小类")
    private String sourceChannelSubtype;

    @ApiModelProperty("来源活动类型")
    private String sourceActivityType;

    @ApiModelProperty("来源活动代码")
    private String sourceActivityCode;

    @ApiModelProperty("中台客户superid")
    private String mgSuperId;

    @ApiModelProperty("客户姓名")
    private String customerName;

    @ApiModelProperty("电话号")
    private String cellphone;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("所在省")
    private String locationProvince;

    @ApiModelProperty("所在城市")
    private String locationCity;

    @ApiModelProperty("线索说明")
    private String leadsDesc;

    @ApiModelProperty("是否重复")
    private String isRepeated;

    @ApiModelProperty("重复次数")
    private Integer repeatedTimes;

    @ApiModelProperty("意向省份")
    private String intentionProvince;

    @ApiModelProperty("意向城市")
    private String intentionCity;

    @ApiModelProperty("意向经销商")
    private String intentionDealer;

    @ApiModelProperty("意向等级")
    private String intentionLevel;

    @ApiModelProperty("意向购车时间 数据字典")
    private String intentionBuyInterval;

    @ApiModelProperty("意向购车时间 时间类型")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date intentionBuyDate;

    @ApiModelProperty("意向预算 数据字典")
    private String intentionBudget;

    @ApiModelProperty("意向预算 关注点")
    private String intentionAttention;

    @ApiModelProperty("意向车型大类 数据字典")
    private String intentionModelType;

    @ApiModelProperty("意向品牌")
    private String intentionBrand;

    @ApiModelProperty("意向车系")
    private String intentionSeries;

    @ApiModelProperty("意向车系年款")
    private String intentionSeriesYear;

    @ApiModelProperty("意向车型")
    private String intentionModel;

    @ApiModelProperty("意向外观颜色")
    private String intentionExteriorColor;

    @ApiModelProperty("意向内饰颜色")
    private String intentionInteriorColor;

    @ApiModelProperty("沟通态度")
    private String communicationAttitude;

    @ApiModelProperty("关注点")
    private String concerns;

    @ApiModelProperty("关注点备注")
    private String concernsRemark;

    @JsonIgnore
    private Long createByEmpId;

    @JsonIgnore
    private Long createByDeptId;

    @JsonIgnore
    private Long createByUnitId;

    @JsonIgnore
    private Long createByLoginId;

    @JsonIgnore
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createDate;

    @JsonIgnore
    private Long updateByEmpId;

    @JsonIgnore
    private Long updateByLoginId;

    @JsonIgnore
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date updateDate;

    @JsonIgnore
    private Integer updateVersion;

    @JsonIgnore
    private Long deleteByLoginId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date deleteDate;

    @JsonIgnore
    private String deleteRemark;
}
