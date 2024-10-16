package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * @author liangyanmei
 * @Title: 文件信息表
 * @Description:
 * @date 2024/10/16 14:20
 */
@Data
@TableName(value = "sys_file_info")
public class SysFileInfo extends BaseEntity {

    private static final  long serialVersionUID = 1L;

    /** 文件id*/
    private String fileId;
    /** 文件名称*/
    private String fileName;
    /** 文件路径*/
    private String filePath;
    /** 文件后缀*/
    private String fileSuffix;
    /** 原文件名称*/
    private String originalFileName;

    public SysFileInfo() {
    }

    public SysFileInfo(String fileId, String fileName, String filePath, String fileSuffix, String originalFileName) {
        super();
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSuffix = fileSuffix;
        this.originalFileName = originalFileName;
    }
}
