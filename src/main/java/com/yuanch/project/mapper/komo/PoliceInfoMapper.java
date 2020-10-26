package com.yuanch.project.mapper.komo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanch.project.dto.PoliceSearchDTO;
import com.yuanch.project.entity.PoliceInfo;
import com.yuanch.project.vo.PoliceInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PoliceInfoMapper extends BaseMapper<PoliceInfo> {
    List<PoliceInfoVO> getPoliceList(@Param("param") PoliceSearchDTO policeSearchDTO);
}
