using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace wanshu_api_demo
{
	/**
	 * 公司联系方式查询
	 */
	public class LianXiXinXiApi
	{
		const string APP_ID = "qqqqqqqq";
	    const string APP_KEY = "qqqqqqqq";	
	    const string API_URL = "https://api.253.com/open/company/additional";
	
	    public void Check() {
	        // 1.调用api
	        JObject jsonObject = invoke();
	
	        // 2.处理返回结果
	        if (jsonObject != null) {
	            //响应code码。200000：成功，其他失败
	            string code = jsonObject["code"].ToString();
	            if ("200000".Equals(code) && null != jsonObject["data"]) {
                	String content = jsonObject["data"].ToString();
                	Console.WriteLine("公司联系方式信息查询成功,content is :" + content);
	            } else {
	                // 记录错误日志，正式项目中请换成log打印
	                Console.WriteLine("公司联系方式信息查询失败,code:" + code + ",msg:" + jsonObject["message"]);
	            }
	        }
	    }
	
	
	    private JObject invoke() {
	        IDictionary<string, string> dic = new Dictionary<string, string>();
	        dic.Add("appId", APP_ID);
	        dic.Add("appKey", APP_KEY);
	        dic.Add("companyKey", "****有限责任公司");//搜索关键字（公司全名、公司id）
	        dic.Add("keyType", "1"); //1-公司名、2-公司key
	        string result = HttpUtility.Post(API_URL, dic);
	        // 解析json,并返回结果
	         return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
	    }
	}
}
