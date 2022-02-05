package com.ruoyi.local.service.impl;

import java.util.List;

import com.ruoyi.common.constant.DictConstant;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.local.domain.BillMonth;
import com.ruoyi.local.domain.BillYear;
import com.ruoyi.local.domain.query.QueryBillDay;
import com.ruoyi.local.domain.viewObject.BillDayVO;
import com.ruoyi.local.service.IBillMonthService;
import com.ruoyi.local.service.IBillYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.local.mapper.BillDayMapper;
import com.ruoyi.local.domain.BillDay;
import com.ruoyi.local.service.IBillDayService;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private IBillMonthService billMonthService;

    @Autowired
    private IBillYearService billYearService;

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
    @Transactional(rollbackFor = Exception.class)
    public int insertBillDay(BillDay billDay)
    {
        String uuid = IdUtils.fastSimpleUUID();
        billDay.setId(uuid);
        String userName = SecurityUtils.getUsername();
        billDay.setUserId(userName);
        return billDayMapper.insertBillDay(billDay);
    }

    /**
     * 修改日度账单
     * 
     * @param billDay 日度账单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public int deleteBillDayById(String id)
    {
        return billDayMapper.deleteBillDayById(id);
    }

    /**
     * 月度年度定时任务
     *
     * @param date 时间字符串
     * @param yearOrMonth 按照年份还是月份
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void autoJobExecute(String date, String yearOrMonth) {
        List<BillDay> list = billDayMapper.autoJobExecute(date, yearOrMonth);
        if (list != null && !list.isEmpty()) {
            if (DictConstant.CHECKING_TYPE_01.equals(yearOrMonth)) {
                for(BillDay day : list){
                    BillMonth billMonth = new BillMonth();
                    billMonth.setMonth(date);
                    billMonth.setUserId(day.getUserId());
                    billMonth.setType(day.getType());
                    billMonth.setMoney(day.getMoney());
                    billMonthService.insertBillMonth(billMonth);
                }
            } else if (DictConstant.CHECKING_TYPE_02.equals(yearOrMonth)) {
                for(BillDay day : list){
                    BillYear billYear = new BillYear();
                    billYear.setYear(date);
                    billYear.setUserId(day.getUserId());
                    billYear.setType(day.getType());
                    billYear.setMoney(day.getMoney());
                    billYearService.insertBillYear(billYear);
                }
            }
        }
    }
}
