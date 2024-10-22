package com.ruoyi.web.controller.Dm;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.government.domain.vo.ExportFile;
import io.swagger.annotations.Api;
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
@Api(tags = "行政区划管理")
@RestController
@RequestMapping("/government/DIVISIONS")
public class DmAdministrativeDivisionsController extends BaseController
{
    @Autowired
    private IDmAdministrativeDivisionsService dmAdministrativeDivisionsService;

    /**
     * 统计面积
     */
    @ApiOperation("统计面积,administrativeDivisionCode参数")
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:list')")
    @GetMapping("/selAreaRadius/{administrativeDivisionCode}")
    public AjaxResult selAreaRadius(@PathVariable("administrativeDivisionCode") String administrativeDivisionCode)
    {
        return AjaxResult.success(dmAdministrativeDivisionsService.selAreaRadius(administrativeDivisionCode));
    }


    /**
     * 统计级别
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:list')")
    @ApiOperation("统计级别,administrativeDivisionCode参数")
    @GetMapping("/selAdministrativeLevel/{administrativeDivisionCode}")
    public AjaxResult selectDmAdministrativeByAdministrativeLevel(@PathVariable("administrativeDivisionCode") String administrativeDivisionCode)
    {
        return AjaxResult.success(dmAdministrativeDivisionsService.selStatisticallevel(administrativeDivisionCode));
    }

    /**
     * 返回行政级别下拉框
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:list')")
    @GetMapping("/selStatisticallevel")
    public AjaxResult selStatisticallevel()
    {
        return AjaxResult.success(dmAdministrativeDivisionsService.selectDmAdministrativeByAdministrativeLevel());
    }

    /**
     * 查询行政区划列表
     */
    @ApiOperation("获取数据列表")
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:list')")
    @GetMapping("/list")
    public AjaxResult list(@RequestBody(required = false) DmAdministrativeDivisions obj)
    {
        Map<String,Object> map=new HashMap<>();
        startPage();
        List<DmAdministrativeDivisions> list = dmAdministrativeDivisionsService.selectDmAdministrativeDivisionsList(obj);
        if(list.isEmpty()){
            return AjaxResult.error("查询不到数据");
        } else {
//            String administrativeDivisionCode = list.get(0).getAdministrativeDivisionCode();
            String administrativeDivisionCode = "420323";
            List<Map<String, Integer>> StatisticallevelList = dmAdministrativeDivisionsService.selStatisticallevel(administrativeDivisionCode);
            List<Map<String, Integer>> selAreaRadiusList = dmAdministrativeDivisionsService.selAreaRadius(administrativeDivisionCode);
            Integer administrativeCount = dmAdministrativeDivisionsService.selectDmAdministrativeCount(obj);
            map.put("total",administrativeCount);
            map.put("list",list);
            map.put("StatisticallevelList",StatisticallevelList);
            map.put("selAreaRadiusList",selAreaRadiusList);
            return AjaxResult.success(map);
        }
    }

    /**
     * 导出级别类型
     */
    @ApiOperation("导出级别类型")
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:export')")
    @Log(title = "导出级别类型", businessType = BusinessType.EXPORT)
    @PostMapping("/exportStatisticallevelList")
    public void exportStatisticallevelList(HttpServletResponse response, @RequestBody(required = false) String superiorsCode)
    {
        List<ExportFile> exportFiles = dmAdministrativeDivisionsService.exportSelStatisticallevel(superiorsCode);
        ExcelUtil<ExportFile> util = new ExcelUtil<ExportFile>(ExportFile.class);
        util.exportExcel(response, exportFiles, "级别统计");
    }

    /**
     * 导出面积统计
     */
    @ApiOperation("导出面积统计")
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:export')")
    @Log(title = "导出面积统计", businessType = BusinessType.EXPORT)
    @PostMapping("/exportselAreaRadius")
    public void exportselAreaRadius(HttpServletResponse response, @RequestBody(required = false) String superiorsCode)
    {
        List<ExportFile> exportFiles = dmAdministrativeDivisionsService.exportselAreaRadius(superiorsCode);
        ExcelUtil<ExportFile> util = new ExcelUtil<ExportFile>(ExportFile.class);
        util.exportExcel(response, exportFiles, "面积统计");
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
    @GetMapping(value = "/getInfo/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") Long ID)
    {
        return success(dmAdministrativeDivisionsService.selectDmAdministrativeDivisionsByID(ID));
    }

    /**
     * 新增行政区划
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:add')")
    @Log(title = "行政区划", businessType = BusinessType.INSERT)
    @PostMapping("/addAdministrativeDivisions")
    public AjaxResult add(@RequestBody DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        return toAjax(dmAdministrativeDivisionsService.insertDmAdministrativeDivisions(dmAdministrativeDivisions));
    }

    /**
     * 修改行政区划
     */
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:edit')")
    @Log(title = "行政区划", businessType = BusinessType.UPDATE)
    @PutMapping("/editAdministrativeDivisions")
    public AjaxResult edit(@RequestBody DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        return toAjax(dmAdministrativeDivisionsService.updateDmAdministrativeDivisions(dmAdministrativeDivisions));
    }

    /**
     * 删除行政区划
     */
    @ApiOperation("删除行政区划")
    @PreAuthorize("@ss.hasPermi('government:DIVISIONS:remove')")
    @Log(title = "行政区划", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{IDs}")
    public AjaxResult remove(@PathVariable("IDs") Long[] IDs)
    {
        return toAjax(dmAdministrativeDivisionsService.deleteDmAdministrativeDivisionsByIDs(IDs));
    }
}
