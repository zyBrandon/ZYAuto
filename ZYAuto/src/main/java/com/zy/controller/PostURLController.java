package com.zy.controller;

import com.zy.model.User;
import com.zy.service.getRole;
import com.zy.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostURLController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private getRole getRole;

    @RequestMapping(value = "/posturl",method = RequestMethod.POST)
    public ApiResult posturl(@RequestParam String username){
        if (getParams(username) == false){
            logger.warn("posturl 参数失败");
            return ApiResult.success(10000,"失败","参数错误");
        }
        //鉴权
        User userrole = getRole.getRole(username);
        if (username == null){
            logger.warn("posturl 获取权限失败");
            return ApiResult.success(10000,"失败","获取权限失败");
        }

        String role = userrole.getRole();
        if (!role.equals("admin")){
            logger.warn("posturl 权限不足");
            return ApiResult.success(10000,"失败","权限不足");
        }

        //拉取所有对应的url


    }

    public boolean getParams(String username){
        if (username == null || username.length() > 20){
            return false;
        }
        return true;
    }
}
