package com.yuxuan.wechat.feigns;

import com.yuxuan.wechat.annotations.Domain;
import com.yuxuan.wechat.models.AppletMessage;
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

    @RequestLine("POST /cgi-bin/message/wxopen/template/send")
    @Body("appletMessage")
    Map<String, Object> sendAppletMessage(@Param("access_token") String access_token, @Param("appletMessage") AppletMessage appletMessage);
}
