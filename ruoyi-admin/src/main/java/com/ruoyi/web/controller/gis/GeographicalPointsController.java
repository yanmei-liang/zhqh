package com.ruoyi.web.controller.gis;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.gis.domain.GeographicalPoints;
import com.ruoyi.gis.domain.GeographicalPoints;
import com.ruoyi.gis.service.IGeographicalPointsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 点状标志Controller
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Api(tags = "地理空间数据-点状标志points")
@RestController
@RequestMapping("/gis/geomPoints")
public class GeographicalPointsController extends BaseController
{
    @Autowired
    private IGeographicalPointsService geographicalPointsService;

    /**
     * 查询点状标志列表
     */
    @ApiOperation("查询点状标志列表")
    @PreAuthorize("@ss.hasPermi('geom:POINTS:list')")
    @GetMapping("/list")
    public TableDataInfo list(GeographicalPoints geographicalPoints)
    {
        startPage();
        List<GeographicalPoints> list = geographicalPointsService.selectGeographicalPointsList(geographicalPoints);
        return getDataTable(list);
    }

    /**
     * 导出点状标志列表
     */
    @PreAuthorize("@ss.hasPermi('geom:POINTS:export')")
    @Log(title = "点状标志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GeographicalPoints geographicalPoints)
    {

        List<GeographicalPoints> list = geographicalPointsService.selectGeographicalPointsList(geographicalPoints);
        ExcelUtil<GeographicalPoints> util = new ExcelUtil<GeographicalPoints>(GeographicalPoints.class);
        util.exportExcel(response, list, "点状标志数据");
    }

    /**
     * 获取点状标志详细信息
     */
    @ApiOperation("获取点状标志详细信息")
    @PreAuthorize("@ss.hasPermi('geom:POINTS:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(geographicalPointsService.selectGeographicalPointsByOBJECTID(id));
    }

    /**
     * 新增点状标志
     */
    @ApiOperation("新增点状标志")
    @PreAuthorize("@ss.hasPermi('geom:POINTS:add')")
    @Log(title = "点状标志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GeographicalPoints geographicalPoints)
    {
        return toAjax(geographicalPointsService.insertGeographicalPoints(geographicalPoints));
    }

    /**
     * 修改点状标志
     */
    @ApiOperation("修改点状标志")
    @PreAuthorize("@ss.hasPermi('geom:POINTS:edit')")
    @Log(title = "点状标志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GeographicalPoints geographicalPoints)
    {

        return toAjax(geographicalPointsService.updateGeographicalPoints(geographicalPoints));
    }

    /**
     * 删除点状标志
     */
    @ApiOperation("删除点状标志")
    @PreAuthorize("@ss.hasPermi('geom:POINTS:remove')")
    @Log(title = "点状标志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(geographicalPointsService.deleteGeographicalPointsByOBJECTIDs(ids));
    }
}
