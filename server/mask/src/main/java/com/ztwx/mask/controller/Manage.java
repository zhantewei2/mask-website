package com.ztwx.mask.controller;

import com.ztwx.mask.controller.params.*;
import com.ztwx.mask.entity.ShopClass;
import com.ztwx.mask.entity.ShopHomeNavItem;
import com.ztwx.mask.entity.UserEntity;
import com.ztwx.mask.service.ShopHomeService;
import com.ztwx.mask.service.ShopService;
import com.ztwx.mask.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.cm.pro.HttpException.ReqBad;
import org.cm.pro.HttpException.ReqBadEnum;
import org.cm.pro.utils.ZTWMethod;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@Api("Manage")
@RestController
@RequestMapping("/manage")
public class Manage {
    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopHomeService shopHomeService;
    /**
     * 新建商品类型
     * @param insertShopClassParams
     * @param bindingResult
     * @return
     */
    @PostMapping("/m/insertShopClass")
    public boolean insertShopClass(
            @Validated @RequestBody InsertShopClassParams insertShopClassParams,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return shopService.insertShopClass(insertShopClassParams);
    }

    @PostMapping("/m/updateShopClass")
    public boolean updateShopClass(
            @Validated @RequestBody ShopClass shopClass,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return shopService.updateShopClass(shopClass);
    }

    @GetMapping("/queryShopClass")
    public List<ShopClass> queryShopClass(
             QueryShopClass queryShopClass
            ){
        return shopService.queryShopClass(queryShopClass.getMain());
    }


    @PostMapping("/login")
    public UserEntity login(
            @Validated @RequestBody UserLoginParams userLoginParams,
            BindingResult bindingResult
            ){
        ZTWMethod.ValCheck(bindingResult);
        return userService.userLogin(userLoginParams);
    }

    @PostMapping("/m/loginFromTicket")
    public UserEntity loginFromTicket(
            @RequestAttribute("ticket")String ticket,
            @RequestAttribute("userEntity")UserEntity userEntity
    ){
        return userEntity;
    }


    @PostMapping("/m/loginExpired")
    public void loginExpired(){
        throw new ReqBad(ReqBadEnum.ExpiredLogin);
    }

    @PostMapping("/m/registerUser")
    public boolean RegisterUser(
            @Validated @RequestBody UserEntity userEntity,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return userService.userRegister(userEntity);
    }


    @PostMapping("/m/updateShopClassMultiple")
    public boolean updateShopClassMultiple(
            @Validated @RequestBody MultipleUpdateParams<ShopClass> multipleUpdateParams,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return shopService.updateShopClassMulti(multipleUpdateParams.getList());
    }

    @PostMapping("/m/insertShopHomeNav")
    public boolean insertShopHomeNav(
            @Validated @RequestBody ShopHomeNavItem shopHomeNavItem,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        shopHomeService.insertShopHomeNav(shopHomeNavItem);
        return true;
    }

    @PostMapping("/m/updateShopHomeNav")
    public boolean updateShopHomeNav(
            @Validated @RequestBody UpdateById<ShopHomeNavItem,Integer> updateParams,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return shopHomeService.updateShopHomeNav(updateParams.getBody());
    }

    @PostMapping("/m/updateShopHomeNavMulti")
    public boolean updateShopHomeNavMulti(
            @Validated @RequestBody MultipleUpdateParams<ShopHomeNavItem> multipleUpdateParams,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return shopHomeService.updateShopHomeNavMulti(multipleUpdateParams.getList());
    }

    @PostMapping("/queryShopHomeNavList")
    public List<ShopHomeNavItem> queryShopHomeNavList(
            @RequestBody QueryByTypeParams<String> queryByTypeParams
    ){
        return shopHomeService.queryShopHomeNavList(queryByTypeParams.getType());
    }

    @PostMapping("/m/deleteShopHomeNavItem")
    public boolean deleteShopHomeNavItem(
            @Validated @RequestBody FromId<Integer> fromId,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return shopHomeService.deleteShopHomeNav(fromId.getId());
    }

}
