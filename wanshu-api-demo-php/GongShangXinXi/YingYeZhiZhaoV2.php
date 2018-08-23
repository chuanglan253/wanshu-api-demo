<?php
    $url = 'https://api.253.com/open/company/business-license/v2';
    $params = [
        'appId' => 'xxx', // appId,登录万数平台查看
        'appKey' => 'xxx', // appKey,登录万数平台查看
        'companyKey' => '', // 搜索关键字（公司全名、公司id）
		'keyType' => '', // 关键字类型（1代表公司全名,2代表公司ID）
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