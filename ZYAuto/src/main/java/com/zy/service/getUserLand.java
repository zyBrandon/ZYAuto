package com.zy.service;

import com.zy.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class getUserLand {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    public boolean getUserLand(String username){
        if (getParams(username) == false){
            logger.warn("getUserLand方法username返回false");
            return false;
        }

        String res = (String)redisUtil.get("mykey");
        logger.warn("----------redis获取到的数值为"+res);
        if (username.equals(res)){
            return true;
        }

        return false;



    }

    public boolean getParams(String username){
        if (null == username || username.length() > 20){
            return false;
        }
        return true;
    }

}
