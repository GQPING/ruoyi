package com.ruoyi.quartz.task;

import com.ruoyi.common.constant.DictConstant;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.local.service.IBillDayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时月度年度
 * @author cxw
 * @date 2022/2/6
 */
@Component("billTask")
public class BillTask
{
    private static Logger logger = LoggerFactory.getLogger(BillTask.class);

    @Autowired
    private IBillDayService billDayService;

    /**
     * 月度账单，每月1日0时0分0秒，更新上月对账情况，corn表达式： 0 0 0 1 * ?
     *
     * @author cxw
     * @date 2021/12/12
     */
    public void ryNoParamsByMonth()
    {
        //获取上一月份 yyyy-MM
        String month = DateUtils.getLastMonth(new Date(),DateUtils.YYYY_MM);
        logger.info("定时任务开始执行：【按月统计" + month + "月度账单情况】");
        billDayService.autoJobExecute(month, DictConstant.CHECKING_TYPE_01);
        logger.info("定时任务执行结束：【按月统计" + month + "月度账单情况】");
    }

    /**
     * 年度账单，每年1月1日0时0分30秒，更新上一年对账情况，corn表达式：30 0 0 1 1 ? *
     *
     * @author cxw
     * @date 2021/12/12
     */
    public void ryNoParamsByYear()
    {
        //获取上一年份 yyyy
        String year = DateUtils.getLastYear(new Date(),DateUtils.YYYY);
        logger.info("定时任务开始执行：【按年统计" + year + "年度账单情况】");
        billDayService.autoJobExecute(year, DictConstant.CHECKING_TYPE_02);
        logger.info("定时任务执行结束：【按年统计" + year + "年度账单情况】");
    }
}
