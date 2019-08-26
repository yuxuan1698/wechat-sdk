package com.yuxuan.wechat.feigns.coders;

import feign.RequestTemplate;
import feign.codec.Encoder;

import java.lang.reflect.Type;

/**
 * @author zengyh
 * @date 2019/8/26
 */
public class WechatBodyEncoder extends Encoder.Default {

    @Override
    public void encode(Object o, Type bodyType, RequestTemplate template) {
        // TODO: 2019/8/26 22:50 params类型和 body类型同时使用问题未解决
        return;
    }
}
