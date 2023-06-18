package com.helloworld.epidemicmanagement.controller;

import com.helloworld.epidemicmanagement.service.impl.OssServiceImpl;
import com.helloworld.epidemicmanagement.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fsyj
 */
@RestController
@Api("七牛上传")
@RequestMapping("/api/1/oss")
public class OssController {

    @Resource
    private OssServiceImpl ossServiceImpl;

    @ApiOperation("获取上传凭证")
    @GetMapping("/auth")
    public AjaxResult getAuth() {
        return AjaxResult.success().put("data", ossServiceImpl.createAuth());
    }
}
