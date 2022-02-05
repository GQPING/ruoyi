package com.ruoyi.local.domain.query;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 查询参数
 * 日度账单对象 jz_bill_day
 *
 * @author cxw
 * @date 2022/2/5
 */
public class QueryBillDay extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 搜索值 */
    private String text;

    /** 账单日期 */
    private String date;

    /** 账单类型 */
    private String type;

    /** 支付方式 */
    private String payWay;

    /** 支付类型 */
    private String payType;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
