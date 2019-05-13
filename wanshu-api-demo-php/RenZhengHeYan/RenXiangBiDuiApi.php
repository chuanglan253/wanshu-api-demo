<?php

	$url = 'https://api.253.com/open/i/witness/idpic-match';
	$params = [
		'appId' => 'xxx', // appId,登录万数平台查看
		'appKey' => 'xxx', // appKey,登录万数平台查看
		'name' => '***',
		'idNum' => '******',
		'facePic' => 'http://***.***.***/download/pic/live-demo.jpg',
		'idCardFrontPic' => 'http://***.***.***/download/pic/id-card-front-demo.jpg',
		'idCardBackPic' => 'http://***.***.***/download/pic/id-card-back-demo.jpg',
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