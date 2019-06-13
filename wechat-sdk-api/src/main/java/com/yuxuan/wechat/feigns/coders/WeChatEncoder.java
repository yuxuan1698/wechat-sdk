package com.yuxuan.wechat.feigns.coders;

import com.alibaba.fastjson.JSONObject;
import feign.RequestTemplate;
import feign.codec.Encoder;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author yuxuan
 * @date 2019/5/23
 */
public class WeChatEncoder extends Encoder.Default {

    @Override
    public void encode(Object o, Type bodyType, RequestTemplate template) {
        if (o == null) {
            o = new HashMap();
        }

        if (!(o instanceof Map)) {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(o));
            o = new HashMap();
            for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
                ((HashMap) o).put(stringObjectEntry.getKey(), String.valueOf(stringObjectEntry.getValue()));
            }
        }

        Map<String, String> paramsMap = new HashMap<String, String>();
        for (Map.Entry<String, String> stringStringEntry : ((Map<String, String>) o).entrySet()) {
            try {
                paramsMap.put(stringStringEntry.getKey(), URLEncoder.encode(String.valueOf(stringStringEntry.getValue()), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                paramsMap.put(stringStringEntry.getKey(), String.valueOf(stringStringEntry.getValue()));
            }
        }

        String data = paramsMap.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining("&"));
        template.header("content-type", "application/x-www-form-urlencoded");
        template.body(data);

        return;
    }
}
