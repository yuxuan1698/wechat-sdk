package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * jsapi_ticket（有效期7200秒，开发者必须在自己的服务全局缓存jsapi_ticket)
 *
 * @author yuxuan
 * @date 2018/5/16
 */
@Data
public class JsApiTicket implements Serializable{

    /**
     *
     * {
     "errcode":0,
     "errmsg":"ok",
     "ticket":"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA",
     "expires_in":7200
     }
     */
    /**
     * 响应代码
     */
    private String errcode;
    /**
     * 响应信息
     */
    private String errmsg;
    /**
     * jsapi_ticket
     */
    private String ticket;
    /**
     * 有效时间
     */
    private Long expires_in;

}
