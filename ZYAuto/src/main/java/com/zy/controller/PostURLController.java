package com.zy.controller;

import com.zy.model.User;
import com.zy.model.UserURL;
import com.zy.service.getAllURL;
import com.zy.service.getRole;
import com.zy.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Vector;

@RestController
public class PostURLController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private getRole getRole;
    private getAllURL getAllURL;

    @RequestMapping(value = "/posturl",method = RequestMethod.POST)
    public ApiResult posturl(@RequestParam String username){
        if (getParams(username) == false){
            logger.warn("posturl 参数失败");
            return ApiResult.success(10000,"失败","参数错误");
        }

        //鉴权
        User userrole = getRole.getRole(username);
        if (userrole == null){
            logger.warn("posturl 获取权限失败");
            return ApiResult.success(10000,"失败","获取权限失败");
        }

        String role = userrole.getRole();
        if (!role.equals("admin")){
            logger.warn("posturl 权限不足");
            return ApiResult.success(10000,"失败","权限不足");
        }

        //拉取所有对应的url
        Vector<UserURL> res = getAllURL.getAllURL();
        if (res == null){
            logger.warn("PostURLController getAllURL为空");
            return ApiResult.success(10000,"失败","无url地址");
        }

        //开始跑请求
        for (int i = 0;i < res.size();i++){
            String url = res.get(i).getUrl();
            HttpMethod method = HttpMethod.GET;
            try {
                MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
                Object result = client(url,method,params);
                logger.info((String) result);

            }catch (Exception e){
                return ApiResult.success(500,"失败", url+" http请求异常");
            }
        }
        return ApiResult.success(200,"成功","所有url全部执行完成");
    }

    public boolean getParams(String username){
        if (username == null || username.length() > 20){
            return false;
        }
        return true;
    }

    public Object client(String url, HttpMethod method, MultiValueMap<String,String> params){
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        return responseEntity.getBody();
    }
}
