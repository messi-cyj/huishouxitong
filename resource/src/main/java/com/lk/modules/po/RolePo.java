package com.lk.modules.po;

import com.lk.modules.args.PageArgs;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RolePo extends PageArgs implements Serializable {

    @ApiModelProperty(value = "id,修改时必传")
    private Integer id;

    @ApiModelProperty(value = "角色名称",required = true)
    private String roleName;

    @ApiModelProperty(value = "角色等级",required = true)
    private Integer roleLevel;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;
}
