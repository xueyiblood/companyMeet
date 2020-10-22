package com.yuanch.project.controller;

import com.yuanch.common.web.controller.BaseController;
import com.yuanch.common.web.domain.page.TableDataInfo;
import com.yuanch.project.dto.ProductSearchDTO;
import com.yuanch.project.entity.ProductInfo;
import com.yuanch.project.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("物品控制器")
@RequestMapping("suspect")
public class ProductController extends BaseController {

    @Autowired
    private ProductInfoService productInfoService;


    @ApiOperation(value = "根据嫌疑人获取物品列表")
    @PostMapping("getSuspectProductList")
    public TableDataInfo getSuspectProductList(@RequestBody ProductSearchDTO productSearchDTO )
    {
        startPage();
        List<ProductInfo> products = productInfoService.getSuspectProductList(productSearchDTO);
        return getDataTable(products);
    }

    @ApiOperation(value = "根据访客获取物品列表")
    @PostMapping("getVisitProductList")
    public TableDataInfo getVisitProductList(@RequestBody ProductSearchDTO productSearchDTO )
    {
        startPage();
        List<ProductInfo> products = productInfoService.getVisitProductList(productSearchDTO);
        return getDataTable(products);
    }
}
