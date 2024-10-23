package com.ruoyi.web.controller.gis;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.gis.domain.GeographicalLines;
import com.ruoyi.gis.domain.GeographicalLines;
import com.ruoyi.gis.service.IGeographicalLinesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 线性标志Controller
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Api(tags = "地理空间数据-线性标志lines")
@RestController
@RequestMapping("/gis/geomLines")
public class GeographicalLinesController extends BaseController
{
    @Autowired
    private IGeographicalLinesService geographicalLinesService;

    /**
     * 查询线性标志列表
     */
    @ApiOperation("查询线性标志列表")
    @PreAuthorize("@ss.hasPermi('geom:LINES:list')")
    @GetMapping("/list")
    public TableDataInfo list(GeographicalLines geographicalLines)
    {
        startPage();
        List<GeographicalLines> list = geographicalLinesService.selectGeographicalLinesList(geographicalLines);
        return getDataTable(list);
    }

    /**
     * 导出线性标志列表
     */
    @PreAuthorize("@ss.hasPermi('geom:LINES:export')")
    @Log(title = "线性标志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GeographicalLines geographicalLines)
    {

        List<GeographicalLines> list = geographicalLinesService.selectGeographicalLinesList(geographicalLines);
        ExcelUtil<GeographicalLines> util = new ExcelUtil<GeographicalLines>(GeographicalLines.class);
        util.exportExcel(response, list, "线性标志数据");
    }

    /**
     * 获取线性标志详细信息
     */
    @ApiOperation("获取线性标志详细信息")
    @PreAuthorize("@ss.hasPermi('geom:LINES:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(geographicalLinesService.selectGeographicalLinesByOBJECTID(id));
    }

    /**
     * 新增线性标志
     */
    @ApiOperation("新增线性标志")
    @PreAuthorize("@ss.hasPermi('geom:LINES:add')")
    @Log(title = "线性标志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GeographicalLines geographicalLines)
    {
        return toAjax(geographicalLinesService.insertGeographicalLines(geographicalLines));
    }

    /**
     * 修改线性标志
     */
    @ApiOperation("修改线性标志")
    @PreAuthorize("@ss.hasPermi('geom:LINES:edit')")
    @Log(title = "线性标志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GeographicalLines geographicalLines)
    {

        return toAjax(geographicalLinesService.updateGeographicalLines(geographicalLines));
    }

    /**
     * 删除线性标志
     */
    @ApiOperation("删除线性标志")
    @PreAuthorize("@ss.hasPermi('geom:LINES:remove')")
    @Log(title = "线性标志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(geographicalLinesService.deleteGeographicalLinesByOBJECTIDs(ids));
    }
}
