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
import com.ruoyi.government.domain.GovernmentDeclare;
import com.ruoyi.government.service.IGovernmentDeclareService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地名申报Controller
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@RestController
@RequestMapping("/government/DECLARE")
public class GovernmentDeclareController extends BaseController
{
    @Autowired
    private IGovernmentDeclareService governmentDeclareService;

    /**
     * 查询地名申报列表
     */
    @PreAuthorize("@ss.hasPermi('government:DECLARE:list')")
    @GetMapping("/list")
    public TableDataInfo list(GovernmentDeclare governmentDeclare)
    {
        startPage();
        List<GovernmentDeclare> list = governmentDeclareService.selectGovernmentDeclareList(governmentDeclare);
        return getDataTable(list);
    }

    /**
     * 导出地名申报列表
     */
    @PreAuthorize("@ss.hasPermi('government:DECLARE:export')")
    @Log(title = "地名申报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GovernmentDeclare governmentDeclare)
    {
        List<GovernmentDeclare> list = governmentDeclareService.selectGovernmentDeclareList(governmentDeclare);
        ExcelUtil<GovernmentDeclare> util = new ExcelUtil<GovernmentDeclare>(GovernmentDeclare.class);
        util.exportExcel(response, list, "地名申报数据");
    }

    /**
     * 获取地名申报详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:DECLARE:query')")
    @GetMapping(value = "/{declareId}")
    public AjaxResult getInfo(@PathVariable("declareId") Long declareId)
    {
        return success(governmentDeclareService.selectGovernmentDeclareByDeclareId(declareId));
    }

    /**
     * 新增地名申报
     */
    @PreAuthorize("@ss.hasPermi('government:DECLARE:add')")
    @Log(title = "地名申报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GovernmentDeclare governmentDeclare)
    {
        return toAjax(governmentDeclareService.insertGovernmentDeclare(governmentDeclare));
    }

    /**
     * 修改地名申报
     */
    @PreAuthorize("@ss.hasPermi('government:DECLARE:edit')")
    @Log(title = "地名申报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GovernmentDeclare governmentDeclare)
    {
        return toAjax(governmentDeclareService.updateGovernmentDeclare(governmentDeclare));
    }

    /**
     * 删除地名申报
     */
    @PreAuthorize("@ss.hasPermi('government:DECLARE:remove')")
    @Log(title = "地名申报", businessType = BusinessType.DELETE)
	@DeleteMapping("/{declareIds}")
    public AjaxResult remove(@PathVariable Long[] declareIds)
    {
        return toAjax(governmentDeclareService.deleteGovernmentDeclareByDeclareIds(declareIds));
    }
}
