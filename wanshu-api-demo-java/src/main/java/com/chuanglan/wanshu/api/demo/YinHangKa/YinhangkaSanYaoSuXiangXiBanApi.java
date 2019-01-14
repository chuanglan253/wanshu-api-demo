package com.chuanglan.wanshu.api.demo.YinHangKa;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 银行卡三要素详细版
 */
public class YinhangkaSanYaoSuXiangXiBanApi {

    private static String APP_ID_YINHANGKA = "12345678";

    private static String APP_KEY_YINHANGKA = "12345678";

    private static String API_URL_YINHANGKA = "https://api.253.com/open/bankcard/card-three-auth-detail";

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {
        // 1.调用接口api
        final JsonObject jsonObject = invokeYinhangka("李*", "11010120710101****",
                "622600021110****");

        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                // 调用成功
                // 解析结果数据，进行业务处理
                // 认证结果
                System.out.println("调用成功,data:" + jsonObject.get("data").toString());
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }
    }


    private static JsonObject invokeYinhangka(String name, String idNum, String cardNo) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID_YINHANGKA);
        params.put("appKey", APP_KEY_YINHANGKA);
        params.put("name", name);
        params.put("idNum", idNum);
        params.put("cardNo", cardNo);
        String result = HttpUtils.post(API_URL_YINHANGKA, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
