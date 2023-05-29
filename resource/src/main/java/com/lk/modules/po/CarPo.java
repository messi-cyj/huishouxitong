package com.lk.modules.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarPo implements Serializable {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "车牌号")
    private String carNo;

    @ApiModelProperty(value = "车牌颜色")
    private String licensePlateColor;

    @ApiModelProperty(value = "运营状态（0营业 1停运）")
    private Integer carStatus;

    @ApiModelProperty(value = "车辆类型")
    private String carType;

    @ApiModelProperty(value = "车辆经营范围")
    private String manageScope;

    @ApiModelProperty(value = "总质量")
    private String totalMass;

    @ApiModelProperty(value = "核定载质量")
    private String checkWeight;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;
}
