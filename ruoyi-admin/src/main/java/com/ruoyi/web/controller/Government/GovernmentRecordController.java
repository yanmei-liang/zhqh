package com.ruoyi.web.controller.Government;

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
import com.ruoyi.government.domain.GovernmentRecord;
import com.ruoyi.government.service.IGovernmentRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地名备案Controller
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@RestController
@RequestMapping("/government/RECORD")
public class GovernmentRecordController extends BaseController
{
    @Autowired
    private IGovernmentRecordService governmentRecordService;

    /**
     * 查询地名备案列表
     */
    @PreAuthorize("@ss.hasPermi('government:RECORD:list')")
    @GetMapping("/list")
    public TableDataInfo list(GovernmentRecord governmentRecord)
    {
        startPage();
        List<GovernmentRecord> list = governmentRecordService.selectGovernmentRecordList(governmentRecord);
        return getDataTable(list);
    }

    /**
     * 导出地名备案列表
     */
    @PreAuthorize("@ss.hasPermi('government:RECORD:export')")
    @Log(title = "地名备案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GovernmentRecord governmentRecord)
    {
        List<GovernmentRecord> list = governmentRecordService.selectGovernmentRecordList(governmentRecord);
        ExcelUtil<GovernmentRecord> util = new ExcelUtil<GovernmentRecord>(GovernmentRecord.class);
        util.exportExcel(response, list, "地名备案数据");
    }

    /**
     * 获取地名备案详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:RECORD:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(governmentRecordService.selectGovernmentRecordByRecordId(recordId));
    }

    /**
     * 新增地名备案
     */
    @PreAuthorize("@ss.hasPermi('government:RECORD:add')")
    @Log(title = "地名备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GovernmentRecord governmentRecord)
    {
        return toAjax(governmentRecordService.insertGovernmentRecord(governmentRecord));
    }

    /**
     * 修改地名备案
     */
    @PreAuthorize("@ss.hasPermi('government:RECORD:edit')")
    @Log(title = "地名备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GovernmentRecord governmentRecord)
    {
        return toAjax(governmentRecordService.updateGovernmentRecord(governmentRecord));
    }

    /**
     * 删除地名备案
     */
    @PreAuthorize("@ss.hasPermi('government:RECORD:remove')")
    @Log(title = "地名备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(governmentRecordService.deleteGovernmentRecordByRecordIds(recordIds));
    }
}
