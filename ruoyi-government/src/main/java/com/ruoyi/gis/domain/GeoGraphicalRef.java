package com.ruoyi.gis.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 地图空间数据和地名关联对象 GEO_GRAPHICAL_REF
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Data
@ApiModel("地图空间数据和地名关联对象")
public class GeoGraphicalRef extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer ID;

    /** 地图空间数据标识码 */
    @ApiModelProperty("地图空间数据标识码")
    @Excel(name = "地图空间数据标识码")
    private String geomCode;

    /** 地名代码 */
    @ApiModelProperty("地名代码")
    @Excel(name = "地名代码")
    private String grapCode;

    @TableLogic
    @ApiModelProperty("删除标志-0删除-1正常")
    private int is_deleted;

}
