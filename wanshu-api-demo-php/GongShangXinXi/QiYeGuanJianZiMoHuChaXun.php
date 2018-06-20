<?php
    // 接口请求地址
    $url = 'https://api.253.com/open/company/search';
    $params = [
        'appId' => '', // appId,登录万数平台查看
        'appKey' => '', // appKey,登录万数平台查看
        'keyWord' => '', // 搜索关键字（配合搜索范围使用）
		'exactlyMatch' => '', // 是否精准匹配，默认否（传true代表精准匹配）
		'sourceKey' => '', // 是否返回命中字段内容，默认否（传true返回命中字段内容）
		'searchType' => '', // 搜索范围
		'pageSize' => '10', // 每页条数，默认为10,最大不超过20条
		'pageIndex' => '1' // 页码，默认第一页
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