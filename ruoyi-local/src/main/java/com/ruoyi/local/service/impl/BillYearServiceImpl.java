package com.ruoyi.local.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.local.domain.query.QueryBillYear;
import com.ruoyi.local.domain.viewObject.BillYearVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.local.mapper.BillYearMapper;
import com.ruoyi.local.domain.BillYear;
import com.ruoyi.local.service.IBillYearService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 年度账单Service业务层处理
 * 
 * @author local
 * @date 2022-02-06
 */
@Service
public class BillYearServiceImpl implements IBillYearService 
{
    @Autowired
    private BillYearMapper billYearMapper;

    /**
     * 查询年度账单
     * 
     * @param id 年度账单主键
     * @return 年度账单
     */
    @Override
    public BillYearVO selectBillYearById(String id)
    {
        return billYearMapper.selectBillYearById(id);
    }

    /**
     * 查询年度账单列表
     * 
     * @param billYear 年度账单
     * @return 年度账单
     */
    @Override
    @DataScope(deptAlias = "y", userAlias = "y")
    public List<BillYearVO> selectBillYearList(QueryBillYear billYear)
    {
        return billYearMapper.selectBillYearList(billYear);
    }

    /**
     * 新增年度账单
     * 
     * @param billYear 年度账单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBillYear(BillYear billYear)
    {
        String uuid = IdUtils.fastSimpleUUID();
        billYear.setId(uuid);
        return billYearMapper.insertBillYear(billYear);
    }

    /**
     * 修改年度账单
     * 
     * @param billYear 年度账单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBillYear(BillYear billYear)
    {
        return billYearMapper.updateBillYear(billYear);
    }

    /**
     * 批量删除年度账单
     * 
     * @param ids 需要删除的年度账单主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBillYearByIds(String[] ids)
    {
        return billYearMapper.deleteBillYearByIds(ids);
    }

    /**
     * 删除年度账单信息
     * 
     * @param id 年度账单主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBillYearById(String id)
    {
        return billYearMapper.deleteBillYearById(id);
    }
}
