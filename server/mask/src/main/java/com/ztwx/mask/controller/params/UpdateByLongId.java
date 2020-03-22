package com.ztwx.mask.controller.params;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateByLongId<T> {
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull
    private Long id;
    @NotNull
    private T body;
}
