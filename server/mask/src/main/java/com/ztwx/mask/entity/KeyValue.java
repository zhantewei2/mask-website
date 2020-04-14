package com.ztwx.mask.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class KeyValue {
    @NotBlank
    String k;
    String v;
    String des;
}
