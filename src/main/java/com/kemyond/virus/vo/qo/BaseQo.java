package com.kemyond.virus.vo.qo;

/**
 * @Author zdl
 * @Date 2021/1/5 11:02
 * @Version 1.0
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基本的查询条件
 */
@Data
@ApiModel("基本的查询条件")
public class BaseQo {
    @ApiModelProperty(value = "页面大小",required = true,example = "10")
    private Integer pageSize;
    @ApiModelProperty(value = "当前页",required = true,example = "1")
    private Integer currentPage;
}
