package com.yuxuan.wechat.feigns;

import com.yuxuan.wechat.models.IPList;
import com.yuxuan.wechat.models.JsApiTicket;
import com.yuxuan.wechat.models.Token;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 公众号授权相关API
 *
 * @author yuxuan
 * @date 2019/5/22
 */
public interface TokenApi {

    /**
     * 获取微信公众号access_token
     *
     * @param appid      第三方用户唯一凭证
     * @param secret     第三方用户唯一凭证密钥，即appsecret
     * @return
     */
    @RequestLine("GET /cgi-bin/token?grant_type=client_credential")
    Token token(@Param("appid") String appid,  @Param("secret") String secret);

    /**
     * 获取微信服务器IP地址
     * @param access_token
     * @return
     */
    @RequestLine("GET /cgi-bin/getcallbackip")
    IPList callbackip(@Param("access_token") String access_token);

    /**
     * 获得jsapi_ticket
     * @param access_token
     * @return
     */
    @RequestLine("GET /cgi-bin/ticket/getticket?type=jsapi")
    JsApiTicket ticket(@Param("access_token") String access_token);


}
