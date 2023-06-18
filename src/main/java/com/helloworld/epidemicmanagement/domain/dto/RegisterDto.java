package com.helloworld.epidemicmanagement.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsyj
 */
@ApiModel("用户注册模型")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("类型")
    private String type;

    // 账号默认启用
    private String status = "0";


    // 默认头像
    private String avatar = "https://qn.dns.fsyj.site/avatar.jpeg";
}
