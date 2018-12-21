<?php

    $url = 'https://api.253.com/open/i/witness/idpic-match';
    $params = [
        'appId' => 'xxx', // appId,登录万数平台查看
        'appKey' => 'xxx', // appKey,登录万数平台查看
		'facePic' => '', // 必填，自拍照，支持HTTP URL和base64字符串，图片大小不能大于2M, base64字符串去掉头部描述(如"data:image/png;base64,")
        'idCardFrontPic' => '', // 非必填，身份证正面图片，支持HTTP URL和base64字符串，图片大小不能大于2M, base64字符串去掉头部描述(如"data:image/png;base64,")
        'idCardBackPic' => '', // 非必填，身份证反面图片，支持HTTP URL和base64字符串，图片大小不能大于2M, base64字符串去掉头部描述(如"data:image/png;base64,")
		'idNum' => '', // 必填，身份证号
		'name' => '', // 必填，姓名
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