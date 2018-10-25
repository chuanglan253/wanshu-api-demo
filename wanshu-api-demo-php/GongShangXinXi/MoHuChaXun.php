<?php
    $url = 'https://api.253.com/open/company/search';
    $params = [
        'appId' => 'xxx', // appId,登录万数平台查看
        'appKey' => 'xxx', // appKey,登录万数平台查看
		'keyWord' => 'xxx', // 搜索关键字
		'exactlyMatch' => 'true', //是否精准匹配，默认否，非必传
		'sourceKey' => 'true', // 是否返回命中字段内容，默认否，非必传
		'searchType' => 'x', // 搜索范围，非必传， 1默认（企业名称）、2企业名称、3法人股东、4机构代码、5经营范围、6地址、7电话、8邮箱、9域名网址、10专利、11商标品牌、12著作权、13法人、14股东、15主要成员、16高管团队
        'pageSize' => '10', // 每页条数，默认为10,最大不超过20条,非必传
		'pageIndex' => '0', // 页码（从0开始）,非必传
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