package com.helloworld.epidemicmanagement.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="`user`")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
    * 用户ID
    */
    @ApiModelProperty(value="用户ID")
    private Long id;

    /**
    * 用户姓名
    */
    @ApiModelProperty(value="用户姓名")
    private String name;

    /**
    * 用户性别，0男，1女
    */
    @ApiModelProperty(value="用户性别，0男，1女")
    private String gender;

    /**
    * 用户身份证
    */
    @ApiModelProperty(value="用户身份证")
    private String idCard;

    /**
    * 家庭地址
    */
    @ApiModelProperty(value="家庭地址")
    private String address;

    /**
    * 详细地址
    */
    @ApiModelProperty(value="详细地址")
    private String location;

    /**
    * 电话号码
    */
    @ApiModelProperty(value="电话号码")
    private String phone;

    /**
    * 0：学生，1教职人员，3：驻地人员，4：流动人员
    */
    @ApiModelProperty(value="0：学生，1教职人员，3：驻地人员，4：流动人员")
    private String type;

    /**
    * 用户账号状态0：启用，1：禁用
    */
    @ApiModelProperty(value="用户账号状态0：启用，1：禁用")
    private String status;

    /**
    * 用户头像
    */
    @ApiModelProperty(value="用户头像")
    private String avatar;

    private String password;
}
