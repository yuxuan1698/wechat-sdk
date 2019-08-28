package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zengyh
 * @date 2019/8/28
 */
@Data
public class BaseResult implements Serializable{
    /**
     * number	错误码
     */
    private String errcode;
    /**
     * string	错误信息
     */
    private String errmsg;
}
