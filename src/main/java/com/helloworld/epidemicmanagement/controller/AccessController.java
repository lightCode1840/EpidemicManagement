package com.helloworld.epidemicmanagement.controller;

import com.helloworld.epidemicmanagement.config.QuartzConfig;
import com.helloworld.epidemicmanagement.domain.Access;
import com.helloworld.epidemicmanagement.domain.ApplyStateEnum;
import com.helloworld.epidemicmanagement.domain.Out;
import com.helloworld.epidemicmanagement.domain.dto.InApplyDto;
import com.helloworld.epidemicmanagement.domain.dto.OutApplyDto;
import com.helloworld.epidemicmanagement.domain.vo.AccessVo;
import com.helloworld.epidemicmanagement.domain.vo.OutVo;
import com.helloworld.epidemicmanagement.service.AccessService;
import com.helloworld.epidemicmanagement.service.OutService;
import com.helloworld.epidemicmanagement.utils.AjaxResult;
import com.helloworld.epidemicmanagement.utils.DateTimeUtil;
import com.helloworld.epidemicmanagement.utils.SecurityUtil;
import com.helloworld.epidemicmanagement.utils.constans.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.Scheduler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author fsyj
 */
@Api("出入管理模块")
@RestController
@RequestMapping("/api/1/application")
public class AccessController {

    @Resource
    AccessService accessServiceImpl;

    @Resource
    OutService outServiceImpl;

    @Resource
    private Scheduler quartzScheduler;

    @ApiOperation("入校申请")
    @PostMapping("/in/record")
    public AjaxResult inApply(@RequestBody InApplyDto inApplyDto) {

        // 获取用户ID，判断是谁提交申请
        Long userId = SecurityUtil.getUserId();
        // 解析申请时间
        Date date = null;
        try {
            date = DateTimeUtil.parseToDateBy19(inApplyDto.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("时间格式不正确");
        }
        Access access = new Access(null, inApplyDto.getName(), inApplyDto.getIdCard(), inApplyDto.getReason(), date,
                inApplyDto.getOriginLocation(), inApplyDto.getVehicle(), inApplyDto.getPcr(), inApplyDto.getImg(),
                inApplyDto.getTc(), inApplyDto.getRemark(), ApplyStateEnum.PROCESS.getState(), userId);
        Long accessId = accessServiceImpl.insert(access);
        if (accessId != null) {
            // 启动定时任务
            QuartzConfig.createScheduleJob(quartzScheduler, Constants.ACCESS_STATE_ID, accessId, "ACCESS" +accessId);
        }
        return AjaxResult.success("申请已提交");
    }

    @ApiOperation("离校申请")
    @PostMapping("/out/record")
    public AjaxResult outApply(@RequestBody OutApplyDto outApplyDto) {
        // 获取用户ID，判断是谁提交申请
        Long userId = SecurityUtil.getUserId();
        // 解析申请时间
        Date date = null;
        try {
            date = DateTimeUtil.parseToDateBy19(outApplyDto.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("时间格式不正确");
        }
        Out out = new Out(null, outApplyDto.getName(), outApplyDto.getIdCard(), outApplyDto.getReason(), date,
                outApplyDto.getVehicle(), outApplyDto.getDirection(), outApplyDto.getRemark(), ApplyStateEnum.PROCESS.getState(), userId);
        Long outId = outServiceImpl.insert(out);
        if (outId != null) {
            // 启动定时任务
            QuartzConfig.createScheduleJob(quartzScheduler, Constants.OUT_STATE_ID, outId, "OUT" +outId);
        }
        return AjaxResult.success("申请已提交");
    }

    @ApiOperation("查询入校申请列表")
    @GetMapping("/in/list")
    public AjaxResult inList(HttpServletRequest request) {
        Long userId = SecurityUtil.getUserId();
        List<AccessVo> accessList = accessServiceImpl.selectListByUserid(userId);
        return AjaxResult.success("Success").put("data", accessList);
    }

    @ApiOperation("点击返校")
    @PostMapping("/in/state/{id}")
    public AjaxResult returnSchool(@PathVariable String id) throws ParseException {
        Long userId = SecurityUtil.getUserId();
        Long accessId = Long.valueOf(id);
        List<AccessVo> accessList = accessServiceImpl.selectListByUserid(userId);
        // 查看列表中是否有对应的ID
        Access containAccess = null;
        for (AccessVo access : accessList) {
            if (access.getId().equals(accessId)) {
                containAccess = new Access(access.getId(), access.getName(), access.getIdCard(), access.getReason(),
                        DateTimeUtil.parseToDateBy19(access.getStartTime()), access.getOriginLocation(), access.getVehicle(),
                        access.getPcr(), access.getImg(), access.getTc(), access.getRemark(), access.getState(), access.getUserId());
                break;
            }
        }
        AjaxResult result = null;
        if (containAccess != null && !containAccess.getState().equals(ApplyStateEnum.INVALID.getState())) {
            // 如果包含，且状态不为失效
            accessServiceImpl.returnSchool(containAccess);
            result = AjaxResult.success("返校成功");
        } else {
            result = AjaxResult.error("申请不存在或已失效");
        }
        return result;
    }

    @ApiOperation("查询离校列表")
    @GetMapping("/out/list")
    public AjaxResult outList() {
        Long userId = SecurityUtil.getUserId();
        List<OutVo> outs = outServiceImpl.selectListByUserid(userId);
        return AjaxResult.success("Success").put("data", outs);
    }

    @ApiOperation("点击离校")
    @PostMapping("/out/state/{id}")
    public AjaxResult offSchool(@PathVariable String id) throws ParseException {
        Long userId = SecurityUtil.getUserId();
        Long outId = Long.valueOf(id);
        List<OutVo> outs = outServiceImpl.selectListByUserid(userId);
        Out outApply = null;
        for (OutVo out : outs) {
            if (out.getId().equals(outId)) {
                outApply = new Out(out.getId(), out.getName(), out.getIdCard(), out.getReason(),
                        DateTimeUtil.parseToDateBy19(out.getStartTime()), out.getVehicle(), out.getDirection(),
                        out.getRemark(), out.getState(), out.getUserId());
                break;
            }
        }
        AjaxResult ajaxResult = null;
        if (outApply != null && !outApply.getState().equals(ApplyStateEnum.INVALID.getState())) {
            // 存在且申请未失效
            outServiceImpl.outSchool(outApply);
            ajaxResult = AjaxResult.success("离校成功");
        } else {
            ajaxResult = AjaxResult.error("申请不存在或已失效");
        }
        return ajaxResult;
    }
}
