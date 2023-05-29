package com.lk.modules.vo;

import com.lk.modules.po.FilePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EduYearVo implements Serializable {
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

    @ApiModelProperty(value = "是否删除")
    private Boolean trainDelete;

    @ApiModelProperty(value = "附件资料集合")
    private List<FilePo> fileList;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;
}
