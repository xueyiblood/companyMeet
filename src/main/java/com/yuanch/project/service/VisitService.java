package com.yuanch.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanch.project.dto.VisitDTO;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.vo.VisitVO;

import java.util.List;

public interface VisitService  {
    List<VisitVO> getVisitList(VisitSearchDTO visitSearchDTO);

    void deleteVisit(Long id);

    void addVisits(List<VisitDTO> visitDTOS);
}
