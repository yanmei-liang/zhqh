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
import com.ruoyi.government.domain.DmDmlb;
import com.ruoyi.government.service.IDmDmlbService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地名类别Controller
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@RestController
@RequestMapping("/government/DMLB")
public class DmDmlbController extends BaseController
{
    @Autowired
    private IDmDmlbService dmDmlbService;

    /**
     * 查询地名类别列表
     */
    @PreAuthorize("@ss.hasPermi('government:DMLB:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmDmlb dmDmlb)
    {
        startPage();
        List<DmDmlb> list = dmDmlbService.selectDmDmlbList(dmDmlb);
        return getDataTable(list);
    }

    /**
     * 导出地名类别列表
     */
    @PreAuthorize("@ss.hasPermi('government:DMLB:export')")
    @Log(title = "地名类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmDmlb dmDmlb)
    {
        List<DmDmlb> list = dmDmlbService.selectDmDmlbList(dmDmlb);
        ExcelUtil<DmDmlb> util = new ExcelUtil<DmDmlb>(DmDmlb.class);
        util.exportExcel(response, list, "地名类别数据");
    }

    /**
     * 获取地名类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:DMLB:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(dmDmlbService.selectDmDmlbById(id));
    }

    /**
     * 新增地名类别
     */
    @PreAuthorize("@ss.hasPermi('government:DMLB:add')")
    @Log(title = "地名类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmDmlb dmDmlb)
    {
        return toAjax(dmDmlbService.insertDmDmlb(dmDmlb));
    }

    /**
     * 修改地名类别
     */
    @PreAuthorize("@ss.hasPermi('government:DMLB:edit')")
    @Log(title = "地名类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmDmlb dmDmlb)
    {
        return toAjax(dmDmlbService.updateDmDmlb(dmDmlb));
    }

    /**
     * 删除地名类别
     */
    @PreAuthorize("@ss.hasPermi('government:DMLB:remove')")
    @Log(title = "地名类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(dmDmlbService.deleteDmDmlbByIds(ids));
    }
}
