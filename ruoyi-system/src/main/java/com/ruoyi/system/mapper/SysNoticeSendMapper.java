package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysNoticeSend;
import com.ruoyi.system.domain.vo.SysNoticeSendVo;

import java.util.Collection;
import java.util.List;

/**
 * @author liangyanmei
 * @Title: 用户公告阅读标记Mapper接口
 * @Description:
 * @date 2024/10/2220:01
 */
public interface SysNoticeSendMapper {

    boolean insertByBo(SysNoticeSend vo);

    SysNoticeSend queryById(Long sendId);

//    List<NoticeSendModel> getMyNoticeSendList(Page<NoticeSendModel> pageList, NoticeSendModel noticeSendModel);

    Boolean updateByBo(SysNoticeSend bo);

    Boolean deleteWithValidByIds(Collection<Long> ids);

    List<SysNoticeSendVo> queryPageList(SysNoticeSend bo);

    List<SysNoticeSend> queryList(SysNoticeSend bo);

    SysNoticeSend getByUserIdNoticeId(Long userId, Long noticeId);
}
