package com.zy.service;


import com.zy.mapper.getAllUrlMapper;
import com.zy.model.User;
import com.zy.model.UserURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class getAllURL {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private getAllUrlMapper getAllUrlMapper;

    public Vector<UserURL> getAllURL(){
        Vector<UserURL> res = getAllUrlMapper.getAllUrl();
        if (res == null){
            logger.warn("getAllURL 结果为空");
            return null;
        }
        return res;
    }
}
