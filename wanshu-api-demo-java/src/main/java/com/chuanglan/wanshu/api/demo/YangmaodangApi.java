package com.chuanglan.wanshu.api.demo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;


public class YangmaodangApi {

    private static String APP_ID_YANGMAODANG = "12345678";

    private static String APP_KEY_YANGMAODANG = "12345678";

    private static String API_URL_YANGMAODANG = "http://*.*.*.*:*/open/woolCheck";

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {
        // 1.调用羊毛党检测api
        final JsonObject jsonObject = YangmaodangApi.invokeYangmaodang("1705003****", "*.*.*.*");

        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code)) {
                // 调用羊毛党检测成功
                // 解析结果数据，进行业务处理
                // 检测结果  W1：白名单  W2：疑似白名单  B1 ：黑名单  B2 ：疑似黑名单  N：未找到
                String status = jsonObject.get("data").getAsJsonObject().get("status").getAsString();
                System.out.println("调用羊毛党检测成功,status:" + status);
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用羊毛党检测失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }
    }


    private static JsonObject invokeYangmaodang(String mobile, String ip) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID_YANGMAODANG);
        params.put("appKey", APP_KEY_YANGMAODANG);
        params.put("mobile", mobile);
        params.put("ip", ip);
        String result = HttpUtils.post(API_URL_YANGMAODANG, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
