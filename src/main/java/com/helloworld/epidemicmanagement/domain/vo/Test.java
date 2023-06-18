package com.helloworld.epidemicmanagement.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @ApiModelProperty(value="")
    private Long id;

    /**
     *  报告时间
     */
    @ApiModelProperty(value=" 报告时间")
    private String time;

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


    /**
     * 用户姓名
     */
    @ApiModelProperty(value="用户姓名")
    private String name;

    /**
     * 性别  //查询Mapper待改
     */
    @ApiModelProperty(value="性别")
    private String gender;
}
