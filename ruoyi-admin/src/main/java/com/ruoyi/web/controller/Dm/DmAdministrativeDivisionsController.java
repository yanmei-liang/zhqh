package com.ruoyi.web.controller.Dm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.government.domain.DmAdministrativeDivisions;
import com.ruoyi.government.service.IDmAdministrativeDivisionsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行政区划Controller
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@RestController
@RequestMapping("/government/DIVISIONS")
public class DmAdministrativeDivisionsController extends BaseController
{
    @Autowired
    private IDmAdministrativeDivisionsService dmAdministrativeDivisionsService;


    /**
     * 返回行政级别下拉框
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:list')")
    @GetMapping("/selAdministrativeLevel")
    public AjaxResult selectDmAdministrativeByAdministrativeLevel()
    {
        return AjaxResult.success(dmAdministrativeDivisionsService.selectDmAdministrativeByAdministrativeLevel());
    }

    /**
     * 查询行政区划列表
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        startPage();
        List<DmAdministrativeDivisions> list = dmAdministrativeDivisionsService.selectDmAdministrativeDivisionsList(dmAdministrativeDivisions);
        return getDataTable(list);
    }

    /**
     * 导出行政区划列表
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:export')")
    @Log(title = "行政区划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        List<DmAdministrativeDivisions> list = dmAdministrativeDivisionsService.selectDmAdministrativeDivisionsList(dmAdministrativeDivisions);
        ExcelUtil<DmAdministrativeDivisions> util = new ExcelUtil<DmAdministrativeDivisions>(DmAdministrativeDivisions.class);
        util.exportExcel(response, list, "行政区划数据");
    }

    /**
     * 获取行政区划详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") Long ID)
    {
        return success(dmAdministrativeDivisionsService.selectDmAdministrativeDivisionsByID(ID));
    }

    /**
     * 新增行政区划
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:add')")
    @Log(title = "行政区划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        return toAjax(dmAdministrativeDivisionsService.insertDmAdministrativeDivisions(dmAdministrativeDivisions));
    }

    /**
     * 修改行政区划
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:edit')")
    @Log(title = "行政区划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        return toAjax(dmAdministrativeDivisionsService.updateDmAdministrativeDivisions(dmAdministrativeDivisions));
    }

    /**
     * 删除行政区划
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:remove')")
    @Log(title = "行政区划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable Long[] IDs)
    {
        return toAjax(dmAdministrativeDivisionsService.deleteDmAdministrativeDivisionsByIDs(IDs));
    }
}
