package com.ztwx.mask.controller;

import com.ztwx.mask.config.Setting;
import com.ztwx.mask.controller.params.InsertShopClassParams;
import com.ztwx.mask.controller.params.QueryShopClass;
import com.ztwx.mask.controller.params.UserLoginParams;
import com.ztwx.mask.entity.ShopClass;
import com.ztwx.mask.entity.UserEntity;
import com.ztwx.mask.service.ShopService;
import com.ztwx.mask.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.cm.pro.HttpException.ReqBad;
import org.cm.pro.HttpException.ReqBadEnum;
import org.cm.pro.utils.ZTWMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @PostMapping("/registerUser")
    public boolean RegisterUser(
            @Validated @RequestBody UserEntity userEntity,
            BindingResult bindingResult
    ){
        ZTWMethod.ValCheck(bindingResult);
        return userService.userRegister(userEntity);
    }
}
