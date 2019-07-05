package com.yuxuan.wechat.annotations;

import java.lang.annotation.*;

/**
 * 接口请求地址注解
 *
 * @author yuxuan
 * @date 2019/5/30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Domain {
    String value();
}
