package com.helloworld.epidemicmanagement.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel(value="test_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestRecord {
    @ApiModelProperty(value="")
    private Long id;

    /**
    *  报告时间
    */
    @ApiModelProperty(value=" 报告时间")
    private Date time;

    /**
    * 用户ID
    */
    @ApiModelProperty(value="用户ID")
    private Long user;

    /**
    * 附加信息
    */
    @ApiModelProperty(value="附加信息")
    private String data;

    /**
    * 就诊医院
    */
    @ApiModelProperty(value="就诊医院")
    private String place;

    /**
    * 检测医嘱
    */
    @ApiModelProperty(value="检测医嘱")
    private String remark;

    /**
    * 样本类型
    */
    @ApiModelProperty(value="样本类型")
    private String type;

    /**
    * 患者识别号
    */
    @ApiModelProperty(value="患者识别号")
    private String recognizeCode;

}
