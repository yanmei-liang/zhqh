package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author liangyanmei
 * @Title: 用户公告阅读标记视图对象 sys_notice_send
 * @Description:
 * @date 2024/10/23 14:05
 */
@Data
public class SysNoticeSendVo {

    private static final long serialVersionUID = 1L;

    /**
     * 公告发送ID
     */
    private Long sendId;

    /**
     * 公告ID
     */
    private Long noticeId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 阅读状态（0未读，1已读）
     */
    private String readFlag;

    /**
     * 阅读时间
     */
    private Date readTime;
}
