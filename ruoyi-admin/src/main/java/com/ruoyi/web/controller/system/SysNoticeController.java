package com.ruoyi.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.SysNoticeSend;
import com.ruoyi.system.service.ISysNoticeSendService;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysNoticeService;

/**
 * 公告 信息操作处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/notice")
public class SysNoticeController extends BaseController
{
    @Autowired
    private ISysNoticeService noticeService;

    @Autowired
    private ISysNoticeSendService noticeSendService;

    /**
     * 获取通知公告列表
     */
    @PreAuthorize("@ss.hasPermi('system:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysNotice notice)
    {
        startPage();
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 根据通知公告编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable Long noticeId)
    {
        return success(noticeService.selectNoticeById(noticeId));
    }

    /**
     * 新增通知公告
     */
    @PreAuthorize("@ss.hasPermi('system:notice:add')")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysNotice notice)
    {
        notice.setCreateBy(getUsername());
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * 修改通知公告
     */
    @PreAuthorize("@ss.hasPermi('system:notice:edit')")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysNotice notice)
    {
        notice.setUpdateBy(getUsername());
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除通知公告
     */
    @PreAuthorize("@ss.hasPermi('system:notice:remove')")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(noticeService.deleteNoticeByIds(noticeIds));
    }

    /**
     * 补充用户数据，并返回系统消息
     * @return
     */
    @Log(title = "系统消息")
    @GetMapping("/listByUser")
    public R<Map<String, Object>> listByUser(@RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Long userId = loginUser.getUserId();
        // 1.将系统消息补充到用户通告阅读标记表中
//        LambdaQueryWrapper<SysNotice> querySaWrapper = new LambdaQueryWrapper<SysNotice>();
//        querySaWrapper.eq(SysNotice::getMsgType, Constants.MSG_TYPE_ALL); // 全部人员
//        querySaWrapper.eq(SysNotice::getStatus,Constants.CLOSE_FLAG_0.toString());  // 未关闭
//        querySaWrapper.eq(SysNotice::getSendStatus, Constants.HAS_SEND); //已发布
//        //querySaWrapper.ge(SysNotice::getEndTime, loginUser.getCreateTime()); //新注册用户不看结束通知
//        querySaWrapper.notInSql(SysNotice::getNoticeId,"select notice_id from sys_notice_send where user_id='"+userId+"'");
        List<SysNotice> notices = noticeService.listByUserId(userId);
        if(notices.size()>0) {
            for(int i=0;i<notices.size();i++) {
                //因为websocket没有判断是否存在这个用户，要是判断会出现问题，故在此判断逻辑
//                LambdaQueryWrapper<SysNoticeSend> query = new LambdaQueryWrapper<>();
//                query.eq(SysNoticeSend::getNoticeId,notices.get(i).getNoticeId());
//                query.eq(SysNoticeSend::getUserId,userId);
                SysNoticeSend one = noticeSendService.getByUserIdNoticeId(userId, notices.get(i).getNoticeId());
                if(null==one){
                    SysNoticeSend noticeSend = new SysNoticeSend();
                    noticeSend.setNoticeId(notices.get(i).getNoticeId());
                    noticeSend.setUserId(userId);
                    noticeSend.setReadFlag(Constants.NO_READ_FLAG);
                    noticeSendService.insertByBo(noticeSend);
                }
            }
        }
        // 2.查询用户未读的系统消息
        startPage();
        List<SysNotice> sysNoticeList = noticeService.querySysNoticeByUserId("1",userId);//通知公告消息
        TableDataInfo tableDataInfoAnnt = getDataTable(sysNoticeList);
        startPage();
        List<SysNotice> sysMsgList = noticeService.querySysNoticeByUserId("2",userId);//系统消息
        TableDataInfo tableDataInfoMsg = getDataTable(sysMsgList);
        startPage();
        List<SysNotice> todealMsgList = noticeService.querySysNoticeByUserId("3", userId);//待办消息
        TableDataInfo tableDataInfoDeal = getDataTable(todealMsgList);
        Map<String,Object> sysMsgMap = new HashMap<String, Object>();
        sysMsgMap.put("sysMsgList", tableDataInfoMsg.getRows());
        sysMsgMap.put("sysMsgTotal", tableDataInfoMsg.getTotal());
        sysMsgMap.put("anntMsgList", tableDataInfoAnnt.getRows());
        sysMsgMap.put("anntMsgTotal", tableDataInfoAnnt.getTotal());
        sysMsgMap.put("todealMsgList", tableDataInfoDeal.getRows());
        sysMsgMap.put("todealMsgTotal", tableDataInfoDeal .getTotal());
        return R.ok(sysMsgMap);
    }
}
