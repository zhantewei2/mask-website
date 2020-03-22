package org.cm.pro.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 创建者: GQ
 * 创建时间:2019/11/1 2:29 PM
 */
@Getter
@Setter
@ToString
public class DictDataParam {

    @NotNull
    private List<String> typeCodes;
}
