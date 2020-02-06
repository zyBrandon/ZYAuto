package com.zy.service;

import com.zy.mapper.getUsernameAndPassMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class getUsernameAndPass {

    @Autowired
    private com.zy.mapper.getUsernameAndPassMapper getUsernameAndPassMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean getUsernameAndPass(String username,String pass){
        int res = getUsernameAndPassMapper.selectUseranameAndPass(username,pass);
        if (res == 1){
            return true;
        } else {
            logger.warn("getUsernameAndPass查询失败");
            return false;
        }
    }

}
