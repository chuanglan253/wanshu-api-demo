<?php

	$url = 'https://api.253.com/open/stock/announcement';
	$params = [
		'appId' => 'xxx', // appId,登录万数平台查看
		'appKey' => 'xxx', // appKey,登录万数平台查看
		'companyKey' => '', // 搜索关键字（公司全名或公司id）
		'keyType' => '', // 搜索关键字类型（1-公司名、2-公司id）
		'pageSize' => '', // 每页条数，默认为10,最大不超过20条,非必传
		'pageIndex' => '', // 页码（从0开始）,非必传
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