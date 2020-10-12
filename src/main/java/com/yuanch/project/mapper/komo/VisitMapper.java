package com.yuanch.project.mapper.komo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanch.project.dto.VisitSearchDTO;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.vo.VisitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VisitMapper extends BaseMapper<VisitInfo> {

    List<VisitVO> getVisitList(@Param("param") VisitSearchDTO visitSearchDTO);
}
