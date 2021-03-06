package com.ztwx.mask.controller.params;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateById <T,G>{
    @NotNull
    private G id;
    @NotNull
    private T body;
}
