package com.lk.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class StaffDto implements Serializable {
    @ApiModelProperty(value = "id,修改时必传")
    private Integer id;

    @ApiModelProperty(value = "角色id",required = false)
    private Integer roleId = 3;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "性别（0男，1女")
    private Integer sex;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "相关联系人")
    private String contact;
}
