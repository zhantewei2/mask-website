package com.ztwx.mask.controller.params;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryByTypeParams<T>{
    private T type;
}
