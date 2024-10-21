package com.ruoyi.web.controller.Dm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.government.domain.DmBase;
import com.ruoyi.government.service.IDmBaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标准地名Controller
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@Api(tags = "标准地名管理")
@RestController
@RequestMapping("/government/BASE")
public class DmBaseController extends BaseController
{
    @Autowired
    private IDmBaseService dmBaseService;

    /**
     * 查询标准地名列表
     */
    @ApiOperation("获取数据列表")
    @PreAuthorize("@ss.hasPermi('government:BASE:list')")
    @GetMapping("/list")
    public AjaxResult list(@RequestBody(required = false) DmBase dmBase)
    {
        Map<String,Object> map=new HashMap<>();
        startPage();
        List<DmBase> list = dmBaseService.selectDmBaseList(dmBase);
        List<ExportFile> exportFiles = dmBaseService.selectDmBaseByDmStatistics();
        List<ExportFile> exportFiles1 = dmBaseService.selectDmBaseDivisionStatistics();
        Integer count = dmBaseService.selectDmBaseCount(dmBase);
        map.put("total",count);
        map.put("list",list);
        map.put("DmStatistics",exportFiles);
        map.put("DivisionStatistics",exportFiles1);
        return AjaxResult.success(map);
    }

    /**
     * 地名标志类别统计
     */
   /* @PreAuthorize("@ss.hasPermi('government:BASE:list')")
    @GetMapping("/lists")
    public List<ExportFile> selectDmBaseByDmStatistics() {
        return dmBaseService.selectDmBaseByDmStatistics();
    }*/

    /**
     * 按地名标志区划统计
     * */
    /*@PreAuthorize("@ss.hasPermi('government:BASE:list')")
    @GetMapping("/lists1")
    public List<ExportFile> selectDmBaseDivisionStatistics(){
        return dmBaseService.selectDmBaseDivisionStatistics();
    }*/

    /**
     * 导出标准地名列表
     */
    @PreAuthorize("@ss.hasPermi('government:BASE:export')")
    @Log(title = "标准地名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmBase dmBase)
    {
        List<DmBase> list = dmBaseService.selectDmBaseList(dmBase);
        ExcelUtil<DmBase> util = new ExcelUtil<DmBase>(DmBase.class);
        util.exportExcel(response, list, "标准地名数据");
    }

    /**
     * 获取标准地名详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:BASE:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(dmBaseService.selectDmBaseById(id));
    }

    /**
     * 新增标准地名
     */
    @PreAuthorize("@ss.hasPermi('government:BASE:add')")
    @Log(title = "标准地名", businessType = BusinessType.INSERT)
    @PostMapping("/addDmBase")
    public AjaxResult add(@RequestBody DmBase dmBase)
    {
        return toAjax(dmBaseService.insertDmBase(dmBase));
    }

    /**
     * 修改标准地名
     */
    @PreAuthorize("@ss.hasPermi('government:BASE:edit')")
    @Log(title = "标准地名", businessType = BusinessType.UPDATE)
    @PutMapping("/editDmBase")
    public AjaxResult edit(@RequestBody DmBase dmBase)
    {
        return toAjax(dmBaseService.updateDmBase(dmBase));
    }

    /**
     * 删除标准地名
     */
    @ApiOperation("删除标准地名")
    @PreAuthorize("@ss.hasPermi('government:BASE:remove')")
    @Log(title = "标准地名", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(dmBaseService.deleteDmBaseByIds(ids));
    }
}
