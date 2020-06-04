package com.crc.baitsplusdemo.utli;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;

@Slf4j
public class HttpRequestUtil {
    /**
     * post请求
     * @param url         url地址
     * @return
     */
    public static String httpPost(String url,String param){
        //post请求返回结果
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        String str = "";
        try {
            StringEntity entity = new StringEntity(param, "utf-8");
            httpPost.setEntity(entity);
            HttpResponse result = httpClient.execute(httpPost);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity(),"UTF-8");
                } catch (Exception e) {
                    log.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
        }
        return str;
    }


    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static String httpGet(String url){
        //get请求返回结果
        String strResult = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                strResult = EntityUtils.toString(response.getEntity(),"UTF-8");
            } else {
                log.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            log.error("get请求提交失败:" + url, e);
        }
        return strResult;
    }
}
