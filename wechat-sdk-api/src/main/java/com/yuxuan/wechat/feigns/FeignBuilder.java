package com.yuxuan.wechat.feigns;

import com.yuxuan.wechat.feigns.coders.WeChatDecoder;
import com.yuxuan.wechat.feigns.coders.WeChatEncoder;
import com.yuxuan.wechat.feigns.coders.WeChatErrDecoder;
import feign.Feign;
import feign.Request;


/**
 * 构建接口API
 *
 * @author yuxuan
 * @date 2019/5/22
 */
public class FeignBuilder {
    /**
     * 接口请求地址
     */
    public static final String API_URL = "https://api.weixin.qq.com";

    /**
     * 创建tokenApi
     *
     * @return
     */
    public static TokenApi builderTokenApi(){
        return builderApi(TokenApi.class);
    }

    /**
     * 创建oauthApi
     *
     * @return
     */
    public static OAuthApi builderOAuthApi(){
        return builderApi(OAuthApi.class);
    }

    /**
     * 构建api
     *
     * @param apiType
     * @param <T>
     * @return
     */
    public static <T> T builderApi(Class<T> apiType){
        return Feign.builder()
                .encoder(new WeChatEncoder())
                .decoder(new WeChatDecoder())
                .errorDecoder(new WeChatErrDecoder())
                .options(new Request.Options(5000, 20000))
                .target(apiType, API_URL);
    }
}
