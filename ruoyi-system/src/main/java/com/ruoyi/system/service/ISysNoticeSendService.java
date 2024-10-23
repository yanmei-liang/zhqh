package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysNoticeSend;
import com.ruoyi.system.domain.vo.SysNoticeSendVo;

import java.util.Collection;
import java.util.List;

/**
 * @author liangyanmei
 * @Title: 用户公告阅读标记Service接口
 * @Description:
 * @date 2024/10/2220:02
 */
public interface ISysNoticeSendService {

    SysNoticeSend queryById(Long sendId);

    /**
     * 查询用户公告阅读标记列表
     */
    List<SysNoticeSendVo> queryPageList(SysNoticeSend bo);

    /**
     * 查询用户公告阅读标记列表
     */
    List<SysNoticeSend> queryList(SysNoticeSend bo);

    /**
     * 新增用户公告阅读标记
     */
    Boolean insertByBo(SysNoticeSend bo);

    /**
     * 修改用户公告阅读标记
     */
    Boolean updateByBo(SysNoticeSend bo);

    /**
     * 校验并批量删除用户公告阅读标记信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    SysNoticeSend getByUserIdNoticeId(Long userId, Long noticeId);

//    Page<NoticeSendModel> getMyNoticeSendPage(Page<NoticeSendModel> pageList, NoticeSendModel noticeSendModel);
}
