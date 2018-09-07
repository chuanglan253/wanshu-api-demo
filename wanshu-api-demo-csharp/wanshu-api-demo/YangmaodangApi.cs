using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace wanshu_api_demo
{
	/**
	 * 羊毛党检测
	 */
	public class YangmaodangApi
	{
		const string APP_ID_YANGMAODANG = "12345678";
        const string APP_KEY_YANGMAODANG = "12345678";
        const string API_URL_YANGMAODANG = "https://api.253.com/open/wool/wcheck";
    
		public static void Main(string[] args)
		{
			// 1.调用羊毛党检测api
	        JObject jsonObject = invokeYangmaodang("1705003****", "*.*.*.*");
	
	        // 2.处理返回结果
	        if (jsonObject != null) {
	            //响应code码。200000：成功，其他失败
	            string code = jsonObject["code"].ToString();
	            if ("200000".Equals(code) && null != jsonObject["data"]) {
	                // 调用羊毛党检测成功
	                // 解析结果数据，进行业务处理
	                // 检测结果
	                string status = jsonObject["data"]["status"].ToString();
	                Console.WriteLine("调用羊毛党检测成功,status:" + status);
	            } else {
	                // 记录错误日志，正式项目中请换成log打印
	                Console.WriteLine("调用羊毛党检测失败,code:" + code + ",msg:" + jsonObject["message"]);
	            }
	        }
	        Console.ReadLine();
		}
		
		
		static JObject  invokeYangmaodang(string mobile, string ip) {
	        IDictionary<string, string> dic = new Dictionary<string, string>();
	        dic.Add("appId", APP_ID_YANGMAODANG);
	        dic.Add("appKey", APP_KEY_YANGMAODANG);
	        dic.Add("mobile", mobile);
	        dic.Add("ip", ip);
	        string result = HttpUtility.Post(API_URL_YANGMAODANG, dic);
	        // 解析json,并返回结果
	        return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
    	}
	}
}