package com.ruoyi.local.mapper;

import java.util.List;
import com.ruoyi.local.domain.BillMonth;
import com.ruoyi.local.domain.query.QueryBillMonth;
import com.ruoyi.local.domain.viewObject.BillMonthVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 月度账单Mapper接口
 * 
 * @author local
 * @date 2022-02-06
 */
@Mapper
public interface BillMonthMapper 
{
    /**
     * 查询月度账单
     * 
     * @param id 月度账单主键
     * @return 月度账单
     */
    BillMonthVO selectBillMonthById(String id);

    /**
     * 查询月度账单列表
     * 
     * @param billMonth 月度账单
     * @return 月度账单集合
     */
    List<BillMonthVO> selectBillMonthList(QueryBillMonth billMonth);

    /**
     * 新增月度账单
     * 
     * @param billMonth 月度账单
     * @return 结果
     */
    int insertBillMonth(BillMonth billMonth);

    /**
     * 修改月度账单
     * 
     * @param billMonth 月度账单
     * @return 结果
     */
    int updateBillMonth(BillMonth billMonth);

    /**
     * 删除月度账单
     * 
     * @param id 月度账单主键
     * @return 结果
     */
    int deleteBillMonthById(String id);

    /**
     * 批量删除月度账单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBillMonthByIds(String[] ids);
}
