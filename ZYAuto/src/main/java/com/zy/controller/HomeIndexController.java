package com.zy.controller;

import com.zy.model.UserURL;
import com.zy.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zy.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

@RestController
public class HomeIndexController {

    @Autowired
    private getAllURLByUserName getAllURLByUserName;
    @Autowired
    private getUserLand getUserLand;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public ApiResult home(@RequestParam String username){
        if (getParams(username) == false){
            logger.warn("home参数错误");
            return ApiResult.success(10000,"失败","参数错误");
        }

        logger.warn(username);
        //查看是否登录
        boolean res = getUserLand.getUserLand(username);


        //结果
        HashMap result = new HashMap();
        result.put("username",username);
        //用于存储userurl
        Vector<UserURL> userurl = new Vector<>();
        userurl = getAllURLByUserName.getAllURLByUserName(username);
        if (userurl == null){
            logger.warn("home列表为空");
            return ApiResult.success(200,"列表为空或者调用失败","");
        }
        result.put("urls",userurl);
        if (true == res){
            result.put("landRes","已登录");
        } else {
            result.put("landRes","未登录");
        }
        return ApiResult.success(200,"成功",result);


    }

    public boolean getParams(String username){
        if (username == null || username.length() > 20){
            return false;
        }
        return true;
    }
}
