package com.yuanch.project.mapper.komo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanch.project.dto.VisitDTO;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.vo.VisitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VisitMapper extends BaseMapper<VisitInfo> {

    List<VisitVO> getVisitList(VisitSearchDTO visitSearchDTO);

    void deleteVisit(@Param("id") Long id);

    void addVist( VisitDTO visitDTO);

    VisitInfo findByIdcardAndSuspectId(@Param("idCard") String idCard, @Param("suspectId") Long suspectId);

    void updateVisit(VisitDTO visitDTO);
}
