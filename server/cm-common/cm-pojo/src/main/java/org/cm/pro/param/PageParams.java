package org.cm.pro.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 创建者: GQ
 * 创建时间:2019/12/18 4:49 PM
 */
@Getter
@Setter
@ToString
public class PageParams {

    @NotNull
    @ApiModelProperty("分页")
    private Integer pageNum;

    @NotNull
    @ApiModelProperty("分页大小")
    private Integer pageSize;
}
