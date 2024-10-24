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
import com.ruoyi.government.domain.DmPtjkdj;
import com.ruoyi.government.service.IDmPtjkdjService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 平台接口对接模块Controller
 *
 * @author ruoyi
 * @date 2024-10-24
 */
@RestController
@RequestMapping("/government/PTJKDJ")
public class DmPtjkdjController extends BaseController
{
    @Autowired
    private IDmPtjkdjService dmPtjkdjService;

    /**
     * 查询平台接口对接模块列表
     */
    @PreAuthorize("@ss.hasPermi('government:PTJKDJ:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmPtjkdj dmPtjkdj)
    {
        startPage();
        List<DmPtjkdj> list = dmPtjkdjService.selectDmPtjkdjList(dmPtjkdj);
        return getDataTable(list);
    }

    /**
     * 导出平台接口对接模块列表
     */
    @PreAuthorize("@ss.hasPermi('government:PTJKDJ:export')")
    @Log(title = "平台接口对接模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmPtjkdj dmPtjkdj)
    {
        List<DmPtjkdj> list = dmPtjkdjService.selectDmPtjkdjList(dmPtjkdj);
        ExcelUtil<DmPtjkdj> util = new ExcelUtil<DmPtjkdj>(DmPtjkdj.class);
        util.exportExcel(response, list, "平台接口对接模块数据");
    }

    /**
     * 获取平台接口对接模块详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:PTJKDJ:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") Integer ID)
    {
        return success(dmPtjkdjService.selectDmPtjkdjByID(ID));
    }

    /**
     * 新增平台接口对接模块
     */
    @PreAuthorize("@ss.hasPermi('government:PTJKDJ:add')")
    @Log(title = "平台接口对接模块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmPtjkdj dmPtjkdj)
    {
        return toAjax(dmPtjkdjService.insertDmPtjkdj(dmPtjkdj));
    }

    /**
     * 修改平台接口对接模块
     */
    @PreAuthorize("@ss.hasPermi('government:PTJKDJ:edit')")
    @Log(title = "平台接口对接模块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmPtjkdj dmPtjkdj)
    {
        return toAjax(dmPtjkdjService.updateDmPtjkdj(dmPtjkdj));
    }

    /**
     * 删除平台接口对接模块
     */
    @PreAuthorize("@ss.hasPermi('government:PTJKDJ:remove')")
    @Log(title = "平台接口对接模块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable Integer[] IDs)
    {
        return toAjax(dmPtjkdjService.deleteDmPtjkdjByIDs(IDs));
    }
}
