package com.helloworld.epidemicmanagement.controller;


import com.helloworld.epidemicmanagement.domain.Record;
import com.helloworld.epidemicmanagement.domain.dto.HealthRecordDto;
import com.helloworld.epidemicmanagement.service.RecordService;
import com.helloworld.epidemicmanagement.utils.AjaxResult;
import com.helloworld.epidemicmanagement.utils.DateTimeUtil;
import com.helloworld.epidemicmanagement.utils.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

/**
 * @author fsyj
 */

@RestController
@Api("健康打卡模块")
@RequestMapping("/api/1/health")
public class ClockController {

    @Resource
    RecordService recordService;

    @ApiOperation("新增健康打卡记录")
    @PostMapping("/record")
    public AjaxResult insertRecord(@RequestBody HealthRecordDto record) throws ParseException {
        //获取用户id
        Long userId = SecurityUtil.getUserId();
        //获取时间
        Date date = DateTimeUtil.parseToDateBy19(DateTimeUtil.get19SysTime());
        Record recordInstance = new Record(null,record.getName(),record.getIdCard(),record.getAddress(),record.getLocation(),record.getPhone(),date, (double)record.getTemperature(),userId);
        recordService.insert(recordInstance);
        return AjaxResult.success("打卡成功");
    }


}
