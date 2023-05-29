package com.lk.modules.dto;

import com.lk.modules.args.PageArgs;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDto implements Serializable {

    @ApiModelProperty(value = "id,修改时必传")
    private Integer id;

    @ApiModelProperty(value = "角色名称",required = true)
    private String roleName;

    @ApiModelProperty(value = "角色等级",required = true)
    private Integer roleLevel;
}
