package com.helloworld.epidemicmanagement.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="`role`")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 角色名字
    */
    @ApiModelProperty(value="角色名字")
    private String roleName;

    /**
    * 角色权限字符串
    */
    @ApiModelProperty(value="角色权限字符串")
    private byte[] roleKey;

    /**
    * 角色状态（0正常，1停用）
    */
    @ApiModelProperty(value="角色状态（0正常，1停用）")
    private String status;
}
