package com.yuanch.project.controller;

import com.yuanch.common.annotation.Log;
import com.yuanch.common.enums.BusinessType;
import com.yuanch.common.web.controller.BaseController;
import com.yuanch.common.web.domain.AjaxResult;
import com.yuanch.common.web.domain.page.TableDataInfo;
import com.yuanch.project.dto.PoliceDTO;
import com.yuanch.project.dto.PoliceSearchDTO;
import com.yuanch.project.service.PoliceInfoService;
import com.yuanch.project.vo.PoliceDropDown;
import com.yuanch.project.vo.PoliceInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/police")
@Api("警员管理")
public class PoliceInfoController extends BaseController {

    @Autowired
    private PoliceInfoService policeInfoService;

    @ApiOperation(value = "查询警员列表")
    @PostMapping("getPoliceList")
    public TableDataInfo getPoliceList(@RequestBody PoliceSearchDTO policeSearchDTO)
    {
        startPage();
        List<PoliceInfoVO> polices = policeInfoService.getPoliceList(policeSearchDTO);
        return getDataTable(polices);
    }

    @ApiOperation(value = "新增警员")
    @PostMapping("addPoliceInfo")
    public AjaxResult addPoliceInfo(@RequestBody @Validated PoliceDTO policeDTO)
    {
        policeInfoService.addPoliceInfo(policeDTO);
        return AjaxResult.success("添加成功");
    }


    @ApiOperation(value = "更新警员")
    @PostMapping("updatePoliceInfo")
    public AjaxResult updatePoliceInfo(@RequestBody @Validated PoliceDTO policeDTO)
    {
        policeInfoService.updatePoliceInfo(policeDTO);
        return AjaxResult.success("编辑成功");
    }


    @ApiOperation(value = "删除警员")
    @DeleteMapping("deletePoliceInfo")
    public AjaxResult deletePoliceInfo(@RequestParam List<Long> ids)
    {
        policeInfoService.deletePoliceInfo(ids);
        return AjaxResult.success("删除成功");
    }


    @ApiOperation(value = "获取单位下拉框")
    @GetMapping("getUnitDropdown")
    public AjaxResult getUnitDropdown()
    {
        PoliceDropDown policeDropDown = policeInfoService.getUnitDropdown();
        return AjaxResult.success(policeDropDown);
    }


}
