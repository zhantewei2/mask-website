package org.cm.pro.link.testFactory.params;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class LinkTestParam {

    @NotBlank
    private String name;
    private String content;


}
