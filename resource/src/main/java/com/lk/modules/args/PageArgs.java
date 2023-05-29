package com.lk.modules.args;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author lk
 */
@Data
public class PageArgs implements Serializable {

    @ApiModelProperty("页码")
    private Integer page = 1;

    @ApiModelProperty("分页条数")
    private Integer limit = 10;

    @ApiModelProperty("排序字段+规则（例如：id ASC）")
    private String order;
}
