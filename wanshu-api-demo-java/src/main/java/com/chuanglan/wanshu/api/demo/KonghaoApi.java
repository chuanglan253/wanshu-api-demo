package com.chuanglan.wanshu.api.demo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 空号检测
 */
public class KonghaoApi {

    private static String APP_ID_KONGHAO = "qqqqqqqq";

    private static String APP_KEY_KONGHAO = "qqqqqqqq";

    private static String API_URL_KONGHAO = "https://api.253.com/open/unn/ucheck";

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {
        // 1.调用空号检测api
        final JsonObject jsonObject = KonghaoApi.invokeKonghao("1371234****");

        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                // 调用空号检测成功
                // 解析结果数据，进行业务处理
                // 检测结果
                String status = jsonObject.get("data").getAsJsonObject().get("status").getAsString();
                System.out.println("调用空号检测成功,status:" + status);
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用空号检测失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }
    }


    private static JsonObject invokeKonghao(String mobile) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID_KONGHAO);
        params.put("appKey", APP_KEY_KONGHAO);
        params.put("mobile", mobile);
        String result = HttpUtils.post(API_URL_KONGHAO, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
