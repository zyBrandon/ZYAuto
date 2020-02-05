package com.zy.controller;


import com.zy.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLandController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "userland",method = RequestMethod.POST)
    public ApiResult userland(@RequestParam String username,@RequestParam String pass){
        if (getParms(username,pass) == false){
            logger.warn("userland接口参数不符合要求");
            return ApiResult.success(500,"失败","参数不符合要求");
        }

        //判断是否存在该用户

        //将登录状态加入redis

    }

    public boolean getParms(String username,String pass){
        if (username == null || pass == null || username.length() > 20 || pass.length() > 20){
            return false;
        }

        return true;
    }
}
