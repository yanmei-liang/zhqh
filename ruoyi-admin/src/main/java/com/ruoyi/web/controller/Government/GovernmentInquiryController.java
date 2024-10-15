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
import com.ruoyi.government.domain.GovernmentInquiry;
import com.ruoyi.government.service.IGovernmentInquiryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地名预审格Controller
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@RestController
@RequestMapping("/government/INQUIRY")
public class GovernmentInquiryController extends BaseController
{
    @Autowired
    private IGovernmentInquiryService governmentInquiryService;

    /**
     * 查询地名预审格列表
     */
    @PreAuthorize("@ss.hasPermi('government:INQUIRY:list')")
    @GetMapping("/list")
    public TableDataInfo list(GovernmentInquiry governmentInquiry)
    {
        startPage();
        List<GovernmentInquiry> list = governmentInquiryService.selectGovernmentInquiryList(governmentInquiry);
        return getDataTable(list);
    }

    /**
     * 导出地名预审格列表
     */
    @PreAuthorize("@ss.hasPermi('government:INQUIRY:export')")
    @Log(title = "地名预审格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GovernmentInquiry governmentInquiry)
    {
        List<GovernmentInquiry> list = governmentInquiryService.selectGovernmentInquiryList(governmentInquiry);
        ExcelUtil<GovernmentInquiry> util = new ExcelUtil<GovernmentInquiry>(GovernmentInquiry.class);
        util.exportExcel(response, list, "地名预审格数据");
    }

    /**
     * 获取地名预审格详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:INQUIRY:query')")
    @GetMapping(value = "/{inquiryId}")
    public AjaxResult getInfo(@PathVariable("inquiryId") Long inquiryId)
    {
        return success(governmentInquiryService.selectGovernmentInquiryByInquiryId(inquiryId));
    }

    /**
     * 新增地名预审格
     */
    @PreAuthorize("@ss.hasPermi('government:INQUIRY:add')")
    @Log(title = "地名预审格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GovernmentInquiry governmentInquiry)
    {
        return toAjax(governmentInquiryService.insertGovernmentInquiry(governmentInquiry));
    }

    /**
     * 修改地名预审格
     */
    @PreAuthorize("@ss.hasPermi('government:INQUIRY:edit')")
    @Log(title = "地名预审格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GovernmentInquiry governmentInquiry)
    {
        return toAjax(governmentInquiryService.updateGovernmentInquiry(governmentInquiry));
    }

    /**
     * 删除地名预审格
     */
    @PreAuthorize("@ss.hasPermi('government:INQUIRY:remove')")
    @Log(title = "地名预审格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inquiryIds}")
    public AjaxResult remove(@PathVariable Long[] inquiryIds)
    {
        return toAjax(governmentInquiryService.deleteGovernmentInquiryByInquiryIds(inquiryIds));
    }
}
