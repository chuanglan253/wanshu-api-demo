<?php
    // 接口请求地址
    $url = 'https://api.253.com/open/company/factor-verify';
    $params = [
        'appId' => '', // appId,登录万数平台查看
        'appKey' => '', // appKey,登录万数平台查看
        'socialCreditCode' => '', // 统一信用代码
		'companyName' => '', // 公司全名
		'frName' => '', // 法人名称
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