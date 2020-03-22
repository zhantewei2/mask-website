package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cm.pro.entity.CustomerInteractEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 创建者: GQ
 * 创建时间:2019/12/20 5:52 PM
 */
@Getter
@Setter
@ToString
@ApiModel("添加客户互动记录")
public class CustomerInteractParam {

    @NotEmpty
    @ApiModelProperty("客户互动列表")
    private List<CustomerInteractEntity> list;
}
