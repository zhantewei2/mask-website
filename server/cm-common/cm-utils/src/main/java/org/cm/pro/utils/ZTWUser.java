package org.cm.pro.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ZTWUser {
    private ZTWAES ztwaes;
    private Long sessionExpires; //milliseconds unit
    public ZTWUser(
            String aesKey,
            String aesIv,
            Long sessionExpires
    ){
        ztwaes=new ZTWAES(aesKey,aesIv);
        this.sessionExpires=sessionExpires;
    }

    /**
     * username password encrypt to session ticket
     * @param username
     * @param password
     * @return
     * @throws JsonProcessingException
     */
    public String getSimpleSession(
            String username,
            String password
    ) throws JsonProcessingException {
        Map m=new HashMap();
        m.put("u",username);
        m.put("p",password);
        m.put("s",new Date().getTime()+this.sessionExpires);
        ObjectMapper objectMapper=new ObjectMapper();
        return ztwaes.encrypt(objectMapper.writer().writeValueAsString(m));
    }

    /**
     * parse ticket to {u:username,p:password}
     *
     * @param ticket
     * @return
     */
    public Map validNamePassword(String ticket){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map m = objectMapper.readValue(ztwaes.decrypt(ticket), Map.class);
            Long expires = (Long) m.get("s");
            if (expires > new Date().getTime()) return m;
        }catch (Exception e){
        }
        return null;
    }

}
