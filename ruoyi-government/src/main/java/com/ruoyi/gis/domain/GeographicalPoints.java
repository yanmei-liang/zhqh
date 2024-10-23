package com.ruoyi.gis.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 点状标志对象 GEOGRAPHICAL_POINTS
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Data
@ApiModel("点状标志对象")
public class GeographicalPoints extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer ID;

    /** 地理位置信息 */
    @ApiModelProperty("地理位置信息")
    @Excel(name = "地理位置信息")
    private String SHAPE;

    /** 标识码 */
    @ApiModelProperty("标识码")
    @Excel(name = "标识码")
    private String CODE;

    /** 图上名称 */
    @Excel(name = "图上名称")
    @ApiModelProperty("图上名称")
    private String mapName;

    /** 行政编码 */
    @Excel(name = "行政编码")
    @ApiModelProperty("行政编码")
    private String TYPE;

    /** 使用时间 */
    @Excel(name = "使用时间")
    @ApiModelProperty("使用时间")
    private String useTime;

    @TableLogic
    @ApiModelProperty("删除标志-0删除-1正常")
    private int is_deleted;

}
