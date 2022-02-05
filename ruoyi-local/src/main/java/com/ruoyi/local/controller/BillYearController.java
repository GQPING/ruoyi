package com.ruoyi.local.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.local.domain.query.QueryBillYear;
import com.ruoyi.local.domain.viewObject.BillYearVO;
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
import com.ruoyi.local.domain.BillYear;
import com.ruoyi.local.service.IBillYearService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 年度账单Controller
 * 
 * @author local
 * @date 2022-02-06
 */
@RestController
@RequestMapping("/local/year")
public class BillYearController extends BaseController
{
    @Autowired
    private IBillYearService billYearService;

    /**
     * 查询年度账单列表
     */
    @PreAuthorize("@ss.hasPermi('local:year:list')")
    @GetMapping("/list")
    public TableDataInfo list(QueryBillYear billYear)
    {
        startPage();
        List<BillYearVO> list = billYearService.selectBillYearList(billYear);
        return getDataTable(list);
    }

    /**
     * 导出年度账单列表
     */
    @PreAuthorize("@ss.hasPermi('local:year:export')")
    @Log(title = "年度账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QueryBillYear billYear)
    {
        List<BillYearVO> list = billYearService.selectBillYearList(billYear);
        ExcelUtil<BillYearVO> util = new ExcelUtil<>(BillYearVO.class);
        util.exportExcel(response, list, "年度账单数据");
    }

    /**
     * 获取年度账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('local:year:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(billYearService.selectBillYearById(id));
    }

    /**
     * 新增年度账单
     */
    @PreAuthorize("@ss.hasPermi('local:year:add')")
    @Log(title = "年度账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BillYear billYear)
    {
        return toAjax(billYearService.insertBillYear(billYear));
    }

    /**
     * 修改年度账单
     */
    @PreAuthorize("@ss.hasPermi('local:year:edit')")
    @Log(title = "年度账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BillYear billYear)
    {
        return toAjax(billYearService.updateBillYear(billYear));
    }

    /**
     * 删除年度账单
     */
    @PreAuthorize("@ss.hasPermi('local:year:remove')")
    @Log(title = "年度账单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(billYearService.deleteBillYearByIds(ids));
    }
}
