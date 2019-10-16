package com.zy.service;

import com.zy.model.UserURL;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zy.mapper.*;

import java.util.ArrayList;
import java.util.Vector;

@Component
public class getAllURLByUserName {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private getAllURLByUserNameMapper getAllURLByUserNameMapper;

    public Vector<UserURL> getAllURLByUserName(String username){
        if (getParams(username) == false){
            return null;
        }
        Vector<UserURL> userURLS = getAllURLByUserNameMapper.selectURLByUsername(username);
        return userURLS;
    }

    public boolean getParams(String username){
        if (username == null){
            return false;
        }
        if (username.length() > 20){
            return false;
        }
        return true;
    }
}
