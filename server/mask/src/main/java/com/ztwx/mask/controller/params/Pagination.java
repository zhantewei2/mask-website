package com.ztwx.mask.controller.params;

import com.ztwx.mask.entity.ShopClass;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Pagination {
    public static <T> HashMap paramsToMap(QueryProfileParams<T> queryProfileParams){
        HashMap m=new HashMap();
        Integer pageSize=queryProfileParams.getPageSize();
        m.put("skip",(queryProfileParams.getCurrentPage()-1)*pageSize);
        m.put("limit",pageSize);
        entityToMap(queryProfileParams.getQuery(),m);
        return m;
    }

    public static <T> void entityToMap(T entity,Map m){
        if(entity==null)return;
        Class<?> c=entity.getClass();
        Field[] fields=c.getDeclaredFields();
        for(Field f:fields){
            String fieldName=f.getName();
            Method method;
            Object value;
            try {
                method = c.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            }catch (Exception e){
                continue;
            }
            try {
                value=method.invoke(entity);
            }catch (Exception e){
                continue;
            }
            if(value!=null)m.put(fieldName,value);
        }
    }
}
