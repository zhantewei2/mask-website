package org.cm.pro.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 创建者: GQ
 * 创建时间:2019/11/1 10:19 AM
 */
@Getter
@Setter
@ToString
@ApiModel("数据字典")
public class DictDataEntity implements Serializable {

    @ApiModelProperty("公司id")
    private String companyId;

    @ApiModelProperty("字典id")
    private String dictId;

    @ApiModelProperty("字典状态")
    private String dictStatus;

    @ApiModelProperty("字典类型code")
    private String dictTypeCode;

    @ApiModelProperty("字典类型描述")
    private String dictTypeDesc;

    @ApiModelProperty("字典code")
    private String dictCode;

    @ApiModelProperty("字典描述")
    private String dictDesc;

}
