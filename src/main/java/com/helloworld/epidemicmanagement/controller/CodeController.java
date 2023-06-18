package com.helloworld.epidemicmanagement.controller;


import com.helloworld.epidemicmanagement.domain.HealthEnum;
import com.helloworld.epidemicmanagement.domain.User;
import com.helloworld.epidemicmanagement.service.UserService;
import com.helloworld.epidemicmanagement.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.*;

/**
 * @author fsyj
 */
@Slf4j
@Api("二维码模块")
@RestController
@RequestMapping("/api/1")
public class CodeController {

    @Resource
    private UserService userServiceImpl;

    @ApiOperation("获取健康吗")
    @GetMapping("/hcode")
    public AjaxResult getCode() {
        Long userId = SecurityUtil.getUserId();
        HealthEnum healthState = userServiceImpl.getHealthState(userId);
        // 获取用户个人信息
        User user = SecurityUtil.getUserInfo();
        String userInfo = JsonUtil.obj2StringPretty(user);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        // 生成二维码流
        switch (healthState) {
            case POSITIVE:
                QRCodeUtil.createCodeToOutputStreamWithColor(userInfo, os, Color.RED);
                break;
            case NO_RISK:
                QRCodeUtil.createCodeToOutputStreamWithColor(userInfo, os, Color.GREEN);
                break;
            case NOT_DETECTED:
                QRCodeUtil.createCodeToOutputStreamWithColor(userInfo, os, Color.GRAY);
                break;
            default: {
                log.error("系统错误");
                throw new RuntimeException("系统错误");
            }
        }
        return AjaxResult.success().put("img", Base64.encode(os.toByteArray()));
    }
}
