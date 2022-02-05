package com.ruoyi.local.service;

import java.util.List;
import com.ruoyi.local.domain.BillDay;

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
    public BillDay selectBillDayById(String id);

    /**
     * 查询日度账单列表
     * 
     * @param billDay 日度账单
     * @return 日度账单集合
     */
    public List<BillDay> selectBillDayList(BillDay billDay);

    /**
     * 新增日度账单
     * 
     * @param billDay 日度账单
     * @return 结果
     */
    public int insertBillDay(BillDay billDay);

    /**
     * 修改日度账单
     * 
     * @param billDay 日度账单
     * @return 结果
     */
    public int updateBillDay(BillDay billDay);

    /**
     * 批量删除日度账单
     * 
     * @param ids 需要删除的日度账单主键集合
     * @return 结果
     */
    public int deleteBillDayByIds(String[] ids);

    /**
     * 删除日度账单信息
     * 
     * @param id 日度账单主键
     * @return 结果
     */
    public int deleteBillDayById(String id);
}
