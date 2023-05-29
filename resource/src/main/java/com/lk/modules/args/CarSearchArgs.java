package com.lk.modules.args;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarSearchArgs extends PageArgs implements Serializable {

    @ApiModelProperty(value = "车牌号")
    private String carNo;

    @ApiModelProperty(value = "车牌颜色")
    private String licensePlateColor;

    @ApiModelProperty(value = "运营状态（0营业 1停运）")
    private Integer carStatus;

    @ApiModelProperty(value = "车辆类型")
    private String carType;
}
