package com.helloworld.epidemicmanagement.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsyj
 */
@ApiModel("离校VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutVo {
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 离校人姓名
     */
    @ApiModelProperty(value="离校人姓名")
    private String name;

    /**
     * 身份证
     */
    @ApiModelProperty(value="身份证")
    private String idCard;

    /**
     * 离校原因
     */
    @ApiModelProperty(value="离校原因")
    private String reason;

    /**
     * 离校时间
     */
    @ApiModelProperty(value="离校时间")
    private String startTime;

    @ApiModelProperty(value = "截至时间")
    private String endTime;

    /**
     * 离校车次信息
     */
    @ApiModelProperty(value="离校车次信息")
    private String vehicle;

    /**
     * 离校目的地
     */
    @ApiModelProperty(value="离校目的地")
    private String direction;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
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
