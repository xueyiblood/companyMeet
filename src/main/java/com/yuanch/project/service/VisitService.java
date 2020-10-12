package com.yuanch.project.service;

import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.vo.VisitVO;

import java.util.List;

public interface VisitService  {
    List<VisitVO> getVisitList(VisitSearchDTO visitSearchDTO);

    void deleteVisit(Long id);
}
