package com.yuanch.common.web.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuanch.common.annotation.Excel;
import com.yuanch.common.web.domain.BaseEntity;

import java.util.Date;

/**
 * 系统访问记录表 sys_logininfor
 * 
 * @author sj
 */
public class SysLogininfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "序号", cellType = Excel.ColumnType.NUMERIC)
    private Long id;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;

    /** 登录状态 0成功 1失败 */
    @Excel(name = "登录状态", readConverterExp = "0=成功,1=失败")
    private String status;

    /** 人员类型 */
    @Excel(name = "人员类型")
    private String personType;

    /** 渠道 */
    @Excel(name = "渠道")
    private String platform;

    /** 提示消息 */
    @Excel(name = "提示消息")
    private String msg;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }
}
