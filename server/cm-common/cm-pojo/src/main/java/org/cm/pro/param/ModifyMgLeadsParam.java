package org.cm.pro.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@ApiModel("修改中台线索信息")
public class ModifyMgLeadsParam implements Serializable {

    @NotNull
    @ApiModelProperty("线索id")
    private String leadsId;

    @NotNull
    @ApiModelProperty("公司id")
    private String companyId;

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
    private String repeatedTimes;

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
    private Date createDate;

    private String updateByEmpId;

    private String updateByLoginId;

    private Date updateDate;

    @JsonIgnore
    private Integer updateVersion;

    @JsonIgnore
    private Long deleteByLoginId;

    @JsonIgnore
    private Date deleteDate;

    @JsonIgnore
    private String deleteRemark;
}
