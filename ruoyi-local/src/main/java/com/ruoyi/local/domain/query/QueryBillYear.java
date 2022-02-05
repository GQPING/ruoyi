package com.ruoyi.local.domain.query;

import java.io.Serializable;
import java.util.Map;

/**
 * 查询参数
 * 年度账单对象 jz_bill_year
 *
 * @author cxw
 * @date 2022/2/6
 */
public class QueryBillYear implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 封装请求参数 */
    private Map<String, Object> params;

    /** 账单年份 */
    private String year;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
