package com.helloworld.epidemicmanagement.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel(value="record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 签到用户
    */
    @ApiModelProperty(value="签到用户")
    private String name;

    /**
    * 身份证
    */
    @ApiModelProperty(value="身份证")
    private String idCard;

    /**
    * 居住地址
    */
    @ApiModelProperty(value="居住地址")
    private String address;

    /**
    * 详细地址
    */
    @ApiModelProperty(value="详细地址")
    private String location;

    /**
    * 手机号
    */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
    * 签到时间
    */
    @ApiModelProperty(value="签到时间")
    private Date time;

    /**
    * 体温
    */
    @ApiModelProperty(value="体温")
    private Double temperature;

    /**
    * 提交打卡的用户ID
    */
    @ApiModelProperty(value="提交打卡的用户ID")
    private Long userId;
}
