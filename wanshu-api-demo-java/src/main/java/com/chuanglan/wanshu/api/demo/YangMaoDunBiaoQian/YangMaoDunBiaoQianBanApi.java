package com.chuanglan.wanshu.api.demo.YangMaoDunBiaoQian;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 羊毛盾标签版接口
 */
public class YangMaoDunBiaoQianBanApi {

    private static String APP_ID_YANGMAODANG = "12345678";

    private static String APP_KEY_YANGMAODANG = "12345678";

    private static String API_URL_YANGMAODANG = "https://api.253.com/open/wooltag/wooltag";

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {
        // 1.调用羊毛盾标签版接口api
        final JsonObject jsonObject = YangMaoDunBiaoQianBanApi.invokeApi("1705003****", "*.*.*.*", "0");

        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                // 调成功
                // 解析结果数据，进行业务处理
                // 检测结果
                System.out.println("调用羊毛盾标签版接口成功,data:" + jsonObject.get("data").toString());
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用羊毛盾标签版接口失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }
    }


    private static JsonObject invokeApi(String mobile, String ip,String type) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID_YANGMAODANG);
        params.put("appKey", APP_KEY_YANGMAODANG);
        //手机号码
        params.put("mobile", mobile);
        //检测手机号的IP地址，非必传(重要，建议传入)
        params.put("ip", ip);
        //校验类型，枚举值（0,1）。不传或者传0表示mobile字段传递11位手机号码，传1表示mobile字段传递的是32位小写的手机号码MD5值。
        params.put("type", type);
        String result = HttpUtils.post(API_URL_YANGMAODANG, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }

}
