package com.lk.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EduQuarterDto implements Serializable {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "培训主题")
    private String topic;

    @ApiModelProperty(value = "培训日期")
    private String trainDate;

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "季度")
    private Integer quarter;

    @ApiModelProperty(value = "附件资料id集合")
    private List<Integer> fileIdList;
}
