package com.zy.service;

import com.zy.mapper.addUrlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class addURL {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private addUrlMapper addUrlMapper;

    public boolean addURL(String username,String url){
        if (getParams(username,url) == false){
            logger.warn("addURL参数错误");
            return false;
        }

        getUserUrlHave getUserUrlHave = new getUserUrlHave();
        boolean res = getUserUrlHave.getUserUrlHave(username, url);
        if (res == false) {
            return false;
        }

        int result = addUrlMapper.addUrl(username,url);
        if (result == 1){
            return true;
        }

        return false;

    }

    public boolean getParams(String username,String url){
        if (username == null || url == null){
            return false;
        }
        if (username.length() > 20 || username.length() > 200){
            return false;
        }
        return true;
    }
}
