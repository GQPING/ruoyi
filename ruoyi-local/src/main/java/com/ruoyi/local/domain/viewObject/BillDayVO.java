package com.ruoyi.local.domain.viewObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 日度账单对象 jz_bill_day
 *
 * @author cxw
 * @date 2022/2/5
 */
public class BillDayVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 账单日期 */
    @Excel(name = "账单日期")
    private String date;

    /** 账单金额 */
    @Excel(name = "账单金额")
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private BigDecimal money;

    /** 账单类型 */
    @Excel(name = "账单类型")
    private String type;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String payWay;

    /** 支付类型 */
    @Excel(name = "支付类型")
    private String payType;

    /** 账单描述 */
    @Excel(name = "账单描述")
    private String details;

    /** 所属用户 */
    private Long userId;

    /** 所属用户 */
    @Excel(name = "所属用户")
    private String userName;

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
    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDate()
    {
        return date;
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
    public void setPayWay(String payWay)
    {
        this.payWay = payWay;
    }

    public String getPayWay()
    {
        return payWay;
    }
    public void setPayType(String payType)
    {
        this.payType = payType;
    }

    public String getPayType()
    {
        return payType;
    }
    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getDetails()
    {
        return details;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("date", getDate())
                .append("money", getMoney())
                .append("type", getType())
                .append("payWay", getPayWay())
                .append("payType", getPayType())
                .append("details", getDetails())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("createTime", getCreateTime())
                .toString();
    }
}
