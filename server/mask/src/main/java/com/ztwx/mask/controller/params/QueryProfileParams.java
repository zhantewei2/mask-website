package com.ztwx.mask.controller.params;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class QueryProfileParams<T>{
    @Min(0)
    private Integer currentPage;
    @Min(0)
    private Integer pageSize;
    private T query;
}
