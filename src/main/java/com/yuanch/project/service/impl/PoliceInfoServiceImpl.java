package com.yuanch.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanch.common.utils.SecurityUtils;
import com.yuanch.project.dto.PoliceDTO;
import com.yuanch.project.dto.PoliceSearchDTO;
import com.yuanch.project.entity.PoliceInfo;
import com.yuanch.project.mapper.komo.PoliceInfoMapper;
import com.yuanch.project.mapper.komo.UnitInfoMapper;
import com.yuanch.project.service.PoliceInfoService;
import com.yuanch.project.vo.PoliceDropDown;
import com.yuanch.project.vo.PoliceInfoVO;
import com.yuanch.project.vo.UnitInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PoliceInfoServiceImpl extends ServiceImpl<PoliceInfoMapper, PoliceInfo> implements PoliceInfoService {

    @Autowired
    private PoliceInfoMapper policeInfoMapper;
    @Autowired
    private UnitInfoMapper unitInfoMapper;

    @Override
    public List<PoliceInfoVO> getPoliceList(PoliceSearchDTO policeSearchDTO) {

        List<PoliceInfoVO> policeInfo = policeInfoMapper.getPoliceList(policeSearchDTO);
        return policeInfo;
    }

    @Override
    public void addPoliceInfo(PoliceDTO policeDTO) {
        PoliceInfo policeInfo = new PoliceInfo();
        BeanUtil.copyProperties(policeDTO, policeInfo);
        policeInfo.setDeleteStatus(0);
        policeInfo.setPassword(SecurityUtils.encryptPassword(policeDTO.getPassword()));
        policeInfoMapper.insert(policeInfo);
    }

    @Override
    public void updatePoliceInfo(PoliceDTO policeDTO) {
        PoliceInfo oldPoliceInfo = policeInfoMapper.selectById(policeDTO.getId());
        if (Objects.nonNull(oldPoliceInfo)){
            BeanUtil.copyProperties(policeDTO, oldPoliceInfo, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

            policeInfoMapper.updateById(oldPoliceInfo);
        }
    }

    @Override
    public void deletePoliceInfo(List<Long> ids) {
        List<PoliceInfo> policeInfos = policeInfoMapper.selectBatchIds(ids);
        if (CollectionUtil.isNotEmpty(policeInfos)){
            policeInfos.stream().forEach(policeInfo -> {
                policeInfo.setDeleteStatus(1);
            });
            this.saveOrUpdateBatch(policeInfos);
        }
    }

    @Override
    public PoliceDropDown getUnitDropdown() {
        PoliceDropDown policeDropDown = new PoliceDropDown();
        List<UnitInfoVo> unitList = unitInfoMapper.getUnitList("", "");
        policeDropDown.setUnitInfos(unitList);
        return policeDropDown;
    }
}
