package com.zy.service;

import com.zy.mapper.addResultMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class addResult {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private addResultMapper addResultMapper;

    public boolean addResult(String url,String res,String operator){
        if (getParams(url, res, operator) == false){
            logger.warn("addResult参数错误");
            return false;
        }

        String nowtime = getTime();

        int result = addResultMapper.addResult(url,res,operator,nowtime);
        if (result == 0){
            logger.warn("addResult插入结果失败");
            return false;
        }

        return true;

    }

    public boolean getParams(String url,String res,String operator){
        if (url == null || res == null || operator == null){
            return false;
        }
        return true;
    }

    public String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }
}
