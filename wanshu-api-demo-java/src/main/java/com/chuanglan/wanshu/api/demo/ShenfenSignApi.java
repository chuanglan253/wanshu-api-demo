package com.chuanglan.wanshu.api.demo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 身份证校验V2(签名版)demo
 */
public class ShenfenSignApi {

    private static String APP_ID_SHENFEN = "qqqqqqqq";//appId

    private static String APP_KEY_SHENFEN = "qqqqqqqq";//appKey

    private static String URL = "https://api.253.com/open/idcard/id-card-auth/vs";//访问地址


    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {

        String name = "刘**";//用户姓名
        String idNum = "431223198907******";//用户身份证号

        //生成签名
        Map<String, Object> requestMap = getPostData(APP_ID_SHENFEN, name, idNum);

        String requestStr = requestMap2Str(requestMap);
        System.out.println("请求参数" + requestStr);
        String sign = hmacSHA1Encrypt(requestStr, APP_KEY_SHENFEN);////生成的签名字符串
        System.out.println("签名：" + sign);

        // 1.调用身份信息校验api
        final JsonObject jsonObject = invokeShenfen(name, idNum, sign);

        // 2.处理返回结果
        if (jsonObject != null) {
            //响应code码。200000：成功，其他失败
            String code = jsonObject.get("code").getAsString();
            if ("200000".equals(code) && jsonObject.get("data") != null) {
                // 调用身份信息校验成功
                // 解析结果数据，进行业务处理
                // 校验状态码  000000：成功，其他失败
                System.out.println("调用身份信息校验成功,data:" + jsonObject.get("data").getAsJsonObject().toString());
            } else {
                // 记录错误日志，正式项目中请换成log打印
                System.out.println("调用身份信息校验失败,code:" + code + ",msg:" + jsonObject.get("message").getAsString());
            }
        }
    }

    /**
     * 使用这个三个字段进行加密验签
     *
     * @param appId
     * @param name
     * @param idNum
     * @return
     */
    private static Map<String, Object> getPostData(String appId, String name, String idNum) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("idNum", idNum);
        requestMap.put("name", name);
        requestMap.put("appId", appId);
        return requestMap;
    }

    /**
     * 生成加密字符串,并用Base64进行编码
     *
     * @param encryptText
     * @param encryptKey
     * @return
     */
    public static String hmacSHA1Encrypt(String encryptText, String encryptKey) {
        byte[] result = null;
        try {
            //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
            SecretKeySpec signinKey = new SecretKeySpec(encryptKey.getBytes("UTF-8"), "HmacSHA1");
            //生成一个指定 Mac 算法 的 Mac 对象
            Mac mac = Mac.getInstance("HmacSHA1");
            //用给定密钥初始化 Mac 对象
            mac.init(signinKey);
            //完成 Mac 操作
            byte[] rawHmac = mac.doFinal(encryptText.getBytes("UTF-8"));
            result = Base64.getEncoder().encode(rawHmac);

        } catch (Exception e) {

        }
        if (null != result) {
            return new String(result);
        } else {
            return null;
        }
    }

    /**
     * 组装发送请求报文，格式是multipart/form-data
     *
     * @param name
     * @param idNum
     * @param sign
     * @return
     */
    private static JsonObject invokeShenfen(String name, String idNum, String sign) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", APP_ID_SHENFEN);
        params.put("idNum", idNum);
        params.put("name", name);
        params.put("sign", sign);
        String result = HttpUtils.post(URL, params);
        return jsonParser.parse(result).getAsJsonObject();
    }

    /**
     * 生成加密字符串
     *
     * @param requestMap
     * @return
     */
    private static String requestMap2Str(Map<String, Object> requestMap) {
        List<String>  list = new ArrayList<>(requestMap.keySet());
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        for(String key : list){
                stringBuilder.append(key).append(requestMap.get(key));
        }
        return stringBuilder.toString();
    }


}
