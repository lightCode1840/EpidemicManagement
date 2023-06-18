package com.helloworld.epidemicmanagement.controller;

import com.helloworld.epidemicmanagement.domain.User;
import com.helloworld.epidemicmanagement.domain.dto.LoginBody;
import com.helloworld.epidemicmanagement.service.LoginService;
import com.helloworld.epidemicmanagement.service.UserService;
import com.helloworld.epidemicmanagement.service.impl.RSAServiceImpl;
import com.helloworld.epidemicmanagement.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author fsyj
 */
@RestController
@Api("登录模块")
@RequestMapping("/api/1")
public class LoginController {

    @Resource
    LoginService loginServiceImpl;

    @Resource
    UserService userServiceImpl;

    @Resource
    RSAServiceImpl rsaServiceImpl;

    @ApiOperation("登录")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 解密密码
        String token = loginServiceImpl.login(loginBody.getPhone(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());
        // 获取用户详细信息
        User userInfo = userServiceImpl.getInfo(loginBody.getPhone());
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("token", token);
        map.put("user", userInfo);
        return ajax.put("data", map);
    }

    @ApiOperation("获取加密的公钥")
    @GetMapping("/publicKey")
    public AjaxResult getPublicKey() {
        return AjaxResult.success().put("publicKey", rsaServiceImpl.getPublicKey());
    }

    @ApiOperation("检查Token是否过期")
    @GetMapping("/valid")
    public AjaxResult tokenValid() {
        return AjaxResult.success("ok");
    }


    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public AjaxResult logout() {
        userServiceImpl.logout();
        return AjaxResult.success();
    }
}
