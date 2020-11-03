package com.yuanch.project.service;

import com.yuanch.project.dto.FaceCheckDTO;
import com.yuanch.project.dto.FaceCheckRunningDTO;
import com.yuanch.project.dto.VisitDTO;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.vo.FaceVO;
import com.yuanch.project.vo.VisitDropDown;
import com.yuanch.project.vo.VisitVO;

import java.util.List;

public interface VisitService  {
    List<VisitVO> getVisitList(VisitSearchDTO visitSearchDTO);

    void deleteVisit(Long id);

    void addVisits(List<VisitDTO> visitDTOS);

    VisitDropDown getVisitDropdown();

    FaceCheckDTO faceCheck(FaceVO faceVO);

    FaceCheckRunningDTO faceCheckWithRunning(FaceVO faceVO);
}
