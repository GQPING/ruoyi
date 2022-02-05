package com.ruoyi.local.domain.query;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 查询参数
 * 年度账单对象 jz_bill_year
 *
 * @author cxw
 * @date 2022/2/6
 */
public class QueryBillYear extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 账单年份 */
    private String year;

    /** 账单类型 */
    private String type;

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
}
