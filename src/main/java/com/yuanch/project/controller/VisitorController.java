package com.yuanch.project.controller;

import com.yuanch.common.web.controller.BaseController;
import com.yuanch.common.web.domain.AjaxResult;
import com.yuanch.common.web.domain.page.TableDataInfo;
import com.yuanch.project.dto.FaceCheckDTO;
import com.yuanch.project.dto.FaceCheckRunningDTO;
import com.yuanch.project.dto.VisitDTO;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.service.VisitService;
import com.yuanch.project.vo.FaceVO;
import com.yuanch.project.vo.FindFaceVO;
import com.yuanch.project.vo.VisitDropDown;
import com.yuanch.project.vo.VisitVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "删除访客")
    @GetMapping("deleteVisit")
    public AjaxResult deleteVisit(@RequestParam Long id) {
        visitService.deleteVisit(id);
        return AjaxResult.success("删除成功");
    }

    @ApiOperation(value = "保存访客")
    @PostMapping("addVisits")
    public AjaxResult addVisits(@RequestBody @Validated List<VisitDTO> visitDTOS) {
        visitService.addVisits(visitDTOS);
        return AjaxResult.success("添加成功");
    }

    @ApiOperation(value = "获取下拉框")
    @GetMapping("getVisitDropdown")
    public AjaxResult getVisitDropdown() {
        VisitDropDown drop =  visitService.getVisitDropdown();
        return AjaxResult.success(drop);
    }

    @ApiOperation(value = "人脸比对")
    @PostMapping("faceCheck")
    public AjaxResult faceCheck(@RequestBody FaceVO faceVO) {
        FaceCheckDTO faceCheck =  visitService.faceCheck(faceVO);
        return AjaxResult.success(faceCheck);
    }

    @ApiOperation(value = "在逃人脸比对")
    @PostMapping("faceCheckWithRunning")
    public AjaxResult faceCheckWithRunning(@RequestBody FaceVO faceVO) {
        FindFaceVO faces =  visitService.faceCheckWithRunning(faceVO);
        return AjaxResult.success(faces);
    }

    @ApiOperation(value = "取人脸图片")
    @GetMapping("getPicture")
    public AjaxResult getPicture(@RequestParam String url, @RequestParam String sessionId ) {
        HttpEntity entity =  visitService.getPicture(url, sessionId);
        return AjaxResult.success(entity);
    }

}
