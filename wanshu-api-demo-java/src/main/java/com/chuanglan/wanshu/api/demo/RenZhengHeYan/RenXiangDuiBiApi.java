package com.chuanglan.wanshu.api.demo.RenZhengHeYan;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 人像对比
 */
public class RenXiangDuiBiApi {

    private static String APP_ID = "qqqqqqqq";

    private static String APP_KEY = "qqqqqqqq";

    private static String API_URL = "https://api.253.com/open/i/witness/idpic-match";

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {
        // 1.调用api
        JsonObject jsonObject = invokeChangeRecord();
        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                String data = jsonObject.get("data").toString();
                System.out.println("查询成功,返回数据:" + data);
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("查询失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }

    }

    private static JsonObject invokeChangeRecord() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID);
        params.put("appKey", APP_KEY);
        params.put("name","***");
        params.put("idNum","******");
        params.put("facePic", "http://***.***.***/download/pic/live-demo.jpg");
        params.put("idCardFrontPic", "http://***.***.***/download/pic/id-card-front-demo.jpg"); //图片类型（图片类型：URL或BASE64）
        params.put("idCardBackPic", "http://***.***.***/download/pic/id-card-back-demo.jpg"); //图片类型（图片类型：URL或BASE64）
        String result = HttpUtils.post(API_URL, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
