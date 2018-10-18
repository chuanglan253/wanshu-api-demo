<?php

	$url = 'https://api.253.com/open/i/ocr/hand-api';
	$params = [
		'appId' => 'xxx', // appId,登录万数平台查看
		'appKey' => 'xxx', // appKey,登录万数平台查看
		'image' => '', // 要识别的图片，请确保内容信息清晰可见。支持url或base64，图片大小不能大于2M，支持图片类型：jpg/png/bmp
		'imageType' => '', // 图片类型，枚举值：URL-图片路径 ,BASE64 –图片BASE64编码
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