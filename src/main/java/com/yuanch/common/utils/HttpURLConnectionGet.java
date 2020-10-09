package com.yuanch.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpURLConnectionGet {

    private static Logger log = LoggerFactory.getLogger(HttpURLConnectionGet.class);

    public static Object getData(String address) {
        BufferedReader in = null;
        try {
            //获取访问地址URL,注意GET请求若URL中包含中文字符的话,在高版本TOMCAT中会认为是不合法字符,可改为POST方式
            URL url = new URL(address);
            //创建HttpURLConnection对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //请求方式,默认是GET
            conn.setRequestMethod("GET");
            //连接主机的超时时间（单位：毫秒）
            conn.setConnectTimeout(30000);
            //从主机读取数据的超时时间（单位：毫秒）
            conn.setReadTimeout(30000);
            //设置是否输出,默认是false
            conn.setDoOutput(false);
            //设置是否读入,默认是true
            conn.setDoInput(true);
            String result = "";
            int code = conn.getResponseCode();
            if (code == 200) {
                //定义BufferedReader输入流读取响应,getInputStream()会自动建立连接,无需手动调用connect()连接
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                //关闭输入流
                in.close();
            }
//            System.out.println("返回结果："+result);
            log.info("返回结果:" + result);
            return result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }




    public static void main(String[] args) throws Exception {

        //转换多个对象
        /*String data = (String)HttpURLConnectionGet.getData("http://192.168.3.180:8090/systemSetting/searchUserAndRole");
        System.out.println("-----data-----"+data);
        JSONObject jsonObject=JSONObject.parseObject(data);
        System.out.println("-----jsonObject-----"+jsonObject);
        JSONArray user = jsonObject.getJSONArray("data");
        System.out.println("-----user-----"+user);
        List<SysUserDO> userDOs = JSON.parseObject(user.toJSONString(), new TypeReference<List<SysUserDO>>() {
        });

        for (SysUserDO userDO : userDOs){
            System.out.println(userDO);
        }*/

        //转换一个对象
        /*String data = (String)HttpURLConnectionGet.getData("http://localhost:8090/office/achieveCaseNumberAndLikeSearch?ajbh=J3205150118190278888");
        System.out.println("--data---"+data);
        JSONObject jsonObject=JSONObject.parseObject(data);
        System.out.println("--jsonObject---"+jsonObject);
        JSONArray user = jsonObject.getJSONArray("data");
        List<BarcodeEntity> barcodeEntities = JSON.parseObject(user.toJSONString(), new TypeReference<List<BarcodeEntity>>() {
        });
        for (BarcodeEntity barcodeEntity : barcodeEntities){
            System.out.println("--barcodeEntity---"+barcodeEntity);
        }*/



        /*JSONObject list = jsonObject.getJSONObject("list");
        System.out.println(list);
        BarcodeEntity barcodeEntity = JSON.parseObject(list.toJSONString(), new TypeReference<BarcodeEntity>() {});
        System.out.println("--barcodeEntity---"+barcodeEntity);*/

        //SysUserDO stu=(SysUserDO)JSONObject.toBean(jsonObject, SysUserDO.class);
        /*SysUserDO sysUserDO = JSON.parseObject(data, new TypeReference<SysUserDO>() {});
        System.out.println(data);
        System.out.println(sysUserDO);*/
    }


}
