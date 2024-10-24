package com.ruoyi.government.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 平台接口对接模块对象 DM_PTJKDJ
 * 
 * @author ruoyi
 * @date 2024-10-24
 */
public class DmPtjkdj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Integer ID;

    /** 接口地址 */
    @Excel(name = "接口地址")
    private String URL;

    /** 请求方式 */
    @Excel(name = "请求方式")
    private String requestMethod;

    /** 参数说明 */
    @Excel(name = "参数说明")
    private String PARAMETERS;

    /** 返回示例 */
    @Excel(name = "返回示例")
    private String expectedResponse;

    /** 同步状态 */
    @Excel(name = "同步状态")
    private String syncStatus;

    /** 接口类型 */
    @Excel(name = "接口类型")
    private String interfaceType;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer deleteMark;

    public void setID(Integer ID) 
    {
        this.ID = ID;
    }

    public Integer getID() 
    {
        return ID;
    }
    public void setURL(String URL) 
    {
        this.URL = URL;
    }

    public String getURL() 
    {
        return URL;
    }
    public void setRequestMethod(String requestMethod) 
    {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod() 
    {
        return requestMethod;
    }
    public void setPARAMETERS(String PARAMETERS) 
    {
        this.PARAMETERS = PARAMETERS;
    }

    public String getPARAMETERS() 
    {
        return PARAMETERS;
    }
    public void setExpectedResponse(String expectedResponse) 
    {
        this.expectedResponse = expectedResponse;
    }

    public String getExpectedResponse() 
    {
        return expectedResponse;
    }
    public void setSyncStatus(String syncStatus) 
    {
        this.syncStatus = syncStatus;
    }

    public String getSyncStatus() 
    {
        return syncStatus;
    }
    public void setInterfaceType(String interfaceType) 
    {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceType() 
    {
        return interfaceType;
    }
    public void setDeleteMark(Integer deleteMark) 
    {
        this.deleteMark = deleteMark;
    }

    public Integer getDeleteMark() 
    {
        return deleteMark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("URL", getURL())
            .append("requestMethod", getRequestMethod())
            .append("PARAMETERS", getPARAMETERS())
            .append("expectedResponse", getExpectedResponse())
            .append("syncStatus", getSyncStatus())
            .append("interfaceType", getInterfaceType())
            .append("deleteMark", getDeleteMark())
            .toString();
    }
}
