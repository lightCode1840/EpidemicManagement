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
@ApiModel("入校申请结果模型")
public class InApplyDto {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份证")
    private String idCard;

    @ApiModelProperty("入校原因")
    private String reason;

    @ApiModelProperty("健康码图片地址")
    private String img;

    @ApiModelProperty("始发地")
    private String originLocation;

    @ApiModelProperty("核酸图片（PCR 为核酸检测缩写）")
    private String pcr;

    @ApiModelProperty("备注信息")
    private String remark;

    @ApiModelProperty("行程码图片（Travel Code）")
    private String tc;

    @ApiModelProperty("入校时间,格式 yyyy-MM-dd HH:mm:ss")
    private String time;

    @ApiModelProperty("返校详细车次信息，信息格式：交通工具种类（车次号）")
    private String vehicle;

    @ApiModelProperty("0:申请成功，1：申请失败，2：待处理，3：已失效")
    private Integer state;
}
