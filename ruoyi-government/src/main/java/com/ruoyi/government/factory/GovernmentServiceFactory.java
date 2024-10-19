package com.ruoyi.government.factory;


import com.ruoyi.government.service.IGovernmentDeclareService;
import com.ruoyi.government.service.IGovernmentInquiryService;
import com.ruoyi.government.service.IGovernmentRecordService;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Getter
public class GovernmentServiceFactory {

    @Resource
    protected IGovernmentInquiryService governmentInquiryService;

    @Resource
    protected IGovernmentDeclareService governmentDeclareService;

    @Resource
    protected IGovernmentRecordService governmentRecordService;
}
