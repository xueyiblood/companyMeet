package com.yuanch.project.controller;

import com.yuanch.common.web.controller.BaseController;
import com.yuanch.common.web.domain.page.TableDataInfo;
import com.yuanch.project.dto.SuspectSearchDTO;
import com.yuanch.project.service.SuspectService;
import com.yuanch.project.vo.SuspectVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("嫌疑人控制器")
public class SuspectController extends BaseController {


    @Autowired
    private SuspectService suspectService;

    /**
     * 条件查询嫌疑人
     */

    @ApiOperation(value = "条件查询嫌疑人")
    @PostMapping("getSuspectList")
    public TableDataInfo getSuspectList(@RequestBody SuspectSearchDTO suspectSearchDTO) {
        startPage();
        List<SuspectVO> suspectVOS = suspectService.getSuspectList(suspectSearchDTO);
        return getDataTable(suspectVOS);
    }





}
