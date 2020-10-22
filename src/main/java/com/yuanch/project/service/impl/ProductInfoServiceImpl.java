package com.yuanch.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanch.project.dto.ProductSearchDTO;
import com.yuanch.project.entity.ProductInfo;
import com.yuanch.project.mapper.komo.ProductInfoMapper;
import com.yuanch.project.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getSuspectProductList(ProductSearchDTO productSearchDTO) {

        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_status",0);
        wrapper.eq("suspect_id",productSearchDTO.getSuspectId());
        List<ProductInfo> productInfos = productInfoMapper.selectList(wrapper);


        return productInfos;
    }

    @Override
    public List<ProductInfo> getVisitProductList(ProductSearchDTO productSearchDTO) {
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_status",0);
        wrapper.eq("visit_id",productSearchDTO.getVisitId());
        List<ProductInfo> productInfos = productInfoMapper.selectList(wrapper);


        return productInfos;
    }
}
