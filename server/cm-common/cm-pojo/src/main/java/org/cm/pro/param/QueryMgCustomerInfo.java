package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 创建者: GQ
 * 创建时间:2019/12/10 3:44 PM
 */
@Getter
@Setter
@ToString
@ApiModel("查询客户统一输入信息参数")
public class QueryMgCustomerInfo implements Serializable {

    private String leadsId;
}
