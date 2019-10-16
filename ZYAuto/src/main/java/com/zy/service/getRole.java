package com.zy.service;

import com.zy.mapper.getUserByUsername;
import com.zy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class getRole {

    @Autowired
    private getUserByUsername getUserByUsername;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public User getRole(String username){
        if (getParams(username) == false){
            logger.warn("getRole参数错误");
            return null;
        }

        User user = getUserByUsername.getUserByUsername(username);
        if (user == null){
            logger.warn("getRole getUserByUsername为空");
        }
        return user;

    }

    public boolean getParams(String username){
        if (username == null || username.length() > 20){
            return false;
        }
        return true;
    }

}
