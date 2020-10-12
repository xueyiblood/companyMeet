package com.yuanch.project.controller;

import com.yuanch.common.web.controller.BaseController;
import com.yuanch.common.web.domain.page.TableDataInfo;
import com.yuanch.project.dto.SuspectSearchDTO;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.service.VisitService;
import com.yuanch.project.vo.SuspectVO;
import com.yuanch.project.vo.VisitVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("访客控制器")
@RequestMapping("visit")
public class VisitorController  extends BaseController {

    @Autowired
    private VisitService visitService;

    /**
     * 条件查询访客
     */

    @ApiOperation(value = "条件查询访客")
    @PostMapping("getVisitList")
    public TableDataInfo getVisitList(@RequestBody @Validated VisitSearchDTO visitSearchDTO) {
        startPage();
        List<VisitVO> visitVOS = visitService.getVisitList(visitSearchDTO);
        return getDataTable(visitVOS);
    }




}
