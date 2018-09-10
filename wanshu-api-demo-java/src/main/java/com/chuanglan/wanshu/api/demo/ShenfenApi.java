package com.chuanglan.wanshu.api.demo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 身份二要素认证
 */
public class ShenfenApi {

    private static String APP_ID_SHENFEN = "qqqqqqqq";

    private static String APP_KEY_SHENFEN = "qqqqqqqq";

    private static String API_URL_SHENFEN = "https://api.253.com/open/idcard/id-card-auth";

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {
        // 1.调用身份信息校验api
        final JsonObject jsonObject = ShenfenApi.invokeShenfen("刘*", "431223198907******");

        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                // 调用身份信息校验成功
                // 解析结果数据，进行业务处理
                // 校验状态码  000000：成功，其他失败
                System.out.println("调用身份信息校验成功,data:" + jsonObject.get("data").getAsJsonObject().toString());
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用身份信息校验失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }
    }


    private static JsonObject invokeShenfen(String name, String idNum) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID_SHENFEN);
        params.put("appKey", APP_KEY_SHENFEN);
        params.put("name", name);
        params.put("idNum", idNum);
        String result = HttpUtils.post(API_URL_SHENFEN, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
