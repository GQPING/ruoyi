package com.ruoyi.local.domain.query;

import java.io.Serializable;
import java.util.Map;

/**
 * 查询参数
 * 月度账单对象 jz_bill_month
 *
 * @author cxw
 * @date 2022/2/6
 */
public class QueryBillMonth implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 封装请求参数 */
    private Map<String, Object> params;

    /** 账单月份 */
    private String month;

    /** 账单类型 */
    private String type;

    /** 所属用户 */
    private String userId;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
