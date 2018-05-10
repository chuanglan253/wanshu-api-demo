package com.chuanglan.wanshu.api.demo.QiYeGongShang;

import java.util.HashMap;
import java.util.Map;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 企业三要素验证查询
 */
public class SanYaoSuApi {

	private static String APP_ID = "qqqqqqqq";

    private static String APP_KEY = "qqqqqqqq";

    private static String API_URL = "https://api.253.com/open/company/factor-verify";

    private static JsonParser jsonParser = new JsonParser();

	public static void main(String[] args) {
        // 1.调用api
		JsonObject jsonObject = invokeFactorVerify();
    	// 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                String content = jsonObject.get("data").toString();
                System.out.println("调用企业三要素验证查询成功,content is :" + content);
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用企业三要素验证查询失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }

	}
	
	private static JsonObject invokeFactorVerify() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID);
        params.put("appKey", APP_KEY);
        params.put("socialCreditCode", "91110108551385****"); //统一信用代码
        params.put("companyName", "**有限责任公司"); //1-公司名、2-公司key
        params.put("frName", "**军");//法人
        String result = HttpUtils.post(API_URL, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
