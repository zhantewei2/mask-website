package com.ztwx.mask.controller.Result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QueryProfileResult <T>{
    private Long total;
    private List<T> list;
    private Integer currentPage;
}
