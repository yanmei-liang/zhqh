package com.ruoyi.government.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("状态合计")
public class StatusCount {

    @ApiModelProperty("状态名称")
    private String status;

    @ApiModelProperty("状态数量")
    private Integer num;
}
