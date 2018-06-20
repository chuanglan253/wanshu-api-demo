using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace wanshu_api_demo
{
	/**
	 * 人证对比接口样例
	 */
	public class RenZhengDuiBiApi
	{
		const string APP_ID = "qqqqqqqq";
	    const string APP_KEY = "qqqqqqqq";	
	    const string API_URL = "https://api.253.com/open/i/witness/face-contrast";
	
	    public void Check() {
	        // 1.调用api
	        JObject jsonObject = invoke();
	
	        // 2.处理返回结果
	        if (jsonObject != null) {
	            //响应code码。200000：成功，其他失败
	            string code = jsonObject["code"].ToString();
	            if ("200000".Equals(code) && null != jsonObject["data"]) {
	                string content = jsonObject["data"].ToString();
                	Console.WriteLine("查询成功,content is :" + content);
	            } else {
	                // 记录错误日志，正式项目中请换成log打印
	                Console.WriteLine("查询失败,code:" + code + ",msg:" + jsonObject["message"]);
	            }
	        }
	    }
	
	
	    private JObject invoke() {
	        IDictionary<string, string> dic = new Dictionary<string, string>();
	        dic.Add("appId", APP_ID);
	        dic.Add("appKey", APP_KEY);
	         //imageType为URL时，传入照片的网络URL地址, 支持jpg/png/bmp格式；
            //imageType为BASE64时，传入照片的base64字符编码，base64编码不包含data:image前缀，且图片大小不能大于2M
	        dic.Add("liveImage","http://***.***.***/download/pic/live-demo.jpg");
	        dic.Add("idCardImage","http://***.***.***/download/pic/idcard-demo.jpg");
	        dic.Add("imageType", "URL"); //图片类型（图片类型：URL或BASE64）
	        string result = HttpUtility.Post(API_URL, dic);
	        // 解析json,并返回结果
	         return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
	    }
	}
}
