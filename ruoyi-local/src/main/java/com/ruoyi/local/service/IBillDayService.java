package com.ruoyi.local.service;

import java.util.List;
import com.ruoyi.local.domain.BillDay;
import com.ruoyi.local.domain.query.QueryBillDay;
import com.ruoyi.local.domain.viewObject.BillDayVO;

/**
 * 日度账单Service接口
 * 
 * @author local
 * @date 2022-02-05
 */
public interface IBillDayService 
{
    /**
     * 查询日度账单
     * 
     * @param id 日度账单主键
     * @return 日度账单
     */
    BillDayVO selectBillDayById(String id);

    /**
     * 查询日度账单列表
     * 
     * @param billDay 日度账单
     * @return 日度账单集合
     */
    List<BillDayVO> selectBillDayList(QueryBillDay billDay);

    /**
     * 新增日度账单
     * 
     * @param billDay 日度账单
     * @return 结果
     */
    int insertBillDay(BillDay billDay);

    /**
     * 修改日度账单
     * 
     * @param billDay 日度账单
     * @return 结果
     */
    int updateBillDay(BillDay billDay);

    /**
     * 批量删除日度账单
     * 
     * @param ids 需要删除的日度账单主键集合
     * @return 结果
     */
    int deleteBillDayByIds(String[] ids);

    /**
     * 删除日度账单信息
     * 
     * @param id 日度账单主键
     * @return 结果
     */
    int deleteBillDayById(String id);

    /**
     * 月度年度定时任务
     *
     * @param date 时间字符串
     * @param yearOrMonth 按照年份还是月份
     * @return 结果
     */
    void autoJobExecute(String date, String yearOrMonth);
}
