package com.yuxuan.wechat.models;

import lombok.Data;

import java.util.Map;

/**
 * 小程序模板消息
 *
 * @author zengyh
 * @date 2019/8/26
 */
@Data
public class AppletMessage {

    /**
     * 用户openid
     * required = true
     */
    private String touser;

    /**
     * 模板id
     * required = true
     */
    private String template_id;

    /**
     * 点击消息需要跳转的小程序页面
     * required = false
     */
    private String page;

    /**
     * 表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
     * required = true
     */
    private String form_id;

    /**
     * 模板内容，不填则下发空模板。具体格式请参考示例
     * required = false
     */
    private Map<String, Object> data;

    /**
     * 模板需要放大的关键词，不填则默认无放大
     * required = false
     */
    private String emphasis_keyword;
}
