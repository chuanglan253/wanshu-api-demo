using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace wanshu_api_demo
{
	/**
	 * 企业三要素验证查询
	 */
	public class SanYaoSuApi
	{
		const string APP_ID = "qqqqqqqq";
	    const string APP_KEY = "qqqqqqqq";	
	    const string API_URL = "https://api.253.com/open/company/factor-verify";
	
	    public static void Main(string[] args) {
	        // 1.调用api
	        JObject jsonObject = invoke();
	
	        // 2.处理返回结果
	        if (jsonObject != null) {
	            //响应code码。200000：成功，其他失败
	            string code = jsonObject["code"].ToString();
	            if ("200000".Equals(code) && null != jsonObject["data"]) {
                	String content = jsonObject["data"].ToString();
                	Console.WriteLine("调用企业三要素验证查询成功,content is :" + content);
	            } else {
	                // 记录错误日志，正式项目中请换成log打印
	                Console.WriteLine("调用企业三要素验证查询失败,code:" + code + ",msg:" + jsonObject["message"]);
	            }
	        }
	        Console.ReadLine();
	    }
	
	
	    static JObject invoke()  {
	        IDictionary<string, string> dic = new Dictionary<string, string>();
	        dic.Add("appId", APP_ID);
	        dic.Add("appKey", APP_KEY);
	        dic.Add("socialCreditCode", "91110108551385****");  //统一信用代码
	        dic.Add("companyName", "****有限责任公司"); //1-公司名、2-公司key
	        dic.Add("frName", "**军");//法人
	        string result = HttpUtility.Post(API_URL, dic);
	        // 解析json,并返回结果
	         return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
	    }
	}
}
