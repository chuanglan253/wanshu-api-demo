package com.chuanglan.wanshu.api.demo.QiYeXingYong;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 行政处罚
 */
public class XinZhengChuFaApi {

    private static String APP_ID = "qqqqqqqq";

    private static String APP_KEY = "qqqqqqqq";

    private static String API_URL = "https://api.253.com/open/entcredit/admin-penalty";

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
        params.put("companyKey", "****有限责任公司");//搜索关键字（公司全名、公司id）
        params.put("keyType", "1"); //1-公司名、2-公司key
        params.put("pageSize", "10");//每页条数，默认为10,最大不超过20条,非必传
        params.put("pageIndex", "0");//页码（从0开始）,非必传
        String result = HttpUtils.post(API_URL, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }
}
