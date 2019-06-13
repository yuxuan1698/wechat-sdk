package com.yuxuan.wechat.feigns.coders;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author yuxuan
 * @date 2019/5/23
 */
public class WeChatDecoder extends GsonDecoder{

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        
        return super.decode(response,type);
    }
}
