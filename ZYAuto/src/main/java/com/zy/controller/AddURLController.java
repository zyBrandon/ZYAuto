package com.zy.controller;


import com.zy.service.addURL;
import com.zy.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddURLController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private addURL addURL;

    @RequestMapping(value = "/addUrl",method = RequestMethod.POST)
    public ApiResult addUrl(@RequestParam String username,@RequestParam String url){
        if (getParams(username,url) == false){
            logger.warn("addUrl参数错误");
            return ApiResult.success(10000,"失败","参数错误");
        }

        boolean res = addURL.addURL(username,url);
        if (res == false){
            logger.warn("addURL方法错误");
            return ApiResult.success(500,"失败","服务异常");
        }

        return ApiResult.success(200,"成功","");

    }

    public boolean getParams(String username,String url){
        if (username == null || username.length() > 20){
            return false;
        }

        if (url == null || url.length() > 200){
            return false;
        }
        return true;
    }
}
