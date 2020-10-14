package com.yuanch.project.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.yuanch.common.enums.RelationEnum;
import com.yuanch.project.dto.VisitDTO;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.mapper.komo.VisitMapper;
import com.yuanch.project.service.VisitService;
import com.yuanch.project.vo.VisitDropDown;
import com.yuanch.project.vo.VisitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

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

        if (CollectionUtil.isNotEmpty(visitDTOS)){
            for (VisitDTO visitDTO : visitDTOS) {
                VisitInfo oldVisit = visitMapper.findByIdcardAndSuspectId(visitDTO.getIdCard(), visitDTO.getSuspectId());
                if (Objects.isNull(oldVisit)){
                    visitMapper.addVist(visitDTO);
                } else  {
                    visitMapper.updateVisit(visitDTO);
                }

            }
        }
    }

    @Override
    public VisitDropDown getVisitDropdown() {
        VisitDropDown visitDropdown = new VisitDropDown();
        visitDropdown.setRelationEnums(Arrays.asList(RelationEnum.values()));

        return visitDropdown;
    }
}
