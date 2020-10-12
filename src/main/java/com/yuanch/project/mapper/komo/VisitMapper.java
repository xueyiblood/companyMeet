package com.yuanch.project.mapper.komo;

import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.vo.VisitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VisitMapper {

    List<VisitVO> getVisitList(@Param("param") VisitSearchDTO visitSearchDTO);

    void deleteVisit(@Param("id") Long id);
}
