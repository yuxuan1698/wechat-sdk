package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 微信网页授权用户信息
 * @author yuxuan
 * @date 2018/5/8
 */
@Data
public class UserInfo implements Serializable{
    //微信响应示例
    //    {   "openid":" OPENID",
    //        "nickname": NICKNAME,
    //        "sex":"1",
    //        "province":"PROVINCE"
    //        "city":"CITY",
    //        "country":"COUNTRY",
    //        "headimgurl":    "http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
    //        "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
    //        "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
    //    }

    private String errcode;
    private String errmsg;

    private String openid;
    private String nickname;
    private String sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private List<String> privilege;
    private String unionid;

}
