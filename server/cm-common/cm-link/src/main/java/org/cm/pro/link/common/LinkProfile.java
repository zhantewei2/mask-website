package org.cm.pro.link.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LinkProfile<T>{
    private T params;
    private String type;
}
