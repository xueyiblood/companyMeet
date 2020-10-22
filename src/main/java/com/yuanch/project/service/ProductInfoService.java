package com.yuanch.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanch.project.dto.ProductSearchDTO;
import com.yuanch.project.entity.ProductInfo;

import java.util.List;

public interface ProductInfoService extends IService<ProductInfo> {
    List<ProductInfo> getSuspectProductList(ProductSearchDTO productSearchDTO);

    List<ProductInfo> getVisitProductList(ProductSearchDTO productSearchDTO);
}
