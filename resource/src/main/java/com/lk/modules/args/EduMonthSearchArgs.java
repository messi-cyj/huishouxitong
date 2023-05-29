package com.lk.modules.args;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EduMonthSearchArgs extends PageArgs implements Serializable {

    @ApiModelProperty(value = "培训主题")
    private String topic;

    @ApiModelProperty(value = "培训日期")
    private String trainDate;

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "月份")
    private Integer month;

}
