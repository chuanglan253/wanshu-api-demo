using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace wanshu_api_demo
{
	/**
	 * 空号检测
	 */
	public class KonghaoApi
	{
		const string APP_ID_KONGHAO = "12345678";
	    const string APP_KEY_KONGHAO = "12345678";	
	    const string API_URL_KONGHAO = "http://localhost:8888/open/unn/ucheck";
	
	    public void Check() {
	        // 1.调用空号检测api
	        JObject jsonObject = invokeKonghao("1371234****");
	
	        // 2.处理返回结果
	        if (jsonObject != null) {
	            //响应code码。200000：成功，其他失败
	            string code = jsonObject["code"].ToString();
	            if ("200000".Equals(code) && null != jsonObject["data"]) {
	                // 调用空号检测成功
	                // 解析结果数据，进行业务处理
	                // 检测结果  0:空号  1:实号  2:停机  3:库无  4:沉默号
	                string status = jsonObject["data"]["status"].ToString();
	                Console.WriteLine("调用空号检测成功,status:" + status);
	            } else {
	                // 记录错误日志，正式项目中请换成log打印
	                Console.WriteLine("调用空号检测失败,code:" + code + ",msg:" +  jsonObject["message"]);
	            }
	        }
	    }
	
	
	    private JObject invokeKonghao(string mobile) {
	        IDictionary<string, string> dic = new Dictionary<string, string>();
	        dic.Add("appId", APP_ID_KONGHAO);
	        dic.Add("appKey", APP_KEY_KONGHAO);
	        dic.Add("mobile", mobile);
	        string result = HttpUtility.Post(API_URL_KONGHAO, dic);
	        // 解析json,并返回结果
	         return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
	    }
	}
}
