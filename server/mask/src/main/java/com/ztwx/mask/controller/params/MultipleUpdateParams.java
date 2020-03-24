package com.ztwx.mask.controller.params;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class MultipleUpdateParams<T> {
    @NotNull
    private List<T> list;
}
