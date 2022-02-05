package com.ruoyi.local.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 日度账单对象 jz_bill_day
 * 
 * @author local
 * @date 2022-02-05
 */
public class BillDay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 账单日期，yyyy-MM-dd */
    @Excel(name = "账单日期，yyyy-MM-dd")
    private String date;

    /** 账单金额，2位小数 */
    @Excel(name = "账单金额，2位小数")
    private BigDecimal money;

    /** 账单类型，01:：收入，02：支出 */
    @Excel(name = "账单类型，01:：收入，02：支出")
    private String type;

    /** 支付方式，01：微信，02：支付宝，03：银行卡，04：现金 */
    @Excel(name = "支付方式，01：微信，02：支付宝，03：银行卡，04：现金")
    private String payWay;

    /** 支付类型，01：电费，02：水费，03：房租，04：通讯费，05：蔬果费，06：电影费，07：交通费，08：早餐费，09：午餐费，10：晚餐费，11：零食费，12：衣服鞋帽，13：外卖费，14：其它杂费 */
    @Excel(name = "支付类型，01：电费，02：水费，03：房租，04：通讯费，05：蔬果费，06：电影费，07：交通费，08：早餐费，09：午餐费，10：晚餐费，11：零食费，12：衣服鞋帽，13：外卖费，14：其它杂费")
    private String payType;

    /** 账单描述 */
    @Excel(name = "账单描述")
    private String details;

    /** 所属用户 */
    @Excel(name = "所属用户")
    private String userId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

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
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("date", getDate())
            .append("money", getMoney())
            .append("type", getType())
            .append("payWay", getPayWay())
            .append("payType", getPayType())
            .append("details", getDetails())
            .append("userId", getUserId())
            .append("createdTime", getCreatedTime())
            .toString();
    }
}
