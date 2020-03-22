package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author hht
 * @description 分页公共参数
 * @date 2019/12/9
 */
@Getter
@Setter
@ToString
@ApiModel("分页公共参数")
public class PageCommonParams {

    @ApiModelProperty(value = "分页", example = "1")
    @NotNull
    private Integer pageNum;

    @ApiModelProperty(value = "分页大小", example = "20")
    @NotNull
    private Integer pageSize;
}
