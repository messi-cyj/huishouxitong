package com.lk.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EduMonthDto implements Serializable {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "培训主题")
    private String topic;

    @ApiModelProperty(value = "培训日期")
    private String trainDate;

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "附件资料id集合")
    private List<Integer> fileIdList;
}
