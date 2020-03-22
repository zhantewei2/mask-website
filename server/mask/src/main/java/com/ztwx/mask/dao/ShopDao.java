package com.ztwx.mask.dao;

import com.ztwx.mask.entity.Shop;
import com.ztwx.mask.entity.ShopClass;
import com.ztwx.mask.entity.ShopSimple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ShopDao {
    public boolean insertShopClass(@Param("name")String name);
    public Integer updateShopClass(ShopClass shopClass);
    public List<ShopClass> queryShopClass();

    public void insertShop(Shop shop);
    public void insertShopInfo(Shop shop);

    public boolean deleteShop(@Param("id")Long id);
    public Integer updateShop(Shop shop);
    public Integer updateShopInfo(Shop shop);
    public List<ShopSimple> listShop(HashMap queryMap);
    public Map totalShop(HashMap queryMap);
    public Shop infoShop(@Param("id")Long id);
}
