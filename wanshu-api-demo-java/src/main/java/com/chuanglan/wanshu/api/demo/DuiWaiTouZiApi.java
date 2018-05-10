package com.chuanglan.wanshu.api.demo;

import java.util.HashMap;
import java.util.Map;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 对外投资
 */
public class DuiWaiTouZiApi {

	private static String APP_ID = "qqqqqqqq";

    private static String APP_KEY = "qqqqqqqq";

    private static String API_URL = "https://api.253.com/open/company/invest-abord";

    private static JsonParser jsonParser = new JsonParser();

	public static void main(String[] args) {
        // 1.调用api
		JsonObject jsonObject = invokeInvestAbord();
    	// 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
            	String pageInfoStr = jsonObject.get("data").getAsJsonObject().get("paging").toString();
            	System.out.println("公司对外投资信息查询成功，分页信息:"+pageInfoStr);
                String content = jsonObject.get("data").getAsJsonObject().get("datas").toString();
                System.out.println("公司对外投资信息查询成功,content is :" + content);
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("公司对外投资信息查询失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }

	}
	
	private static JsonObject invokeInvestAbord() {
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
