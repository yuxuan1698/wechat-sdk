package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 小程序session
 *
 * @author yuxuan
 * @date 2019/5/22
 */
@Data
public class CodeSession implements Serializable{
    private String openid;
    private String session_key;
    private String unionid;

    private String errcode;
    private String errmsg;
}
