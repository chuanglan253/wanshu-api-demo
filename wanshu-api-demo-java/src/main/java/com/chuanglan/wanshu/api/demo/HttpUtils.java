package com.chuanglan.wanshu.api.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.Map;

public class HttpUtils {
    private static final int REQUEST_TIMEOUT = 3 * 1000; // 设置请求超时10秒钟

    private static final int CONNECT_TIMEOUT = 5 * 1000; // 连接超时时间

    private static final int SO_TIMEOUT = 10 * 1000; // 数据传输超时

    private static final String ENCODING = "UTF-8";

    // 务必单例
    private static CloseableHttpClient client;

    static {
        RequestConfig requestConfig = RequestConfig.custom()
                                                   .setConnectTimeout(CONNECT_TIMEOUT)
                                                   .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                                                   .setSocketTimeout(SO_TIMEOUT)
                                                   .build();
        client = HttpClients.custom().setDefaultRequestConfig(requestConfig).setMaxConnTotal(50).build();
    }

    public static String get(String url, Map<String, String> paramsMap) {
        return send(RequestBuilder.get(url), paramsMap);
    }


    public static String post(String url, Map<String, String> paramsMap) {
        return send(RequestBuilder.post(url), paramsMap);
    }


    public static String send(RequestBuilder requestBuilder, Map<String, String> paramsMap){
        requestBuilder.setCharset(Charset.forName(ENCODING));
        String responseText = "";

        if (paramsMap != null) {
            for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                requestBuilder.addParameter(param.getKey(), param.getValue());
            }

            CloseableHttpResponse response = null;
            try {
                response = client.execute(requestBuilder.build());
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        responseText = EntityUtils.toString(entity, ENCODING);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();//正式项目中请改为log打印
            }finally {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();//正式项目中请改为log打印
                }
            }

        }
        return responseText;

    }
}
