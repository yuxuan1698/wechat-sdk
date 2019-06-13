package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 公众号|小程序 access_token
 */
@Data
public class Token implements Serializable{

	private String errcode;

	private String errmsg;

	// 接口访问凭证
	private String access_token;

	// 凭证有效期，单位：秒
	private int expires_in;

}
