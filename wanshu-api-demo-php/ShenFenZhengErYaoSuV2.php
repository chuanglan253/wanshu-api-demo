<?php
    $url = 'https://api.253.com/open/idcard/id-card-auth/vs';
	$appId = '123456'; // 请替换成自己真实的appId
    $appKey = '456789'; // 请替换成自己真实的appKey
	$name = ''; // 要检测的真实姓名
	$idNum = ''; // 身份证号码
	// 参数名称和值拼接
	$str = 'appId'.$appId.'idNum'.$idNum.'name'.$name;
	$hex = hash_hmac("sha1", $str, $appKey,true);
	$sign = base64_encode($hex);
	$params = [
        'appId' => $appId, 
        'name' => $name,
        'idNum' => $idNum,
        'sign' => $sign,
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
?>