package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信小程序加密字段解密后手机信息
 *
 * @author yuxuan
 * @date 2018/5/24
 */
@Data
public class DecryptedPhone implements Serializable {

    /**
     * 微信小程序加密字段解密后格式
     * {"phoneNumber":"15000000001","watermark":{"appid":"wx8888888888888888","timestamp":1527148981},"purePhoneNumber":"15000000001","countryCode":"86"}
     */
    /**
     * 用户绑定的手机号（国外手机号会有区号）
     */
    private String phoneNumber;
    /**
     * 没有区号的手机号
     */
    private String purePhoneNumber;
    /**
     * 区号
     */
    private String countryCode;
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
