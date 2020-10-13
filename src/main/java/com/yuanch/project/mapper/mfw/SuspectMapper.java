package com.yuanch.project.mapper.mfw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanch.project.dto.SuspectSearchDTO;
import com.yuanch.project.entity.SuspectInfo;
import com.yuanch.project.vo.SuspectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuspectMapper extends BaseMapper<SuspectInfo> {
    List<SuspectVO> getSuspectList(SuspectSearchDTO suspectSearchDTO);
}
