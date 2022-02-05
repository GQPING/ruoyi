package com.ruoyi.local.domain.query;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 查询参数
 * 月度账单对象 jz_bill_month
 *
 * @author cxw
 * @date 2022/2/6
 */
public class QueryBillMonth extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 账单月份 */
    private String month;

    /** 账单类型 */
    private String type;

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
}
