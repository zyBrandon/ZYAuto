package com.zy.service;

import com.zy.mapper.getUserUrlHaveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class getUserUrlHave {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public getUserUrlHaveMapper getUserUrlHaveMapper;

    public boolean getUserUrlHave(String username,String url){
        if (getParams(username,url) == false){
            return false;
        }

        int res = getUserUrlHaveMapper.selectUrlByUsername(username,url);
        if (res == 0){
            return false;
        }

        return true;

    }

    public boolean getParams(String username,String url){
        if (username == null || url == null){
            return false;
        }
        return true;
    }
}
