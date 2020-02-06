package com.zy.service;

import com.zy.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class addUsernameRedis {

    private final static String land = "land";
    private final static long time = 2000;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    public boolean addUsernameRedis(String username){
        //
        boolean res = redisUtil.set(username,land,time);
        if (res == true){
            return true;
        } else {
            logger.warn("addUsernameRedis添加redis失败");
            return false;
        }
    }
}
