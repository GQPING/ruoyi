package com.ruoyi.local.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.local.domain.query.QueryBillMonth;
import com.ruoyi.local.domain.viewObject.BillMonthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.local.mapper.BillMonthMapper;
import com.ruoyi.local.domain.BillMonth;
import com.ruoyi.local.service.IBillMonthService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 月度账单Service业务层处理
 * 
 * @author local
 * @date 2022-02-06
 */
@Service
public class BillMonthServiceImpl implements IBillMonthService 
{
    @Autowired
    private BillMonthMapper billMonthMapper;

    /**
     * 查询月度账单
     * 
     * @param id 月度账单主键
     * @return 月度账单
     */
    @Override
    public BillMonthVO selectBillMonthById(String id)
    {
        return billMonthMapper.selectBillMonthById(id);
    }

    /**
     * 查询月度账单列表
     * 
     * @param billMonth 月度账单
     * @return 月度账单
     */
    @Override
    @DataScope(deptAlias = "m", userAlias = "m")
    public List<BillMonthVO> selectBillMonthList(QueryBillMonth billMonth)
    {
        return billMonthMapper.selectBillMonthList(billMonth);
    }

    /**
     * 新增月度账单
     * 
     * @param billMonth 月度账单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBillMonth(BillMonth billMonth)
    {
        String uuid = IdUtils.fastSimpleUUID();
        billMonth.setId(uuid);
        return billMonthMapper.insertBillMonth(billMonth);
    }

    /**
     * 修改月度账单
     * 
     * @param billMonth 月度账单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBillMonth(BillMonth billMonth)
    {
        return billMonthMapper.updateBillMonth(billMonth);
    }

    /**
     * 批量删除月度账单
     * 
     * @param ids 需要删除的月度账单主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBillMonthByIds(String[] ids)
    {
        return billMonthMapper.deleteBillMonthByIds(ids);
    }

    /**
     * 删除月度账单信息
     * 
     * @param id 月度账单主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBillMonthById(String id)
    {
        return billMonthMapper.deleteBillMonthById(id);
    }
}
