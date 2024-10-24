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
import com.ruoyi.government.domain.DmTsjl;
import com.ruoyi.government.service.IDmTsjlService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推送记录Controller
 * 
 * @author ruoyi
 * @date 2024-10-24
 */
@RestController
@RequestMapping("/government/TSJL")
public class DmTsjlController extends BaseController
{
    @Autowired
    private IDmTsjlService dmTsjlService;

    /**
     * 查询推送记录列表
     */
    @PreAuthorize("@ss.hasPermi('government:TSJL:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmTsjl dmTsjl)
    {
        startPage();
        List<DmTsjl> list = dmTsjlService.selectDmTsjlList(dmTsjl);
        return getDataTable(list);
    }

    /**
     * 导出推送记录列表
     */
    @PreAuthorize("@ss.hasPermi('government:TSJL:export')")
    @Log(title = "推送记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmTsjl dmTsjl)
    {
        List<DmTsjl> list = dmTsjlService.selectDmTsjlList(dmTsjl);
        ExcelUtil<DmTsjl> util = new ExcelUtil<DmTsjl>(DmTsjl.class);
        util.exportExcel(response, list, "推送记录数据");
    }

    /**
     * 获取推送记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:TSJL:query')")
    @GetMapping(value = "/{tsjlId}")
    public AjaxResult getInfo(@PathVariable("tsjlId") Integer tsjlId)
    {
        return success(dmTsjlService.selectDmTsjlByTsjlId(tsjlId));
    }

    /**
     * 新增推送记录
     */
    @PreAuthorize("@ss.hasPermi('government:TSJL:add')")
    @Log(title = "推送记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmTsjl dmTsjl)
    {
        return toAjax(dmTsjlService.insertDmTsjl(dmTsjl));
    }

    /**
     * 修改推送记录
     */
    @PreAuthorize("@ss.hasPermi('government:TSJL:edit')")
    @Log(title = "推送记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmTsjl dmTsjl)
    {
        return toAjax(dmTsjlService.updateDmTsjl(dmTsjl));
    }

    /**
     * 删除推送记录
     */
    @PreAuthorize("@ss.hasPermi('government:TSJL:remove')")
    @Log(title = "推送记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tsjlIds}")
    public AjaxResult remove(@PathVariable Integer[] tsjlIds)
    {
        return toAjax(dmTsjlService.deleteDmTsjlByTsjlIds(tsjlIds));
    }
}
