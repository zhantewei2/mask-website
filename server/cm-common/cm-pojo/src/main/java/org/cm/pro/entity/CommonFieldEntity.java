package org.cm.pro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author hht
 * @description 数据库表公共字段
 * @date 2019/12/9
 */
@Getter
@Setter
public class CommonFieldEntity {

    @ApiModelProperty("公司id")
    @JsonIgnore
    private Long companyId;

    @JsonIgnore
    private Date fileDate;

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

    @JsonIgnore
    private Long updateByEmpId;

    @JsonIgnore
    private Long updateByLoginId;

    @JsonIgnore
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
