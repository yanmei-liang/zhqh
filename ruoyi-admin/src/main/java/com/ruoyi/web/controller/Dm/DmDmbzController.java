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
import com.ruoyi.government.domain.DmDmbz;
import com.ruoyi.government.service.IDmDmbzService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地名标志Controller
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@RestController
@RequestMapping("/government/DMBZ")
public class DmDmbzController extends BaseController
{
    @Autowired
    private IDmDmbzService dmDmbzService;

    /**
     * 查询地名标志列表
     */
    @PreAuthorize("@ss.hasPermi('government:DMBZ:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmDmbz dmDmbz)
    {
        startPage();
        List<DmDmbz> list = dmDmbzService.selectDmDmbzList(dmDmbz);
        return getDataTable(list);
    }

    /**
     * 导出地名标志列表
     */
    @PreAuthorize("@ss.hasPermi('government:DMBZ:export')")
    @Log(title = "地名标志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmDmbz dmDmbz)
    {
        List<DmDmbz> list = dmDmbzService.selectDmDmbzList(dmDmbz);
        ExcelUtil<DmDmbz> util = new ExcelUtil<DmDmbz>(DmDmbz.class);
        util.exportExcel(response, list, "地名标志数据");
    }

    /**
     * 获取地名标志详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:DMBZ:query')")
    @GetMapping(value = "/{dmbzId}")
    public AjaxResult getInfo(@PathVariable("dmbzId") Long dmbzId)
    {
        return success(dmDmbzService.selectDmDmbzByDmbzId(dmbzId));
    }

    /**
     * 新增地名标志
     */
    @PreAuthorize("@ss.hasPermi('government:DMBZ:add')")
    @Log(title = "地名标志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmDmbz dmDmbz)
    {
        return toAjax(dmDmbzService.insertDmDmbz(dmDmbz));
    }

    /**
     * 修改地名标志
     */
    @PreAuthorize("@ss.hasPermi('government:DMBZ:edit')")
    @Log(title = "地名标志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmDmbz dmDmbz)
    {
        return toAjax(dmDmbzService.updateDmDmbz(dmDmbz));
    }

    /**
     * 删除地名标志
     */
    @PreAuthorize("@ss.hasPermi('government:DMBZ:remove')")
    @Log(title = "地名标志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dmbzIds}")
    public AjaxResult remove(@PathVariable Long[] dmbzIds)
    {
        return toAjax(dmDmbzService.deleteDmDmbzByDmbzIds(dmbzIds));
    }
}
