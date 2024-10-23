package com.ruoyi.system.service.impl;


import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.SysNoticeSend;
import com.ruoyi.system.domain.vo.SysNoticeSendVo;
import com.ruoyi.system.mapper.SysNoticeSendMapper;
import com.ruoyi.system.model.NoticeSendModel;
import com.ruoyi.system.service.ISysNoticeSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author liangyanmei
 * @Title: 用户公告阅读标记Service业务层处理
 * @Description:
 * @date 2024/10/22 20:08
 */
@RequiredArgsConstructor
@Service
public class SysNoticeSendServiceImpl implements ISysNoticeSendService {

    private final SysNoticeSendMapper baseMapper;

    @Override
    public SysNoticeSend queryById(Long sendId) {
        return baseMapper.queryById(sendId);
    }

    @Override
    public List<SysNoticeSendVo> queryPageList(SysNoticeSend bo) {
       //// TODO: 2024/10/23
        return baseMapper.queryPageList(bo);
    }

    @Override
    public List<SysNoticeSend> queryList(SysNoticeSend bo) {
        return baseMapper.queryList(bo);
    }

    @Override
    public Boolean insertByBo(SysNoticeSend bo) {
        return baseMapper.insertByBo(bo);
    }

    @Override
    public Boolean updateByBo(SysNoticeSend bo) {
        return baseMapper.updateByBo(bo);
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return baseMapper.deleteWithValidByIds(ids);
    }

    @Override
    public SysNoticeSend getByUserIdNoticeId(Long userId, Long noticeId) {
        return baseMapper.getByUserIdNoticeId(userId, noticeId);
    }

//
//    @Override
//    public Page<NoticeSendModel> getMyNoticeSendPage(Page<NoticeSendModel> pageList, NoticeSendModel noticeSendModel) {
//        return (Page<NoticeSendModel>) baseMapper.getMyNoticeSendList(pageList, noticeSendModel);
//    }
}
