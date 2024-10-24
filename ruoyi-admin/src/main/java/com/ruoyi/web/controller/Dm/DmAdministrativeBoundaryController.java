package com.ruoyi.web.controller.Dm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.government.domain.vo.ExportFileDmAdministrativeBoundary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liquibase.pro.packaged.A;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.government.domain.DmAdministrativeBoundary;
import com.ruoyi.government.service.IDmAdministrativeBoundaryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行政界线Controller
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@Api(tags = "行政界线")
@RestController
@RequestMapping("/government/BOUNDARY")
public class DmAdministrativeBoundaryController extends BaseController
{
    @Autowired
    private IDmAdministrativeBoundaryService dmAdministrativeBoundaryService;

    /**
     * 查询行政界线列表
     */
    @ApiOperation("获取数据列表")
    @PreAuthorize("@ss.hasPermi('government:BOUNDARY:list')")
    @GetMapping("/list")
    public AjaxResult list(DmAdministrativeBoundary dmAdministrativeBoundary)
    {
        Map<String,Object> map=new HashMap<>();
        startPage();
        List<DmAdministrativeBoundary> list = dmAdministrativeBoundaryService.selectDmAdministrativeBoundaryList(dmAdministrativeBoundary);
        List<ExportFileDmAdministrativeBoundary> RankStatistics = dmAdministrativeBoundaryService.selectRankStatistics();
        List<ExportFileDmAdministrativeBoundary> DivisionStatistics = dmAdministrativeBoundaryService.selectDivisionStatistics();
        Integer count = dmAdministrativeBoundaryService.selectDmAdministrativeBoundaryCount(dmAdministrativeBoundary);
        map.put("total",count);
        map.put("list",list);
        map.put("RankStatistics",RankStatistics);
        map.put("DivisionStatistics",DivisionStatistics);
        return AjaxResult.success(map);
    }

    /**
     * 导出行政界线列表
     */
    @PreAuthorize("@ss.hasPermi('government:BOUNDARY:export')")
    @Log(title = "行政界线", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmAdministrativeBoundary dmAdministrativeBoundary)
    {
        List<DmAdministrativeBoundary> list = dmAdministrativeBoundaryService.selectDmAdministrativeBoundaryList(dmAdministrativeBoundary);
        ExcelUtil<DmAdministrativeBoundary> util = new ExcelUtil<DmAdministrativeBoundary>(DmAdministrativeBoundary.class);
        util.exportExcel(response, list, "行政界线数据");
    }

    /**
     * 获取行政界线详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:BOUNDARY:query')")
    @GetMapping(value = "/getInfo/{boundaryId}")
    public AjaxResult getInfo(@PathVariable("boundaryId") Long boundaryId)
    {
        return success(dmAdministrativeBoundaryService.selectDmAdministrativeBoundaryByBoundaryId(boundaryId));
    }

    /**
     * 新增行政界线
     */
    @PreAuthorize("@ss.hasPermi('government:BOUNDARY:add')")
    @Log(title = "行政界线", businessType = BusinessType.INSERT)
    @PostMapping("/addAdministrativeBoundary")
    public AjaxResult add(@RequestBody DmAdministrativeBoundary dmAdministrativeBoundary)
    {
        return toAjax(dmAdministrativeBoundaryService.insertDmAdministrativeBoundary(dmAdministrativeBoundary));
    }

    /**
     * 修改行政界线
     */
    @PreAuthorize("@ss.hasPermi('government:BOUNDARY:edit')")
    @Log(title = "行政界线", businessType = BusinessType.UPDATE)
    @PutMapping("/editAdministrativeBoundary")
    public AjaxResult edit(@RequestBody DmAdministrativeBoundary dmAdministrativeBoundary)
    {
        return toAjax(dmAdministrativeBoundaryService.updateDmAdministrativeBoundary(dmAdministrativeBoundary));
    }

    /**
     * 删除行政界线
     */
    @ApiOperation("删除行政界线")
    @PreAuthorize("@ss.hasPermi('government:BOUNDARY:remove')")
    @Log(title = "行政界线", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{boundaryIds}")
    public AjaxResult remove(@PathVariable Long[] boundaryIds)
    {
        return toAjax(dmAdministrativeBoundaryService.deleteDmAdministrativeBoundaryByBoundaryIds(boundaryIds));
    }
}
