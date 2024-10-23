package com.ruoyi.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author liangyanmei
 * @Title: 用户通告阅读标记表
 * @Description:
 * @date 2024/10/2220:14
 */
@Data
public class NoticeSendModel {

    /**id*/
    private java.lang.Long sendId;
    /**通告id*/
    private java.lang.Long noticeId;
    /**用户id*/
    private java.lang.Long userId;
    /**标题*/
    private java.lang.String noticeTitle;
    /**内容*/
    private java.lang.String noticeContent;
    /**发布人*/
    private java.lang.String sender;
    /**优先级（L低，M中，H高）*/
    private java.lang.String priority;
    /**阅读状态*/
    private java.lang.String readFlag;
    /**发布时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date sendTime;
    /**页数*/
    private java.lang.Integer pageNo;
    /**大小*/
    private java.lang.Integer pageSize;
    /**
     * 消息类型1:通知公告2:系统消息3:待办
     */
    private java.lang.String noticeType;

}
