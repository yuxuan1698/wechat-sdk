package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zengyh
 * @date 2019/8/28
 */
@Data
public class WechatMessageResult implements Serializable {
    /**
     * {
     *  "errcode":0,
     *  "errmsg":"ok",
     *  "msgid":200228332
     * }
     */
    private String errcode;

    private String errmsg;

    private String msgid;
}
