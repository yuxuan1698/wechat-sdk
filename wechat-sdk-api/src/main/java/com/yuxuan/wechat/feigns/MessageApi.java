package com.yuxuan.wechat.feigns;

import com.yuxuan.wechat.annotations.Domain;
import com.yuxuan.wechat.models.AppletMessage;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

/**
 * @author zengyh
 * @date 2019/8/26
 */
@Domain("https://api.weixin.qq.com")
public interface MessageApi {

    @RequestLine("POST https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN")
    Map<String, Object> sentAppletMessage(@Param("accessToken") String accessToken, AppletMessage appletMessage);
}
