package com.ruoyi.local.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.EscapeUtils;
import com.ruoyi.local.domain.query.QueryBillMonth;
import com.ruoyi.local.domain.viewObject.BillMonthVO;
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
import com.ruoyi.local.domain.BillMonth;
import com.ruoyi.local.service.IBillMonthService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 月度账单Controller
 * 
 * @author local
 * @date 2022-02-06
 */
@RestController
@RequestMapping("/local/month")
public class BillMonthController extends BaseController
{
    @Autowired
    private IBillMonthService billMonthService;

    /**
     * 查询月度账单列表
     */
    @PreAuthorize("@ss.hasPermi('local:month:list')")
    @GetMapping("/list")
    public TableDataInfo list(QueryBillMonth billMonth)
    {
        startPage();
        List<BillMonthVO> list = billMonthService.selectBillMonthList(billMonth);
        return getDataTable(list);
    }

    /**
     * 导出月度账单列表
     */
    @PreAuthorize("@ss.hasPermi('local:month:export')")
    @Log(title = "月度账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QueryBillMonth billMonth)
    {
        List<BillMonthVO> list = billMonthService.selectBillMonthList(billMonth);
        ExcelUtil<BillMonthVO> util = new ExcelUtil<>(BillMonthVO.class);
        util.exportExcel(response, list, "月度账单数据");
    }

    /**
     * 获取月度账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('local:month:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(billMonthService.selectBillMonthById(id));
    }

    /**
     * 新增月度账单
     */
    @PreAuthorize("@ss.hasPermi('local:month:add')")
    @Log(title = "月度账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BillMonth billMonth)
    {
        return toAjax(billMonthService.insertBillMonth(billMonth));
    }

    /**
     * 修改月度账单
     */
    @PreAuthorize("@ss.hasPermi('local:month:edit')")
    @Log(title = "月度账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BillMonth billMonth)
    {
        return toAjax(billMonthService.updateBillMonth(billMonth));
    }

    /**
     * 删除月度账单
     */
    @PreAuthorize("@ss.hasPermi('local:month:remove')")
    @Log(title = "月度账单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(billMonthService.deleteBillMonthByIds(ids));
    }
}
