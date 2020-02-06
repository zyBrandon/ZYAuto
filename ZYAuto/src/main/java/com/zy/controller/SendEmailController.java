package com.zy.controller;

import com.zy.util.ApiResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {

    @RequestMapping(value = "sendemail",method = RequestMethod.POST)
    public ApiResult SendEmailController(@RequestParam("username") String username){
        //先做身份认证，判断是否是管理员
        //拉取所有的email地址
        //发送邮件
        //发送失败，把失败的用户放入redis中，后期脚本补偿
    }
}
