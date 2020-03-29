package com.ztwx.mask.dao;

import com.ztwx.mask.entity.KeyValue;
import com.ztwx.mask.entity.ShopHomeNavItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.util.List;

@Repository
@Mapper
public interface ShopHomeDao {
    public void insertShopHomeNav(ShopHomeNavItem shopHomeNavItem);
    public Integer updateShopHomeNav(ShopHomeNavItem shopHomeNavItem);
    public Integer deleteShopHomeNav(@Param("id")Integer id);
    public List<ShopHomeNavItem> queryShopHomeNavItemList(@Param("type")String type);


    public Integer updateKeyValue(KeyValue keyValue);
    public Integer deleteKeyValue(@Param("key")String key);
    public void insertKeyValue(KeyValue keyValue);
    public KeyValue queryKeyValue(@Param("key")String key);
    public List<KeyValue> queryKeyValueMulti(@Param("keys")List<String> key);
}
