package com.lk.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarDto implements Serializable {
    @ApiModelProperty(value = "id,修改时必传")
    private Integer id;

    @ApiModelProperty(value = "车牌号",required = true)
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

}
