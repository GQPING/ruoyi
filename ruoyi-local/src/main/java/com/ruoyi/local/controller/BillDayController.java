package com.ruoyi.local.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.EscapeUtils;
import com.ruoyi.local.domain.query.QueryBillDay;
import com.ruoyi.local.domain.viewObject.BillDayVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.local.domain.BillDay;
import com.ruoyi.local.service.IBillDayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 日度账单Controller
 * 
 * @author local
 * @date 2022-02-05
 */
@RestController
@RequestMapping("/local/day")
public class BillDayController extends BaseController
{
    @Autowired
    private IBillDayService billDayService;

    /**
     * 查询日度账单列表
     */
    @PreAuthorize("@ss.hasPermi('local:day:list')")
    @GetMapping("/list")
    public TableDataInfo list(QueryBillDay billDay)
    {
        startPage();
        billDay.setText(EscapeUtils.escapeCheck(billDay.getText()));
        List<BillDayVO> list = billDayService.selectBillDayList(billDay);
        return getDataTable(list);
    }

    /**
     * 导出日度账单列表
     */
    @PreAuthorize("@ss.hasPermi('local:day:export')")
    @Log(title = "日度账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QueryBillDay billDay)
    {
        billDay.setText(EscapeUtils.escapeCheck(billDay.getText()));
        List<BillDayVO> list = billDayService.selectBillDayList(billDay);
        ExcelUtil<BillDayVO> util = new ExcelUtil<>(BillDayVO.class);
        util.exportExcel(response, list, "日度账单数据");
    }

    /**
     * 获取日度账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('local:day:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(billDayService.selectBillDayById(id));
    }

    /**
     * 新增日度账单
     */
    @PreAuthorize("@ss.hasPermi('local:day:add')")
    @Log(title = "日度账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BillDay billDay)
    {
        return toAjax(billDayService.insertBillDay(billDay));
    }

    /**
     * 修改日度账单
     */
    @PreAuthorize("@ss.hasPermi('local:day:edit')")
    @Log(title = "日度账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BillDay billDay)
    {
        return toAjax(billDayService.updateBillDay(billDay));
    }

    /**
     * 删除日度账单
     */
    @PreAuthorize("@ss.hasPermi('local:day:remove')")
    @Log(title = "日度账单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(billDayService.deleteBillDayByIds(ids));
    }
}
