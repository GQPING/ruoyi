package com.ruoyi.local.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.local.domain.query.QueryBillDay;
import com.ruoyi.local.domain.viewObject.BillDayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.local.mapper.BillDayMapper;
import com.ruoyi.local.domain.BillDay;
import com.ruoyi.local.service.IBillDayService;

/**
 * 日度账单Service业务层处理
 * 
 * @author local
 * @date 2022-02-05
 */
@Service
public class BillDayServiceImpl implements IBillDayService 
{
    @Autowired
    private BillDayMapper billDayMapper;

    /**
     * 查询日度账单
     * 
     * @param id 日度账单主键
     * @return 日度账单
     */
    @Override
    public BillDayVO selectBillDayById(String id)
    {
        return billDayMapper.selectBillDayById(id);
    }

    /**
     * 查询日度账单列表
     * 
     * @param billDay 日度账单
     * @return 日度账单
     */
    @Override
    public List<BillDayVO> selectBillDayList(QueryBillDay billDay)
    {
        return billDayMapper.selectBillDayList(billDay);
    }

    /**
     * 新增日度账单
     * 
     * @param billDay 日度账单
     * @return 结果
     */
    @Override
    public int insertBillDay(BillDay billDay)
    {
        String uuid = IdUtils.fastSimpleUUID();
        billDay.setId(uuid);
        Date nowDate = DateUtils.getNowDate();
        billDay.setCreateTime(nowDate);
        return billDayMapper.insertBillDay(billDay);
    }

    /**
     * 修改日度账单
     * 
     * @param billDay 日度账单
     * @return 结果
     */
    @Override
    public int updateBillDay(BillDay billDay)
    {
        return billDayMapper.updateBillDay(billDay);
    }

    /**
     * 批量删除日度账单
     * 
     * @param ids 需要删除的日度账单主键
     * @return 结果
     */
    @Override
    public int deleteBillDayByIds(String[] ids)
    {
        return billDayMapper.deleteBillDayByIds(ids);
    }

    /**
     * 删除日度账单信息
     * 
     * @param id 日度账单主键
     * @return 结果
     */
    @Override
    public int deleteBillDayById(String id)
    {
        return billDayMapper.deleteBillDayById(id);
    }
}
