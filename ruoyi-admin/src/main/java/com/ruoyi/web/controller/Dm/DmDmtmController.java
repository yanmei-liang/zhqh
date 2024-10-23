package com.ruoyi.government.controller;

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
import com.ruoyi.government.domain.DmDmtm;
import com.ruoyi.government.service.IDmDmtmService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 通名管理Controller
 * 
 * @author ruoyi
 * @date 2024-10-22
 */
@RestController
@RequestMapping("/government/DMTM")
public class DmDmtmController extends BaseController
{
    @Autowired
    private IDmDmtmService dmDmtmService;

    /**
     * 查询通名管理列表
     */
    @PreAuthorize("@ss.hasPermi('government:DMTM:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmDmtm dmDmtm)
    {
        startPage();
        List<DmDmtm> list = dmDmtmService.selectDmDmtmList(dmDmtm);
        return getDataTable(list);
    }

    /**
     * 导出通名管理列表
     */
    @PreAuthorize("@ss.hasPermi('government:DMTM:export')")
    @Log(title = "通名管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmDmtm dmDmtm)
    {
        List<DmDmtm> list = dmDmtmService.selectDmDmtmList(dmDmtm);
        ExcelUtil<DmDmtm> util = new ExcelUtil<DmDmtm>(DmDmtm.class);
        util.exportExcel(response, list, "通名管理数据");
    }

    /**
     * 获取通名管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:DMTM:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Integer Id)
    {
        return success(dmDmtmService.selectDmDmtmById(Id));
    }

    /**
     * 新增通名管理
     */
    @PreAuthorize("@ss.hasPermi('government:DMTM:add')")
    @Log(title = "通名管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmDmtm dmDmtm)
    {
        return toAjax(dmDmtmService.insertDmDmtm(dmDmtm));
    }

    /**
     * 修改通名管理
     */
    @PreAuthorize("@ss.hasPermi('government:DMTM:edit')")
    @Log(title = "通名管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmDmtm dmDmtm)
    {
        return toAjax(dmDmtmService.updateDmDmtm(dmDmtm));
    }

    /**
     * 删除通名管理
     */
    @PreAuthorize("@ss.hasPermi('government:DMTM:remove')")
    @Log(title = "通名管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Integer[] Ids)
    {
        return toAjax(dmDmtmService.deleteDmDmtmByIds(Ids));
    }
}
