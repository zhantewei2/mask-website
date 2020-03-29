package com.ztwx.mask.service;

import com.ztwx.mask.dao.ShopHomeDao;
import com.ztwx.mask.entity.KeyValue;
import com.ztwx.mask.entity.ShopHomeNavItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.cm.pro.HttpException.ReqBad;
import org.cm.pro.HttpException.ReqBadEnum;
import org.cm.pro.utils.ZTWMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ShopHomeService {
    @Autowired
    private ShopHomeDao shopHomeDao;

    public void insertShopHomeNav(ShopHomeNavItem shopHomeNavItem){
        try {
            shopHomeDao.insertShopHomeNav(shopHomeNavItem);
        }catch (Exception e){
            throw new ReqBad(ReqBadEnum.Normal);
        }
    }
    public boolean updateShopHomeNav(ShopHomeNavItem shopHomeNavItem){
        ZTWMethod.CheckUpdate(
            shopHomeDao.updateShopHomeNav(shopHomeNavItem)
        );
        return true;
    }
    @Transactional
    public boolean updateShopHomeNavMulti(List<ShopHomeNavItem> shopHomeNavItemList){
       for(ShopHomeNavItem item:shopHomeNavItemList){
           ZTWMethod.CheckUpdate(
                   shopHomeDao.updateShopHomeNav(item)
           );
       }
       return true;
    }

    public List<ShopHomeNavItem> queryShopHomeNavList(String type){
        return shopHomeDao.queryShopHomeNavItemList(type);
    }

    public boolean deleteShopHomeNav(Integer id){
        ZTWMethod.CheckUpdate(
                shopHomeDao.deleteShopHomeNav(id)
        );
        return true;
    }

    public void deleteKeyValue(String key){
                ZTWMethod.CheckUpdate(
        shopHomeDao.deleteKeyValue(key));
    }

    public void insertKeyValue(KeyValue keyValue){
        try {
            shopHomeDao.insertKeyValue(keyValue);
        }  catch (DuplicateKeyException e){
            throw new ReqBad(ReqBadEnum.InsertDup);
        }
    }

    public void updateKeyValue(KeyValue keyValue){
        ZTWMethod.CheckUpdate(
            shopHomeDao.updateKeyValue(keyValue)
        );
    }
    public KeyValue queryKeyValue(String key){
        return shopHomeDao.queryKeyValue(key);
    }

    public List<KeyValue> queryKeyValueMutil(List<String> keys){
        return shopHomeDao.queryKeyValueMulti(keys);
    }



}
