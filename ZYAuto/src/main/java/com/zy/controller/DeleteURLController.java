package com.zy.controller;

import com.zy.service.deleteURL;
import com.zy.service.getUserUrlHave;
import com.zy.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteURLController {

    @Autowired
    private getUserUrlHave getUserUrlHave;
    @Autowired
    private deleteURL deleteURL;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/deleteUrl",method = RequestMethod.POST)
    public ApiResult deleteUrl(@RequestParam String username,@RequestParam String url){
        if (getParams(username,url) == false){
            logger.warn("delete接口参数错误");
            return ApiResult.success(10000, "失败","参数错误");
        }

        boolean res = getUserUrlHave.getUserUrlHave(username, url);
        if (res == false){
            logger.warn("用户的url不存在");
            return ApiResult.success(10000,"失败","用户的url不存在" );
        }
        boolean result = deleteURL.deleteURL(username, url);
        if (result == false){
            logger.warn("deleteURL删除url失败" );
            return ApiResult.success(10000,"失败","deleteURL删除url失败");
        }
        return ApiResult.success(200,"成功","删除url成功");
    }

    public boolean getParams(String username,String url){
        if (username == null || url == null || username.length() > 20 || url.length() > 200){
            return false;
        }
        return true;
    }
}
