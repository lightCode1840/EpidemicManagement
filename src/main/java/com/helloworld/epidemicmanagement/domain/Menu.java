package com.helloworld.epidemicmanagement.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 菜单名称
    */
    @ApiModelProperty(value="菜单名称")
    private String menuName;

    /**
    * 父菜单ID，没有则为顶级菜单
    */
    @ApiModelProperty(value="父菜单ID，没有则为顶级菜单")
    private Long parentId;

    /**
    * 组件路径
    */
    @ApiModelProperty(value="组件路径")
    private String component;

    /**
    * 路由参数
    */
    @ApiModelProperty(value="路由参数")
    private String query;
}
