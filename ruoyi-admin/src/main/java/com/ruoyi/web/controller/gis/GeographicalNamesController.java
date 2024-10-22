package com.ruoyi.web.controller.gis;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.gis.domain.GeographicalNames;
import com.ruoyi.gis.service.IGeographicalNamesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地名标志Controller
 *
 * @author ruoyi
 * @date 2024-10-21
 */
@Api(tags = "地理空间数据-地名标准names")
@RestController
@RequestMapping("/gis/geomNames")
public class GeographicalNamesController extends BaseController
{
    @Autowired
    private IGeographicalNamesService geographicalNamesService;

    /**
     * 查询地名标志列表
     */
    @ApiOperation("查询地名标志列表")
    @PreAuthorize("@ss.hasPermi('geom:NAMES:list')")
    @GetMapping("/list")
    public TableDataInfo list(GeographicalNames geographicalNames)
    {
        startPage();
        List<GeographicalNames> list = geographicalNamesService.selectGeographicalNamesList(geographicalNames);
        return getDataTable(list);
    }

    /**
     * 导出地名标志列表
     */
    @PreAuthorize("@ss.hasPermi('geom:NAMES:export')")
    @Log(title = "地名标志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GeographicalNames geographicalNames)
    {

        List<GeographicalNames> list = geographicalNamesService.selectGeographicalNamesList(geographicalNames);
        ExcelUtil<GeographicalNames> util = new ExcelUtil<GeographicalNames>(GeographicalNames.class);
        util.exportExcel(response, list, "地名标志数据");
    }

    /**
     * 获取地名标志详细信息
     */
    @ApiOperation("获取地名标志详细信息")
    @PreAuthorize("@ss.hasPermi('geom:NAMES:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(geographicalNamesService.selectGeographicalNamesByOBJECTID(id));
    }

    /**
     * 新增地名标志
     */
    @ApiOperation("新增地名标志")
    @PreAuthorize("@ss.hasPermi('geom:NAMES:add')")
    @Log(title = "地名标志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GeographicalNames geographicalNames)
    {
        return toAjax(geographicalNamesService.insertGeographicalNames(geographicalNames));
    }

    /**
     * 修改地名标志
     */
    @ApiOperation("修改地名标志")
    @PreAuthorize("@ss.hasPermi('geom:NAMES:edit')")
    @Log(title = "地名标志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GeographicalNames geographicalNames)
    {

        return toAjax(geographicalNamesService.updateGeographicalNames(geographicalNames));
    }

    /**
     * 删除地名标志
     */
    @ApiOperation("删除地名标志")
    @PreAuthorize("@ss.hasPermi('geom:NAMES:remove')")
    @Log(title = "地名标志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(geographicalNamesService.deleteGeographicalNamesByOBJECTIDs(ids));
    }
}
