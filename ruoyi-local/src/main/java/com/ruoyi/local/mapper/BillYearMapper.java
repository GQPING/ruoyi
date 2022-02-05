package com.ruoyi.local.mapper;

import java.util.List;
import com.ruoyi.local.domain.BillYear;
import com.ruoyi.local.domain.query.QueryBillYear;
import com.ruoyi.local.domain.viewObject.BillYearVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 年度账单Mapper接口
 * 
 * @author local
 * @date 2022-02-06
 */
@Mapper
public interface BillYearMapper 
{
    /**
     * 查询年度账单
     * 
     * @param id 年度账单主键
     * @return 年度账单
     */
    BillYearVO selectBillYearById(String id);

    /**
     * 查询年度账单列表
     * 
     * @param billYear 年度账单
     * @return 年度账单集合
     */
    List<BillYearVO> selectBillYearList(QueryBillYear billYear);

    /**
     * 新增年度账单
     * 
     * @param billYear 年度账单
     * @return 结果
     */
    int insertBillYear(BillYear billYear);

    /**
     * 修改年度账单
     * 
     * @param billYear 年度账单
     * @return 结果
     */
    int updateBillYear(BillYear billYear);

    /**
     * 删除年度账单
     * 
     * @param id 年度账单主键
     * @return 结果
     */
    int deleteBillYearById(String id);

    /**
     * 批量删除年度账单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBillYearByIds(String[] ids);
}
