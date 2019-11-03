package com.zy.service;

import com.zy.mapper.deleteUrlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deleteURL {

    @Autowired
    private deleteUrlMapper deleteUrlMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean deleteURL(String username,String url){
        if (getParams(username,url) == false){
            logger.warn("参数为空");
            return false;
        }
        int res = deleteUrlMapper.deleteUrl(username, url);
        if (res == 0){
            logger.warn("删除url失败");
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
