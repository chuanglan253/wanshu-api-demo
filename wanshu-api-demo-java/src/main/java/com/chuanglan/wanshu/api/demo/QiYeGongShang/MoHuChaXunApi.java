package com.chuanglan.wanshu.api.demo.QiYeGongShang;

import java.util.HashMap;
import java.util.Map;

import com.chuanglan.wanshu.api.demo.HttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 关键字模糊查询
 */
public class MoHuChaXunApi {

	private static String APP_ID = "qqqqqqqq";

    private static String APP_KEY = "qqqqqqqq";

    private static String API_URL = "https://api.253.com/open/company/search";

    private static JsonParser jsonParser = new JsonParser();

	public static void main(String[] args) {
        // 1.调用api
		JsonObject jsonObject = invokeSearch();
    	// 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
            	String pageInfoStr = jsonObject.get("data").getAsJsonObject().get("paging").toString();
            	System.out.println("调用关键字模糊查询成功，分页信息:"+pageInfoStr);
                String content = jsonObject.get("data").getAsJsonObject().get("datas").toString();
                System.out.println("调用关键字模糊查询成功,content is :" + content);
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用关键字模糊查询失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }

	}
	
	private static JsonObject invokeSearch() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID);
        params.put("appKey", APP_KEY);
        params.put("keyWord", "**"); //搜索关键字
        params.put("exactlyMatch", "true"); //是否精准匹配，默认否，非必传
        params.put("sourceKey", "true"); //是否返回命中字段内容，默认否，非必传
        params.put("searchType", "1"); //搜索范围，非必传， 1默认（企业名称）、2企业名称、3法人股东、4机构代码、5经营范围、6地址、7电话、8邮箱、9域名网址、10专利、11商标品牌、12著作权、13法人、14股东、15主要成员、16高管团队
        params.put("pageSize", "10");//每页条数，默认为10,最大不超过20条,非必传
        params.put("pageIndex", "0");//页码（从0开始）,非必传
        String result = HttpUtils.post(API_URL, params);
        // 解析json,并返回结果
        return jsonParser.parse(result).getAsJsonObject();
    }
}
