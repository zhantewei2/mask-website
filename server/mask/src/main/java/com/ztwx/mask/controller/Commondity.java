package com.ztwx.mask.controller;

import com.ztwx.mask.controller.Result.QueryAllInfoResult;
import com.ztwx.mask.controller.Result.QueryProfileResult;
import com.ztwx.mask.controller.params.*;
import com.ztwx.mask.entity.Shop;
import com.ztwx.mask.entity.ShopSimple;
import com.ztwx.mask.service.ShopHomeService;
import com.ztwx.mask.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.cm.pro.utils.ZTWMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@Slf4j
@Api("shop")
public class Commondity {
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopHomeService shopHomeService;

    @ApiOperation("商品列表")
    @GetMapping("/shop")
    public String getShop(){
        return "{\"message\":\"ss\",\"code\":20000}";
    }

//    @ApiOperation("商品类型查看")
//    @GetMapping("/shopClasses")
//    public List<ShopClass> getShopClasses(){
//
//    }
    @PostMapping("/m/insertShop")
    public boolean InsertShop(
            @Validated @RequestBody InsertShopParams insertShopParams,
            BindingResult bindingResult
    )throws Exception{
        ZTWMethod.ValCheck(bindingResult);
        Shop shop=new Shop();
        ZTWMethod.objectAssign(shop,insertShopParams);
        return shopService.insertShop(shop);
    }

    @PostMapping("/m/updateShop")
    public boolean UpdateShop(
            @Validated @RequestBody UpdateByLongId<Shop> shopUpdate,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        Shop shop=shopUpdate.getBody();
        shop.setId(shopUpdate.getId());
        return shopService.updateShop(shop);
    }


    @PostMapping("/m/deleteShop")
    public boolean deleteShop(
            @Validated @RequestBody FromLongId fromLongId,
            BindingResult bindingResult
            ){
        ZTWMethod.ValCheck(bindingResult);
        return shopService.deleteShop(fromLongId.getId());
    }

    @PostMapping("/queryShop")
    public QueryProfileResult<ShopSimple> queryShop(
            @Validated @RequestBody QueryProfileParams<ShopQueryParams> queryProfileParams,
            BindingResult bindingResult
            ){
        ZTWMethod.ValCheck(bindingResult);
        return shopService.queryShop(queryProfileParams);
    }

    @PostMapping("/shopInfo")
    public Shop shopInfo(
            @Validated @RequestBody FromLongId fromLongId,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return shopService.infoShop(fromLongId.getId());
    }
    @PostMapping("/allInfo")
    public QueryAllInfoResult getQueryAllInfoResult(){
        QueryAllInfoResult queryAllInfoResult=new QueryAllInfoResult();
        queryAllInfoResult.setShopHomeNavItemList(this.shopHomeService.queryShopHomeNavList(null));
        queryAllInfoResult.setKeyValueList(this.shopHomeService.queryKeyValueMutil(null));
        queryAllInfoResult.setShopClassList(this.shopService.queryShopClass(null));
        return queryAllInfoResult;
    }
}
