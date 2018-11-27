#!/usr/bin/env python
#coding=utf-8

from urllib2 import Request, urlopen, URLError
import urllib
import json
import base64

#身份证信息人像对比接口样例

def post(url, data):
    params = urllib.urlencode(data)
    print(u'发起的请求为：%s' % url)
    user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
    headers = {'User-Agent': user_agent, 'Content-type': 'application/x-www-form-urlencoded',
               'Accept-Charset': 'utf-8'}
    request = Request(url, params, headers)
    try:
        response = urlopen(request, timeout=10)
    except URLError, e:
        print u'发送请求失败，原因：', e
        return None
    else:
        return response.read().decode('utf-8')


if __name__ == "__main__":

	imageFile=open(r'c:\image.jpg','rb') #自拍照片
	
	base64Str=base64.b64encode(imageFile.read()) #读取文件内容，转换为base64编码
	
	imageFile.close()


    	invoke_url = 'https://api.253.com/open/i/idpic/idpic-match'
	
    	invoke_data = {'appId': '12345678', 'appKey': '12345678', 'imageType': 'BASE64','image': base64Str,'name': '***','cardNum':'**********'}

    	# 1. 调用api
    	result_data = post(invoke_url, invoke_data)
    	# 2.处理返回结果
    	result = json.loads(result_data) if result_data is not None else exit(1)
    	# 响应code码。200000：成功，其他失败
    	if result is None or '200000' != result['code']:
        	print u'调用失败,code:', result['code'], ',msg:', result['message']
    	else:
        # 调用成功
        # 解析结果数据，进行业务处理
        # 检测结果
        	print u'调用成功,result:', result['data']