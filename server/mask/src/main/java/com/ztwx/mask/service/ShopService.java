package com.ztwx.mask.service;

import com.ztwx.mask.controller.Result.QueryProfileResult;
import com.ztwx.mask.controller.params.*;
import com.ztwx.mask.dao.ShopDao;
import com.ztwx.mask.entity.Shop;
import com.ztwx.mask.entity.ShopClass;
import com.ztwx.mask.entity.ShopSimple;
import lombok.extern.slf4j.Slf4j;
import org.cm.pro.HttpException.ReqBad;
import org.cm.pro.HttpException.ReqBadEnum;
import org.cm.pro.utils.ZTWMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ShopService {
    @Autowired
    private ShopDao shopDao;

    public boolean insertShopClass(InsertShopClassParams params){
        return shopDao.insertShopClass(params);
    }

    public boolean updateShopClass(ShopClass shopClass){
        ZTWMethod.CheckUpdate(shopDao.updateShopClass(shopClass));
        return true;
    }

    @Transactional
    public boolean updateShopClassMulti(List<ShopClass> listShopClass){
        for(ShopClass shopClass:listShopClass){
            ZTWMethod.CheckUpdate(shopDao.updateShopClass(shopClass));
        }
        return true;
    }

    public List<ShopClass> queryShopClass(Integer main){
        return shopDao.queryShopClass(main);
    }

    @Transactional
    public boolean insertShop(Shop shop){
        shop.setId(ZTWMethod.getUniqueId());
        shopDao.insertShop(shop);
        shopDao.insertShopInfo(shop);
        return true;
    }

    @Transactional
    public boolean deleteShop(Long shopId){
        shopDao.deleteShopInfo(shopId);
        shopDao.deleteShop(shopId);
        return true;
    }
    @Transactional
    public boolean updateShop(Shop shop){
        Integer u=0;
        Integer u2=0;
        if(
            shop.getName()!=null||shop.getPrice()!=null||shop.getImg()!=null||shop.getVestIn()!=null
        ){
            u=shopDao.updateShop(shop);
        }
        if(
            shop.getBox()!=null||shop.getCtn()!=null
            ||shop.getGW()!=null||shop.getImgs()!=null
            ||shop.getType()!=null||shop.getDimension()!=null
        ){
            u2=shopDao.updateShopInfo(shop);
        }
        return u>=1||u2>=1;
    }

    public QueryProfileResult<ShopSimple> queryShop(
            QueryProfileParams<ShopQueryParams> params
    ){
        HashMap query= Pagination.paramsToMap(params);
        List<ShopSimple> list= shopDao.listShop(query);
        Long total=(Long)shopDao.totalShop(query).get("total");
        QueryProfileResult<ShopSimple> queryProfileResult=new QueryProfileResult<ShopSimple>();
        queryProfileResult.setList(list);
        queryProfileResult.setCurrentPage(params.getCurrentPage());
        queryProfileResult.setTotal(total);
        return queryProfileResult;
    }

    public Shop infoShop(Long id){
        Shop shop=shopDao.infoShop(id);
        if(shop==null)throw new ReqBad(ReqBadEnum.FindEmpty);
        return shop;
    }
}
