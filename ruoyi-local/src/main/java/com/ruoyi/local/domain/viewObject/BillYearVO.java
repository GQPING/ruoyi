package com.ruoyi.local.domain.viewObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 年度账单对象 jz_bill_year
 *
 * @author cxw
 * @date 2022/2/6
 */
public class BillYearVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 账单年份 */
    @Excel(name = "账单年份")
    private String year;

    /** 账单金额 */
    @Excel(name = "账单金额")
    private BigDecimal money;

    /** 账单类型 */
    @Excel(name = "账单类型")
    private String type;

    /** 所属用户 */
    @Excel(name = "所属用户")
    private String userId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setYear(String year)
    {
        this.year = year;
    }

    public String getYear()
    {
        return year;
    }
    public void setMoney(BigDecimal money)
    {
        this.money = money;
    }

    public BigDecimal getMoney()
    {
        return money;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("year", getYear())
                .append("money", getMoney())
                .append("type", getType())
                .append("userId", getUserId())
                .append("createTime", getCreateTime())
                .toString();
    }
}
