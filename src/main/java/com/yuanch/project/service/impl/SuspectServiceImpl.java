package com.yuanch.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanch.project.dto.SuspectSearchDTO;
import com.yuanch.project.entity.SuspectInfo;
import com.yuanch.project.mapper.mfw.SuspectMapper;
import com.yuanch.project.service.SuspectService;
import com.yuanch.project.vo.SuspectVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuspectServiceImpl extends ServiceImpl<SuspectMapper, SuspectInfo> implements SuspectService {
    @Override
    public List<SuspectVO> getSuspectList(SuspectSearchDTO suspectSearchDTO) {
        return null;
    }
}
