package com.ztwx.mask.dao;

import com.ztwx.mask.controller.params.UserLoginParams;
import com.ztwx.mask.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    public UserEntity userLogin(UserLoginParams userLoginParams);

    public boolean userRegister(UserEntity userEntity);

    public Integer writeLoginDate(@Param("id")Long id);
}
