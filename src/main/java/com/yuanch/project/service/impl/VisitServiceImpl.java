package com.yuanch.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuanch.common.config.properties.PictureProperties;
import com.yuanch.common.enums.RelationEnum;
import com.yuanch.project.dto.*;
import com.yuanch.project.entity.ProductInfo;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.mapper.komo.VisitMapper;
import com.yuanch.project.service.ProductInfoService;
import com.yuanch.project.service.VisitService;
import com.yuanch.project.vo.FaceVO;
import com.yuanch.project.vo.VisitDropDown;
import com.yuanch.project.vo.VisitVO;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitMapper visitMapper;
    @Autowired
    private PictureProperties pictureProperties;
    @Autowired
    private ProductInfoService productInfoService;

    @Override
    public List<VisitVO> getVisitList(VisitSearchDTO visitSearchDTO) {
        List<VisitVO> visitList = visitMapper.getVisitList(visitSearchDTO);
        if (CollectionUtil.isNotEmpty(visitList)){
            for (VisitVO visitVO : visitList) {
                ProductSearchDTO productSearchDTO = new ProductSearchDTO();
                productSearchDTO.setVisitId(visitVO.getId());
                List<ProductInfo> visitProductList = productInfoService.getVisitProductList(productSearchDTO);
                visitVO.setProducts(visitProductList);

            }
        }
        return visitList;
    }

    @Override
    public void deleteVisit(Long id) {
        visitMapper.deleteVisit(id);
    }

    @Override
    public void addVisits(List<VisitDTO> visitDTOS) {

        if (CollectionUtil.isNotEmpty(visitDTOS)){
            for (VisitDTO visitDTO : visitDTOS) {
                VisitInfo visitInfo = new VisitInfo();
                BeanUtil.copyProperties(visitDTO, visitInfo);
                visitInfo.setDeleteStatus(0);
                visitMapper.insert(visitInfo);

                 if (CollectionUtil.isNotEmpty(visitDTO.getProducts())){
                     List<ProductInfo> productInfos = new ArrayList<>();
                     for (ProductDTO productDTO : visitDTO.getProducts()) {
                         ProductInfo productInfo = new ProductInfo();
                         BeanUtil.copyProperties(productDTO, productInfo);
                         productInfo.setDeleteStatus(0);
                         productInfo.setSuspectId(visitDTO.getSuspectId());
                         productInfo.setVisitId(visitInfo.getId());
                         productInfos.add(productInfo);
                     }

                     productInfoService.saveOrUpdateBatch(productInfos);

                 }

            }
        }
    }

    @Override
    public VisitDropDown getVisitDropdown() {
        VisitDropDown visitDropdown = new VisitDropDown();
        visitDropdown.setRelationEnums(Arrays.asList(RelationEnum.values()));

        return visitDropdown;
    }

    @Override
    public FaceCheckDTO faceCheck(FaceVO faceVO) {
        FaceCheckDTO faceCheckDTO = new FaceCheckDTO();
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("queryImage", faceVO.getQueryImage());
                data.put("targetImage", faceVO.getTargetImage());

                HttpPost httpPost = new HttpPost(pictureProperties.getCheckurl());
                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
                httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data),
                        ContentType.create("text/json", "UTF-8")));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                faceCheckDTO.setSimilarity(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return faceCheckDTO;
    }
}
