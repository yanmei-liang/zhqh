package com.ruoyi.web.controller.Dm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.government.domain.DmLimitMark;
import com.ruoyi.government.service.IDmLimitMarkService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 界桩Controller
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/government/MARK")
public class DmLimitMarkController extends BaseController
{
    @Autowired
    private IDmLimitMarkService dmLimitMarkService;

    /**
     * 查询界桩列表
     */
    @PreAuthorize("@ss.hasPermi('government:MARK:list')")
    @GetMapping("/list")
    public TableDataInfo list(@RequestBody(required = false) DmLimitMark dmLimitMark)
    {
        startPage();
        List<DmLimitMark> list = dmLimitMarkService.selectDmLimitMarkList(dmLimitMark);
        return getDataTable(list);
    }

    /**
     * 导出界桩列表
     */
    @PreAuthorize("@ss.hasPermi('government:MARK:export')")
    @Log(title = "界桩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmLimitMark dmLimitMark)
    {
        List<DmLimitMark> list = dmLimitMarkService.selectDmLimitMarkList(dmLimitMark);
        ExcelUtil<DmLimitMark> util = new ExcelUtil<DmLimitMark>(DmLimitMark.class);
        util.exportExcel(response, list, "界桩数据");
    }

    /**
     * 获取界桩详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:MARK:query')")
    @GetMapping(value = "/getInfo/{limitId}")
    public AjaxResult getInfo(@PathVariable("limitId") Long limitId)
    {
        return success(dmLimitMarkService.selectDmLimitMarkByLimitId(limitId));
    }

    /**
     * 新增界桩
     */
    @PreAuthorize("@ss.hasPermi('government:MARK:add')")
    @Log(title = "界桩", businessType = BusinessType.INSERT)
    @PostMapping("addLimitMark")
    public AjaxResult add(@RequestBody DmLimitMark dmLimitMark)
    {
        return toAjax(dmLimitMarkService.insertDmLimitMark(dmLimitMark));
    }

    /**
     * 修改界桩
     */
    @PreAuthorize("@ss.hasPermi('government:MARK:edit')")
    @Log(title = "界桩", businessType = BusinessType.UPDATE)
    @PutMapping("/editLimitMark")
    public AjaxResult edit(@RequestBody DmLimitMark dmLimitMark)
    {
        return toAjax(dmLimitMarkService.updateDmLimitMark(dmLimitMark));
    }

    /**
     * 删除界桩
     */
    @ApiOperation("删除界桩")
    @PreAuthorize("@ss.hasPermi('government:MARK:remove')")
    @Log(title = "界桩", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{limitIds}")
    public AjaxResult remove(@PathVariable Long[] limitIds)
    {
        return toAjax(dmLimitMarkService.deleteDmLimitMarkByLimitIds(limitIds));
    }
}
