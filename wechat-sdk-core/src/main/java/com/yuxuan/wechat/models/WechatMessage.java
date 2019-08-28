package com.yuxuan.wechat.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zengyh
 * @date 2019/8/28
 */
@Data
public class WechatMessage implements Serializable {
    /**
     * 接收者openid
     * required = true
     */
    private String touser;

    /**
     * 模板ID
     * required = true
     */
    private String template_id;

    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     * required = false
     */
    private String url;

    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     * required = false
     */
    private Miniprogram miniprogram;

    /**
     * 模板数据
     * required = true
     */
    private Map<String, Object> data;

    @Data
    @AllArgsConstructor
    public static class Miniprogram {
        /**
         * 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
         * required = true
         */
        String appid;
        /**
         * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
         * required = false
         */
        String pagepath;
    }
}
