package com.helloworld.epidemicmanagement.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="role_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu {
    /**
    * 角色ID
    */
    @ApiModelProperty(value="角色ID")
    private Long roleId;

    /**
    * 菜单ID
    */
    @ApiModelProperty(value="菜单ID")
    private Long menuId;
}
