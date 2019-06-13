package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信小程序加密字段解密后用户信息
 *
 * @author yuxuan
 * @date 2019/5/24
 */
@Data
public class DecryptedUserInfo implements Serializable{

    /**
     * 微信小程序加密字段解密后格式
     * {
     *  "openId":"ORXIJ5SO8zDPJocvxpUISASwssYU",
     *  "nickName":"许三多",
     *  "gender":1,
     *  "language":"zh_CN",
     *  "city":"Yuzhong",
     *  "province":"Chongqing",
     *  "country":"China",
     *  "avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJrKr2y85eicZfQLSstWzibhv4DdTWjqYHfiaqRq1uABW2152RAMRoeMn7S7DNF9ibfwAsleDxn2dicouA/132",
     *  "watermark":{
     *      "timestamp":1558712252,
     *      "appid":"wx8888888888888888"
     *      }
     * }
     */
    private String openId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户性别
     *  0未知 1男性 2女性
     */
    private String gender;
    /**
     * 显示 country，province，city 所用的语言
     * language 的合法值 en	英文  zh_CN	简体中文  zh_TW	繁体中文
     */
    private String language;
    /**
     * 用户所在城市
     */
    private String city;
    /**
     * 用户所在省份
     */
    private String province;
    /**
     * 用户所在国家
     */
    private String country;
    /**
     * 用户头像图片的 URL。
     * URL 最后一个数值代表正方形头像大小（有 0、46、64、96、132 数值可选，0 代表 640x640 的正方形头像，46 表示 46x46 的正方形头像，剩余数值以此类推。默认132），
     * 用户没有头像时该项为空。
     * 若用户更换头像，原有头像 URL 将失效。
     */
    private String avatarUrl;

    /**
     * 水印
     */
    private Watermark watermark;

    @Data
    class Watermark {
        /**
         * appid
         */
        private String appid;
        /**
         * 时间戳
         */
        private String timestamp;
    }
}
