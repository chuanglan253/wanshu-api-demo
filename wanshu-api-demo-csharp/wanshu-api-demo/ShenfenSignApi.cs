using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

using System.Security.Cryptography;



namespace wanshu_api_demo
{
	/**
	 * 身份二要素认证
	 */
	public class ShenfenSignApi
	{
		const string APP_ID_SHENFEN = "qqqqqqqq";
	    const string APP_KEY_SHENFEN = "qqqqqqqq";
		const string API_URL_SHENFEN = "https://api.253.com/open/idcard/id-card-auth/vs";
	   
	
		public static void Main(string[] args)
		{
			// 1.调用身份信息校验api
	        JObject jsonObject = invokeShenfen("李*", "34253019930526****");
	
			// 2.处理返回结果
			if (jsonObject != null) {
				//响应code码。200000：成功，其他失败
				string code = jsonObject["code"].ToString();
				if ("200000".Equals(code) && null != jsonObject["data"]) {
					// 调用身份信息校验成功
					// 解析结果数据，进行业务处理
					// 校验状态码  000000：成功，其他失败
					string content = jsonObject["data"].ToString();
					Console.WriteLine("查询成功,content is :" + content);
				} else {
					// 记录错误日志，正式项目中请换成log打印
					Console.WriteLine("调用身份信息校验失败,code:" + code + ",msg:" + jsonObject["message"]);
				}
			}
			Console.ReadLine();
		}
	   
	   
		static string UrlEncode(string str)
		{
			string sb = "";
			byte[] byStr = System.Text.Encoding.UTF8.GetBytes(str);
			for (int i = 0; i < byStr.Length; i++) {
				sb += @"%" + Convert.ToString(byStr[i], 16);//将 8 位无符号整数的值转换为其等效的指定基数的字符串表示形式。(url转成16进制等效值。范围：2、8、10、16)
			}
			return sb;
		}

	   
	   
		static string HMACSHA1Text(string EncryptText, string EncryptKey)
		{
			//HMACSHA1加密
			HMACSHA1 hmacsha1 = new HMACSHA1();
			hmacsha1.Key = System.Text.Encoding.UTF8.GetBytes(EncryptKey);

			byte[] dataBuffer = System.Text.Encoding.UTF8.GetBytes(EncryptText);
			byte[] hashBytes = hmacsha1.ComputeHash(dataBuffer);
			return Convert.ToBase64String(hashBytes);
		}
	
		static JObject invokeShenfen(string name, string idNum)
		{
			String encryptStr = "appId" + APP_ID_SHENFEN + "idNum" + idNum + "name" + name;
	    	
			String mySign = HMACSHA1Text(encryptStr, APP_KEY_SHENFEN);
	    	
			Console.Write(mySign);
			IDictionary<string, string> dic = new Dictionary<string, string>();
			dic.Add("appId", APP_ID_SHENFEN);
			dic.Add("sign", UrlEncode(mySign));
			dic.Add("name", name);
			dic.Add("idNum", idNum);
			string result = HttpUtility.Post(API_URL_SHENFEN, dic);
			// 解析json,并返回结果
			return string.IsNullOrEmpty(result) ? null : (JObject)JsonConvert.DeserializeObject(result);
		}
	}
}
