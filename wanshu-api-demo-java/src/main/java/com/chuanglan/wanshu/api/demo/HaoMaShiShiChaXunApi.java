package com.chuanglan.wanshu.api.demo;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 号码实时查询接口
 */
public class HaoMaShiShiChaXunApi {

    private static String APP_ID_SHENFEN = "qqqqqqqq";

    private static String APP_KEY_SHENFEN = "qqqqqqqq";

    private static String API_URL_SHENFEN = "https://api.253.com/open/noi/no-ol-inquiry";

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {
        // 1.调用身份信息校验api
        final JsonObject jsonObject = invokeShenfen();

        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                // 调用成功
                // 解析结果数据，进行业务处理
                // 校验状态码  000000：成功，其他失败
				System.out.println("调用成功,data:"+jsonObject.get("data").toString());
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }
    }


    private static JsonObject invokeShenfen() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID_SHENFEN);
        params.put("appKey", APP_KEY_SHENFEN);
		params.put("mobile", "186****2102");
        String result = HttpUtils.post(API_URL_SHENFEN, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
