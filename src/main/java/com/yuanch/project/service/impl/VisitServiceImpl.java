package com.yuanch.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanch.project.dto.VisitDTO;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.mapper.komo.VisitMapper;
import com.yuanch.project.service.VisitService;
import com.yuanch.project.vo.VisitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VisitServiceImpl  extends ServiceImpl<VisitMapper, VisitInfo> implements VisitService {

    @Autowired
    private VisitMapper visitMapper;

    @Override
    public List<VisitVO> getVisitList(VisitSearchDTO visitSearchDTO) {
        return visitMapper.getVisitList(visitSearchDTO);
    }

    @Override
    public void deleteVisit(Long id) {
        visitMapper.deleteVisit(id);
    }

    @Override
    public void addVisits(List<VisitDTO> visitDTOS) {
        List<VisitInfo> visits = new ArrayList<>();
        
        if (CollectionUtil.isNotEmpty(visitDTOS)){
            for (VisitDTO visitDTO : visitDTOS) {
                VisitInfo visitInfo = new VisitInfo();
                BeanUtil.copyProperties(visitDTO, visitInfo);
                visitInfo.setDeleteStatus(0);
                visits.add(visitInfo);
            }
        }

        this.saveBatch(visits);

    }
}
