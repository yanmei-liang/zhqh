package com.ruoyi.government.service;

import com.ruoyi.common.core.domain.AjaxResult;

public interface GFlowableService {

    public AjaxResult flowTaskStartInquiry(String toponym);

    public AjaxResult flowTaskStartRecord(String toponym);

    public AjaxResult flowTaskStartDeclare(String toponym);
}
