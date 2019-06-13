package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信网页授权Token
 *
 * @author yuxuan
 * @date 2018/5/8
 */
@Data
public class AccessToken implements Serializable{
    //微信响应示例
    //    { "access_token":"ACCESS_TOKEN",
    //      "expires_in":7200,
    //      "refresh_token":"REFRESH_TOKEN",
    //      "openid":"OPENID",
    //      "scope":"SCOPE" }

    private String errcode;

    private String errmsg;

    private String access_token;

    private Long expires_in;

    private String refresh_token;

    private String openid;

    private String scope;
}
