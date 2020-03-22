package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@ApiModel("查找中台线索")
public class QueryMgLeadsInfoParams implements Serializable {

    @NotNull
    @ApiModelProperty("中台线索id数组")
    private List<String> ids;

    @NotNull
    @ApiModelProperty("companyId")
    private String companyId;
}

