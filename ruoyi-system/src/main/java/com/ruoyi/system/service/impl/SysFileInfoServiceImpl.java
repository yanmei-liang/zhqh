package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysFileInfo;
import com.ruoyi.system.mapper.SysFileInfoMapper;
import com.ruoyi.system.service.SysFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author liangyanmei
 * @Title: 文件信息表
 * @Description:
 * @date 2024/10/1614:50
 */
@Service
public class SysFileInfoServiceImpl implements SysFileInfoService {

    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    @Override
    public int saveFileInfo(SysFileInfo vo) {
        return sysFileInfoMapper.insertVo(vo);
    }

}
