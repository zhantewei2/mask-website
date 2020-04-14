package com.ztwx.mask.controller.Result;

import com.ztwx.mask.entity.KeyValue;
import com.ztwx.mask.entity.ShopClass;
import com.ztwx.mask.entity.ShopHomeNavItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QueryAllInfoResult {
    List<ShopHomeNavItem> shopHomeNavItemList;
    List<KeyValue> keyValueList;
    List<ShopClass> shopClassList;
}
