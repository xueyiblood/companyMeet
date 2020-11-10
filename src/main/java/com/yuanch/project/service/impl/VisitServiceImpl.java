package com.yuanch.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuanch.common.config.properties.PictureProperties;
import com.yuanch.common.enums.RelationEnum;
import com.yuanch.project.dto.*;
import com.yuanch.project.entity.ProductInfo;
import com.yuanch.project.entity.VisitInfo;
import com.yuanch.project.mapper.komo.ProductInfoMapper;
import com.yuanch.project.mapper.komo.VisitMapper;
import com.yuanch.project.service.ProductInfoService;
import com.yuanch.project.service.VisitService;
import com.yuanch.project.vo.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import java.io.IOException;
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
    @Autowired
    private ProductInfoMapper productInfoMapper;

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
        ProductSearchDTO productSearchDTO = new ProductSearchDTO();
        productSearchDTO.setVisitId(id);
        List<ProductInfo> visitProductList = productInfoService.getVisitProductList(productSearchDTO);
        if (CollectionUtil.isNotEmpty(visitProductList)){
            for (ProductInfo productInfo : visitProductList) {
                productInfo.setDeleteStatus(1);
            }
            productInfoService.saveOrUpdateBatch(visitProductList);
        }

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

    @Override
    public FaceCheckRunningDTO faceCheckWithRunning(FaceVO faceVO) {
        FaceCheckRunningDTO faceCheckRunningDTO = new FaceCheckRunningDTO();

        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                //先登录取到seesion_id
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("name", pictureProperties.getName());
                data.put("password", pictureProperties.getPassword());

                HttpPost httpPost = new HttpPost(pictureProperties.getServiceurl() + "/login");
                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
                httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data),
                        ContentType.create("text/json", "UTF-8")));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                LoginVO loginVO = JSONUtil.toBean(result, LoginVO.class);


                //人脸比对取结果

                this.getfaces (loginVO.getSession_id(), faceVO.getQueryImage());


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

        return faceCheckRunningDTO;
    }

    private FindFaceVO getfaces(String session_id, String queryImage) throws JsonProcessingException {

        FindFaceVO findFaceVO = new FindFaceVO();
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;

            ObjectMapper findObjectMapper = new ObjectMapper();
            Map<String, Object> findData = new HashMap<String, Object>();
            List extraList = new ArrayList();
            extraList.add("custom_field_1");
            findData.put("extra_fields", extraList);
            findData.put("order", new OrderDTO());
            findData.put("start",0);
            findData.put("limit",3);
            RetrievalDTO retrievalDTO = new RetrievalDTO();
            retrievalDTO.setPicture_image_content_base64(queryImage);

            List repositoryList = new ArrayList();
            repositoryList.add("14");
            retrievalDTO.setRepository_ids(repositoryList);

            findData.put("retrieval",retrievalDTO);
            findData.put("retrieval_query_id", "48");


            HttpPost findhttpPost = new HttpPost(pictureProperties.getServiceurl() + "/retrieval_repository");
            findhttpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
            findhttpPost.setHeader("session_id", session_id);
            findhttpPost.setEntity(new StringEntity(findObjectMapper.writeValueAsString(findData),
                    ContentType.create("text/json", "UTF-8")));

            client = HttpClients.createDefault();
            response = client.execute(findhttpPost);
            HttpEntity findentity = response.getEntity();
            String findresult = EntityUtils.toString(findentity);
            System.out.println(findresult);
            findFaceVO = JSONUtil.toBean(findresult, FindFaceVO.class);

            if (CollectionUtil.isNotEmpty(findFaceVO.getResults())){
                //取图片
                for (FaceResultVO faceResultVO:findFaceVO.getResults()) {
                    String url = this.getpicture(faceResultVO.getFace_image_uri(), session_id);
                    faceResultVO.setFace_image_uri(url);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return findFaceVO;
    }

    private String getpicture(String face_image_uri, String session_id) {

        //创建 CloseableHttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        try {
            URIBuilder uri = new URIBuilder(pictureProperties.getServiceurl() + "/storage/image?uri_base64=" + Base64.getEncoder().encodeToString(face_image_uri.getBytes()));

            HttpGet httpGet = new HttpGet(uri.build());
            //设置请求状态参数
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(3000)
                    .setSocketTimeout(3000)
                    .setConnectTimeout(3000).build();
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("session_id", session_id);
            response = httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();//获取返回状态值
            if (status == HttpStatus.SC_OK) {//请求成功
                HttpEntity httpEntity = response.getEntity();
                if(httpEntity != null){
                    result = EntityUtils.toString(httpEntity, "UTF-8");
                    EntityUtils.consume(httpEntity);//关闭资源

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }





}
