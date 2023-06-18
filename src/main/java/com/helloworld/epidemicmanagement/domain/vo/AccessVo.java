package com.helloworld.epidemicmanagement.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsyj
 */
@ApiModel("入校VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessVo {
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 出入申请人
     */
    @ApiModelProperty(value="出入申请人")
    private String name;

    /**
     * 申请人身份证
     */
    @ApiModelProperty(value="申请人身份证")
    private String idCard;

    /**
     * 申请理由
     */
    @ApiModelProperty(value="申请理由")
    private String reason;

    /**
     * 申请时间
     */
    @ApiModelProperty(value="申请时间")
    private String startTime;


    @ApiModelProperty(value = "截至时间")
    private String endTime;

    /**
     * 始发地
     */
    @ApiModelProperty(value="始发地")
    private String originLocation;

    /**
     * 车次
     */
    @ApiModelProperty(value="车次")
    private String vehicle;

    /**
     * 核酸图片
     */
    @ApiModelProperty(value="核酸图片")
    private String pcr;

    /**
     * 健康码图片
     */
    @ApiModelProperty(value="健康码图片")
    private String img;

    /**
     * 行程码图片
     */
    @ApiModelProperty(value="行程码图片")
    private String tc;

    /**
     * 备注信息
     */
    @ApiModelProperty(value="备注信息")
    private String remark;

    /**
     * 0：成功，1：失败，2：待处理，3：已失效
     */
    @ApiModelProperty(value="0：成功，1：失败，2：待处理，3：已失效")
    private String state;

    /**
     * 提交申请的用户ID
     */
    @ApiModelProperty(value="提交申请的用户ID")
    private Long userId;
}
