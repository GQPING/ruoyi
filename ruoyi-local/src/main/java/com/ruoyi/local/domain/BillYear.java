package com.ruoyi.local.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 年度账单对象 jz_bill_year
 * 
 * @author local
 * @date 2022-02-06
 */
public class BillYear extends BaseEntity
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
    private Long userId;

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
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("money", getMoney())
            .append("type", getType())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
