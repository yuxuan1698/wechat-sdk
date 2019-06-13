package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * JSApi签名
 *
 * @author yuxuan
 * @date 2019/5/22
 */
@Data
public class JsApiSignature implements Serializable {
    private String appId;

    private String nonceStr;

    private long timestamp;

    private String signature;
}
