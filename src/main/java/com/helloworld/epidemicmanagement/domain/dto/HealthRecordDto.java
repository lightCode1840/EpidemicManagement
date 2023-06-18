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
@ApiModel("健康打卡记录")
public class HealthRecordDto {

    @ApiModelProperty("姓名")
    private String name;


    @ApiModelProperty("身份证")
    private String idCard;

    @ApiModelProperty("居住地址")
    private String address;

    @ApiModelProperty("详细地址")
    private String location;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("体温")
    private Float temperature;
}
