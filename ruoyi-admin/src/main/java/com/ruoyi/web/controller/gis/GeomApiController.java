package com.ruoyi.web.controller.gis;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.gis.domain.GeographicalLines;
import com.ruoyi.gis.domain.GeographicalNames;
import com.ruoyi.gis.domain.GeographicalPoints;
import com.ruoyi.gis.service.IGeographicalLinesService;
import com.ruoyi.gis.service.IGeographicalNamesService;
import com.ruoyi.gis.service.IGeographicalPointsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangyanmei
 * @Title: 地图相关api
 * @Description:
 * @date 2024/10/24 15:22
 */
@Api(tags = "地理空间数据-地图相关api")
@RestController
@RequestMapping("/gis/geom")
@RequiredArgsConstructor
public class GeomApiController {

    private final IGeographicalLinesService geographicalLinesService;

    private final IGeographicalNamesService geographicalNamesService;

    private final IGeographicalPointsService geographicalPointsService;

    /**
     * 根据行政区划code查询地图数据（point，line，name）
     */
    @ApiOperation("根据行政区划code查询地图数据（point，line，name）")
    @GetMapping("/list/{code}")
    public AjaxResult getGeomByXZQH(@PathVariable("code") String code){
        Map<String, Object> objectMap = new HashMap<>();
        List<GeographicalPoints> points = geographicalPointsService.queryByXZQHCode(code);
        objectMap.put("point", points);
        List<GeographicalLines> lines = geographicalLinesService.queryByXZQHCode(code);
        objectMap.put("line", lines);
        List<GeographicalNames> names = geographicalNamesService.queryByXZQHCode(code);
        objectMap.put("name", names);
        return AjaxResult.success(objectMap);
    }

}
