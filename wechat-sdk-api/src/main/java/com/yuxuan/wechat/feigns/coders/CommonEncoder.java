package com.yuxuan.wechat.feigns.coders;

import com.alibaba.fastjson.JSON;
import feign.RequestTemplate;
import feign.codec.Encoder;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Optional;

/**
 * @author zengyh
 * @date 2019/8/26
 */
public class CommonEncoder extends Encoder.Default {

    @Override
    public void encode(Object o, Type bodyType, RequestTemplate template) {
        String bodyKey = Optional.ofNullable(template.body()).map(String::new).orElse(null);
        if (o instanceof Map) {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) o).entrySet()) {
                if (StringUtils.isNotBlank(bodyKey) && entry.getKey().equals(bodyKey)) {
                    template.header("Content-Type", "application/json");
                    template.body(JSON.toJSONString(entry.getValue()));
                } else {
                    template.query(true, entry.getKey(), entry.getValue().toString());
                }
            }
        } else {
            template.header("Content-Type", "application/json");
            template.body(JSON.toJSONString(o));
        }
    }
}
