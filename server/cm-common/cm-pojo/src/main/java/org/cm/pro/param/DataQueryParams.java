package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hht
 * @description 查询条件-日、周、月
 * @date 2019/12/17
 */
@Getter
@Setter
@ToString
@ApiModel("查询条件-日、周、月")
public class DataQueryParams extends PageCommonParams{

    @ApiModelProperty("日/天")
    private Integer day;

    @ApiModelProperty("姓名/手机号搜索")
    private String searchValue;

    @ApiModelProperty("周")
    private Integer week;

    @ApiModelProperty("月")
    private Integer month;

    @ApiModelProperty("0：待确认试驾列表，1：预约到店列表")
    private int types;

    @ApiModelProperty("试驾下拉框，格式：yyyy-MM")
    private String date;
}
