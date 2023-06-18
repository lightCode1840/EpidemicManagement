package com.helloworld.epidemicmanagement.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsyj
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("登录用户模型")
public class LoginBody {

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("验证码")
    private String code;

    @ApiModelProperty("UUID")
    private String uuid;
}
