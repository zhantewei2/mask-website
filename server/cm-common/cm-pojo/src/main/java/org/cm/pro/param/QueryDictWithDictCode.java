package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 创建者: GQ
 * 创建时间:2019/12/16 5:24 PM
 */
@Getter
@Setter
@ToString
@ApiModel("通过字典详情代码查询字典信息")
public class QueryDictWithDictCode implements Serializable {

    @NotNull
    @ApiModelProperty("字典代码")
    private String dictCode;
}
