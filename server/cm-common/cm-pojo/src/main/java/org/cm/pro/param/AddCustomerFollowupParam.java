package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cm.pro.entity.CustomerFollowupEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 创建者: GQ
 * 创建时间:2019/12/23 3:10 PM
 */
@Getter
@Setter
@ToString
@ApiModel("添加一条客户跟进记录")
public class AddCustomerFollowupParam {

    @NotEmpty
    List<CustomerFollowupEntity> list;
}
