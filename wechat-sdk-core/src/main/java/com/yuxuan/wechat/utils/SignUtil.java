package com.yuxuan.wechat.utils;

import com.yuxuan.wechat.models.JsApiSignature;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.NoSuchAlgorithmException;

/**
 * 微信JsApi签名工具类
 *
 * @author yuxuan
 * @date 2019/5/22
 */
public class SignUtil {

    public static JsApiSignature createJsApiSignature(String appId, String ticket, String url){
        if (url.indexOf("#") != -1) {
            url = url.split("#")[0];
        }

        long timestamp = System.currentTimeMillis();
        String noncestr = RandomStringUtils.randomAlphabetic(16);

        try {
            String sign = SHA1.genWithAmple(
                    "jsapi_ticket=" + ticket,
                    "noncestr=" + noncestr,
                    "timestamp=" + timestamp,
                    "url=" + url
            );

            JsApiSignature jsApiSignature = new JsApiSignature();
            //jsapiSignature.setDebug(false);
            jsApiSignature.setAppId(appId);
            jsApiSignature.setTimestamp(timestamp);
            jsApiSignature.setNonceStr(noncestr);
            //jsapiSignature.set(url);
            jsApiSignature.setSignature(sign);
            return jsApiSignature;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
