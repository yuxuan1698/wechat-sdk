package com.yuxuan.wechat.feigns;

import com.yuxuan.wechat.annotations.Domain;
import com.yuxuan.wechat.models.AccessToken;
import com.yuxuan.wechat.models.CodeSession;
import com.yuxuan.wechat.models.UserInfo;
import feign.Param;
import feign.RequestLine;

/**
 * 用户授权相关API
 *
 * @author yuxuan
 * @date 2019/5/22
 */
@Domain("https://api.weixin.qq.com")
public interface OAuthApi {
    /**
     * 通过code换取网页授权access_token
     * <p>
     * 参数示例 ?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     *
     * @param appId      是	公众号的唯一标识
     * @param secret     是	公众号的appsecret
     * @param code       是	填写第一步获取的code参数
     * grant_type 是	填写为authorization_code
     * @return
     */
    @RequestLine("GET /sns/oauth2/access_token?grant_type=authorization_code")
    AccessToken access_token(@Param("appid") String appId,
                             @Param("secret") String secret,
                             @Param("code") String code);

    /**
     * 刷新access_token
     * <p>
     * 参数示例 ?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
     *
     * @param appId         是	公众号的唯一标识
     * @param grant_type    是	填写为refresh_token
     * @param refresh_token 是	填写通过access_token获取到的refresh_token参数
     * @return
     */
    @RequestLine("GET /sns/oauth2/refresh_token")
    AccessToken refresh_token(@Param("appid") String appId,
                              @Param("grant_type") String grant_type,
                              @Param("refresh_token") String refresh_token);

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * <p>
     * 参考示例 ?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
     * GET（请使用https协议）
     *
     * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid       用户的唯一标识
     * lang         返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     */
    @RequestLine("GET /sns/userinfo?lang=zh_CN")
    UserInfo userinfo(@Param("access_token") String access_token,
                      @Param("openid") String openid);

    /**
     * 微信小程序获取授权信息
     *
     * @param appid      小程序appid
     * @param secret     小程序密钥
     * @param js_code    小程序调用登录接口后的code
     * grant_type 填写为authorization_code
     * @return
     */
    @RequestLine("POST /sns/jscode2session?grant_type=authorization_code")
    CodeSession code2session(@Param("appid") String appid,
                             @Param("secret") String secret,
                             @Param("js_code") String js_code);
}
