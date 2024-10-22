package com.ruoyi.web.controller.gis;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.gis.domain.GeoGraphicalRef;
import com.ruoyi.gis.service.IGeoGraphicalRefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 地图空间数据和地名关联对象Controller
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Api(tags = "地理空间数据-地图空间数据和地名关联对象")
@RestController
@RequestMapping("/gis/geomDMRef")
public class GeoGraphicalRefController extends BaseController
{
    @Autowired
    private IGeoGraphicalRefService geoGraphicalRefService;

    /**
     * 查询地图空间数据和地名关联对象列表
     */
    @ApiOperation("查询地图空间数据和地名关联对象列表")
    @PreAuthorize("@ss.hasPermi('geom:DEOMREF:list')")
    @GetMapping("/list")
    public TableDataInfo list(GeoGraphicalRef geoGraphicalRef)
    {
        startPage();
        List<GeoGraphicalRef> list = geoGraphicalRefService.selectGeoGraphicalRefList(geoGraphicalRef);
        return getDataTable(list);
    }

    /**
     * 导出地图空间数据和地名关联对象列表
     */
    @PreAuthorize("@ss.hasPermi('geom:DEOMREF:export')")
    @Log(title = "地图空间数据和地名关联对象", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GeoGraphicalRef geoGraphicalRef)
    {

        List<GeoGraphicalRef> list = geoGraphicalRefService.selectGeoGraphicalRefList(geoGraphicalRef);
        ExcelUtil<GeoGraphicalRef> util = new ExcelUtil<GeoGraphicalRef>(GeoGraphicalRef.class);
        util.exportExcel(response, list, "地图空间数据和地名关联对象数据");
    }

    /**
     * 获取地图空间数据和地名关联对象详细信息
     */
    @ApiOperation("获取地图空间数据和地名关联对象详细信息")
    @PreAuthorize("@ss.hasPermi('geom:DEOMREF:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(geoGraphicalRefService.selectGeoGraphicalRefByOBJECTID(id));
    }

    /**
     * 新增地图空间数据和地名关联对象
     */
    @ApiOperation("新增地图空间数据和地名关联对象")
    @PreAuthorize("@ss.hasPermi('geom:DEOMREF:add')")
    @Log(title = "地图空间数据和地名关联对象", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GeoGraphicalRef geoGraphicalRef)
    {
        return toAjax(geoGraphicalRefService.insertGeoGraphicalRef(geoGraphicalRef));
    }

    /**
     * 修改地图空间数据和地名关联对象
     */
    @ApiOperation("修改地图空间数据和地名关联对象")
    @PreAuthorize("@ss.hasPermi('geom:DEOMREF:edit')")
    @Log(title = "地图空间数据和地名关联对象", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GeoGraphicalRef geoGraphicalRef)
    {

        return toAjax(geoGraphicalRefService.updateGeoGraphicalRef(geoGraphicalRef));
    }

    /**
     * 删除地图空间数据和地名关联对象
     */
    @ApiOperation("删除地图空间数据和地名关联对象")
    @PreAuthorize("@ss.hasPermi('geom:DEOMREF:remove')")
    @Log(title = "地图空间数据和地名关联对象", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(geoGraphicalRefService.deleteGeoGraphicalRefByOBJECTIDs(ids));
    }
}
