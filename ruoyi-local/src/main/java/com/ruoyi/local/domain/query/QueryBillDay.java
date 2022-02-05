package com.ruoyi.local.domain.query;

import java.io.Serializable;
import java.util.Map;

/**
 * 查询参数
 * 日度账单对象 jz_bill_day
 *
 * @author cxw
 * @date 2022/2/5
 */
public class QueryBillDay implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 搜索值 */
    private String text;

    /** 封装请求参数 */
    private Map<String, Object> params;

    /** 账单日期 */
    private String date;

    /** 账单类型 */
    private String type;

    /** 支付方式 */
    private String payWay;

    /** 支付类型 */
    private String payType;

    /** 所属用户 */
    private String userId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
