<?php

	$url = 'https://api.253.com/open/i/ocr/id-ocr';
	$params = [
		'appId' => 'xxx', // appId,登录万数平台查看
		'appKey' => 'xxx', // appKey,登录万数平台查看
		'image' => '', // 身份证照片，请确保身份证内容信息清晰可见。imageType为URL时，传入照片的网络URL地址, 支持jpg/png/bmp格式，imageType为BASE64时，传入照片的base64字符编码，base64编码不包含data:image前缀，且图片大小不能大于2M
		'imageType' => '', // 图片类型，枚举值：URL-图片路径；BASE64 –图片BASE64编码
	];
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
	curl_setopt($ch, CURLOPT_HEADER, 0);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_POST, 1);
	curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($params));
	curl_setopt($ch, CURLOPT_TIMEOUT, 5);
	$result = curl_exec($ch);
	var_dump($result);
	exit;