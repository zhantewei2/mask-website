package org.cm.pro.param;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cm.pro.entity.DailyWorkEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@ToString
@ApiModel("添加多条dailywork")
public class AddDailyWorksParam {
    @NotEmpty
    private List<DailyWorkEntity> list;
}
