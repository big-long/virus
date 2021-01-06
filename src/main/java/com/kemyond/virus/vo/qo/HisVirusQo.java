package com.kemyond.virus.vo.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author zdl
 * @Date 2021/1/5 13:57
 * @Version 1.0
 */
@Data
@ApiModel("查询病毒检测历史记录条件")
public class HisVirusQo extends BaseQo {
    @ApiModelProperty(value = "扫描类型",example = "-1",required = true)
    Integer scanType;
    @ApiModelProperty(value = "扫描状态",example = "-1",readOnly = true)
    Integer scanStatus;
    @ApiModelProperty(value = "开始时间",example = "2020-10-20 13:14:20")
    String startTime;
    @ApiModelProperty(value = "结束时间",example = "2020-10-20 13:14:49")
    String endTime;
}
