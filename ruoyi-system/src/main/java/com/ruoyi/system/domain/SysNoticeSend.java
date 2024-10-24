package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author liangyanmei
 * @Title: 用户公告阅读标记对象
 * @Description:
 * @date 2024/10/22 19:48
 */
@Data
public class SysNoticeSend extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 公告发送ID
     */
    @TableId(value = "send_id")
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
