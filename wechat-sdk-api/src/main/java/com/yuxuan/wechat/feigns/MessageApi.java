package com.yuxuan.wechat.feigns;

import com.yuxuan.wechat.annotations.Domain;
import com.yuxuan.wechat.models.AppletMessage;
import com.yuxuan.wechat.models.BaseResult;
import com.yuxuan.wechat.models.WechatMessage;
import com.yuxuan.wechat.models.WechatMessageResult;
import feign.Body;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

/**
 * @author zengyh
 * @date 2019/8/26
 */
@Domain("https://api.weixin.qq.com")
public interface MessageApi {

    /**
     * 发送小程序模板消息
     *
     * @param access_token
     * @param appletMessage
     * @return
     */
    @RequestLine("POST /cgi-bin/message/wxopen/template/send")
    @Body("appletMessage")
    BaseResult sendAppletMessage(@Param("access_token") String access_token, @Param("appletMessage") AppletMessage appletMessage);

    /**
     * 发送公众号模板消息
     *
     * @param access_token
     * @param wechatMessage
     * @return
     */
    @RequestLine("POST /cgi-bin/message/template/send")
    @Body("wechatMessage")
    WechatMessageResult sendWechatMesssage(@Param("access_token") String access_token, @Param("wechatMessage") WechatMessage wechatMessage);
}
