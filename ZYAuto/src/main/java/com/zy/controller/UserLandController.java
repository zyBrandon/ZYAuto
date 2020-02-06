package com.zy.controller;


import com.zy.service.addUsernameRedis;
import com.zy.service.getUsernameAndPass;
import com.zy.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLandController {
    @Autowired
    private com.zy.service.getUsernameAndPass getUsernameAndPass;
    @Autowired
    private com.zy.service.addUsernameRedis addUsernameRedis;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "userland",method = RequestMethod.POST)
    public ApiResult userland(@RequestParam String username,@RequestParam String pass){
        if (getParms(username,pass) == false){
            logger.warn("userland接口参数不符合要求");
            return ApiResult.success(500,"失败","参数不符合要求");
        }

        //判断是否存在该用户
        boolean getUsernameRes = getUsernameAndPass.getUsernameAndPass(username,pass);
        if (getUsernameRes == true){
            //将登录状态加入redis
            boolean addRedisRes = addUsernameRedis.addUsernameRedis(username);
            if (addRedisRes == false){
                logger.warn("userland添加redis失败");
                return ApiResult.success(200000,"失败","增加redis失败");
            }
        } else {
            return ApiResult.success(20000,"失败","账号密码不存在");
        }

        return ApiResult.success(200,"成功","登录成功");


    }

    public boolean getParms(String username,String pass){
        if (username == null || pass == null || username.length() > 20 || pass.length() > 20){
            return false;
        }

        return true;
    }
}
