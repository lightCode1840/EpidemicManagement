package com.helloworld.epidemicmanagement.controller;

import com.helloworld.epidemicmanagement.domain.vo.Test;
import com.helloworld.epidemicmanagement.service.TestRecordService;
import com.helloworld.epidemicmanagement.utils.AjaxResult;
import com.helloworld.epidemicmanagement.utils.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fsyj
 */
@Api("核酸检测模块")
@RestController
@RequestMapping("/api/1/test")
public class TestController {

    @Resource
    TestRecordService testRecordService;


    @ApiOperation("信息查询")
    @GetMapping("/place")
    public AjaxResult getPlace() {
        Long userId = SecurityUtil.getUserId();

        return null;
    }

    @GetMapping("/result")
    public AjaxResult getRecordById(Integer listId) {
        Test test = testRecordService.getRecordById(listId);
        return AjaxResult.success("success").put("data", test);
    }

    @GetMapping("/List")
    public AjaxResult getRecordList() {
        Long userId = SecurityUtil.getUserId();
        List<Test> list = testRecordService.getRecordList(userId);
        return AjaxResult.success("success").put("data", list);
    }
}
