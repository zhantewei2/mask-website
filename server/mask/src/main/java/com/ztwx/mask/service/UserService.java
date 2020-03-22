package com.ztwx.mask.service;
import com.ztwx.mask.controller.params.UserLoginParams;
import com.ztwx.mask.dao.UserDao;
import com.ztwx.mask.entity.UserEntity;
import org.bouncycastle.cert.ocsp.Req;
import org.cm.pro.HttpException.ReqBad;
import org.cm.pro.HttpException.ReqBadEnum;
import org.cm.pro.utils.ZTWMethod;
import org.cm.pro.utils.ZTWUser;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * created by zhantewei
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ZTWUser ztwUser;

    /**
     * 账号密码登录
     * @param userLoginParams
     * @return
     */
    public UserEntity userLogin(
            UserLoginParams userLoginParams
    ){

        UserEntity userEntity=userDao.userLogin(userLoginParams);
        if(userEntity==null)throw new ReqBad(ReqBadEnum.FindEmpty);
        try {
            String ticket = ztwUser.getSimpleSession(userEntity.getName(), userEntity.getPassword());
            userEntity.setTicket(ticket);
        }catch (Exception e){
            throw new ReqBad(ReqBadEnum.Normal);
        }
        userDao.writeLoginDate(userEntity.getId());
        userEntity.setPassword(null);
        return userEntity;
    }

    /**
     * session 登录
     * @param ticket
     * @return
     */
    public UserEntity userLoginFromTicket(String ticket){
        Map userMap= ztwUser.validNamePassword(ticket);
        if (userMap==null) throw new ReqBad(ReqBadEnum.ExpiredLogin);
        UserLoginParams userLoginParams=new UserLoginParams();
        userLoginParams.setUsername((String)userMap.get("u"));
        userLoginParams.setPassword((String)userMap.get("p"));
        UserEntity userEntity=userDao.userLogin(userLoginParams);
        if(userEntity==null)throw new ReqBad(ReqBadEnum.FindEmpty);
        userEntity.setTicket(ticket);
        userEntity.setPassword(null);
        return userEntity;
    }


    /**
     * 注册
     * @param userEntity
     * @return
     */
    public boolean userRegister(UserEntity userEntity){
        userEntity.setId(ZTWMethod.getUniqueId());
        try {
            userDao.userRegister(userEntity);
        }catch (DuplicateKeyException e){
            throw new ReqBad(ReqBadEnum.InsertDup);
        }
        return true;
    }


}
