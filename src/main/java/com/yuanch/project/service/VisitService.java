package com.yuanch.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.entity.SuspectInfo;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.vo.VisitVO;

import java.util.List;

public interface VisitService extends IService<VisitInfo> {
    List<VisitVO> getVisitList(VisitSearchDTO visitSearchDTO);
}
