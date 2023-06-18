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
@ApiModel("离校申请结果模型")
public class OutApplyDto {


    @ApiModelProperty("离校目的地")
    private String direction;
    @ApiModelProperty("身份证")
    private String idCard;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("离校原因")
    private String reason;
    @ApiModelProperty("离校时间")
    private String time;
    @ApiModelProperty("离校详细车次信息，信息格式：交通工具种类（车次号）")
    private String vehicle;

    @ApiModelProperty("remark")
    private String remark;

    @ApiModelProperty("0:申请成功，1：申请失败，2：待处理，3：已失效")
    private Integer state;
}
