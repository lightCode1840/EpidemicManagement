package com.helloworld.epidemicmanagement.controller;

import com.helloworld.epidemicmanagement.domain.User;
import com.helloworld.epidemicmanagement.domain.dto.RegisterDto;
import com.helloworld.epidemicmanagement.domain.dto.UserDto;
import com.helloworld.epidemicmanagement.service.UserService;
import com.helloworld.epidemicmanagement.utils.AjaxResult;
import com.helloworld.epidemicmanagement.utils.SecurityUtil;
import io.swagger.annotations.Api;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author fsyj
 */
@Api("我的模块")
@RestController
@RequestMapping("/api/1/my")
public class MyController {

    @Resource
    private UserService userServiceImpl;

    @Resource
    private PasswordEncoder passwordEncoder;


    @PostMapping("/info")
    public AjaxResult updateInfo(@RequestBody UserDto userDto) {
        Long userId = SecurityUtil.getUserId();
        userServiceImpl.updateByPrimaryKeySelective(new User(userId, userDto.getName(), userDto.getGender(),
                userDto.getIdCard(), userDto.getAddress(), userDto.getLocation(), userDto.getPhone(),
                userDto.getType(), userDto.getStatus(), userDto.getAvatar(), userDto.getPassword()));
        return AjaxResult.success();
    }

    @GetMapping("/info")
    public AjaxResult getInfo() {
        Long userId = SecurityUtil.getUserId();
        User data = userServiceImpl.getInfoById(userId);
        return AjaxResult.success().put("user", data);
    }

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterDto registerDto) {
        User user = userServiceImpl.selectByPhone(registerDto.getPhone());
        if (user != null && "0".equals(user.getStatus())) {
            throw new RuntimeException("该手机号已被注册");
        } else if (user != null && "1".equals(user.getStatus())) {
            userServiceImpl.updateByPrimaryKeySelective(new User(null, registerDto.getName(), null, registerDto.getIdCard(), null, null,
                    registerDto.getPhone(), registerDto.getType(), registerDto.getStatus(), registerDto.getAvatar(), registerDto.getPassword()));
        } else {
            userServiceImpl.insert(new User(null, registerDto.getName(), null, registerDto.getIdCard(), null, null,
                    registerDto.getPhone(), registerDto.getType(), registerDto.getStatus(), registerDto.getAvatar(), passwordEncoder.encode(registerDto.getPassword())));
        }
        return AjaxResult.success();
    }
}
