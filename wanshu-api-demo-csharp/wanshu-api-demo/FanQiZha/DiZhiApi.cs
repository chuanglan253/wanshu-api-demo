using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace wanshu_api_demo
{
	/**
	 * 地址反欺诈接口
	 */
	public class DiZhiApi
	{
		const string APP_ID_KONGHAO = "qqqqqqqq";
	    const string APP_KEY_KONGHAO = "qqqqqqqq";	
	    const string API_URL_KONGHAO = "https://api.253.com/open/wool/dadd";
	
	    public static void Main(string[] args) {
	        // 1.调用api
	        JObject jsonObject = invoke();
	
	        // 2.处理返回结果
	        if (jsonObject != null) {
	            //响应code码。200000：成功，其他失败
	            string code = jsonObject["code"].ToString();
	            if ("200000".Equals(code) && null != jsonObject["data"]) {
                	String content = jsonObject["data"].ToString();
                	Console.WriteLine("查询成功,content is :" + content);
	            } else {
	                // 记录错误日志，正式项目中请换成log打印
	                Console.WriteLine("查询失败,code:" + code + ",msg:" + jsonObject["message"]);
	            }
	        }
	        Console.ReadLine();
	    }
	
	
	    static JObject invoke()  {
	        IDictionary<string, string> dic = new Dictionary<string, string>();
	        dic.Add("appId", APP_ID_KONGHAO);
	        dic.Add("appKey", APP_KEY_KONGHAO);
	        dic.Add("address", "上海市松江区茸梅路288弄");
	        string result = HttpUtility.Post(API_URL_KONGHAO, dic);
	        // 解析json,并返回结果
	         return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
	    }
	}
}
