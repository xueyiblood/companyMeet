package com.yuanch.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanch.project.dto.PoliceDTO;
import com.yuanch.project.dto.PoliceSearchDTO;
import com.yuanch.project.entity.PoliceInfo;
import com.yuanch.project.vo.PoliceInfoVO;

import java.util.List;

public interface PoliceInfoService extends IService<PoliceInfo> {
    List<PoliceInfoVO> getPoliceList(PoliceSearchDTO policeSearchDTO);

    void addPoliceInfo(PoliceDTO policeDTO);

    void updatePoliceInfo(PoliceDTO policeDTO);

    void deletePoliceInfo(List<Long> ids);
}
