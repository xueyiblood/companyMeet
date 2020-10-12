package com.yuanch.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanch.project.dto.SuspectSearchDTO;
import com.yuanch.project.entity.SuspectInfo;
import com.yuanch.project.vo.SuspectVO;

import java.util.List;

public interface SuspectService extends IService<SuspectInfo> {

    List<SuspectVO> getSuspectList(SuspectSearchDTO suspectSearchDTO);
}
