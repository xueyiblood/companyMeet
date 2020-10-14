package com.yuanch.project.mapper.komo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yuanch.project.entity.UnitInfo;
import com.yuanch.project.vo.UnitInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/5 0005 17:47
 */
@Mapper
public interface UnitInfoMapper extends BaseMapper<UnitInfo> {
    int checkExist(@Param("unitNo") String unitNo);

    List<UnitInfoVo> getUnitList(@Param("unitName")String unitName, @Param("unitNo")String unitNo);
}
