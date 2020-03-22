package com.ztwx.mask.controller.params;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserLoginParams {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
