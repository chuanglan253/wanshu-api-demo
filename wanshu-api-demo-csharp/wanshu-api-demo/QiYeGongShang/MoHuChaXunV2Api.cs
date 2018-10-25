using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace wanshu_api_demo
{
	/**
	 * 企业关键词模糊查询V2.0
	 */
	public class MoHuChaXunApi
	{
		const string APP_ID = "qqqqqqqq";
	    const string APP_KEY = "qqqqqqqq";	
	    const string API_URL = "https://api.253.com/open/company/search/v2";
	
	    public static void Main(string[] args) {
	        // 1.调用api
	        JObject jsonObject = invoke();
	
	        // 2.处理返回结果
	        if (jsonObject != null) {
	            //响应code码。200000：成功，其他失败
	            string code = jsonObject["code"].ToString();
	            if ("200000".Equals(code) && null != jsonObject["data"]) {
	                string pageInfoStr = jsonObject["data"]["paging"].ToString();
	                Console.WriteLine("调用关键字模糊查询成功，分页信息:"+pageInfoStr);
                	String content = jsonObject["data"]["datas"].ToString();
                	Console.WriteLine("调用关键字模糊查询成功,content is :" + content);
	            } else {
	                // 记录错误日志，正式项目中请换成log打印
	                Console.WriteLine("调用关键字模糊查询失败,code:" + code + ",msg:" + jsonObject["message"]);
	            }
	        }
	        Console.ReadLine();
	    }
	
	
	    static JObject invoke()  {
	        IDictionary<string, string> dic = new Dictionary<string, string>();
	        dic.Add("appId", APP_ID);
	        dic.Add("appKey", APP_KEY);
	        dic.Add("keyWord", "****");//搜索关键字
	        dic.Add("exactlyMatch", "true");//是否精准匹配，默认否，非必传
	        dic.Add("sourceKey", "true"); //是否返回命中字段内容，默认否，非必传
	        dic.Add("searchType", "1"); //搜索范围，非必传， 1默认（企业名称）、2企业名称、3法人股东、4机构代码、5经营范围、6地址、7电话、8邮箱、9域名网址、10专利、11商标品牌、12著作权、13法人、14股东、15主要成员、16高管团队
	        dic.Add("pageSize", "10");//每页条数，默认为10,最大不超过20条,非必传
	        dic.Add("pageIndex", "0");//页码（从0开始）,非必传
	        string result = HttpUtility.Post(API_URL, dic);
	        // 解析json,并返回结果
	         return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
	    }
	}
}
