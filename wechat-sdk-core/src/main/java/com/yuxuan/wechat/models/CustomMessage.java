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
public class CustomMessage implements Serializable {
    /**
     * ������openid
     * required = true
     */
    private String touser;

    /**
     * ģ��ID
     * required = true
     */
    private String template_id;

    /**
     * ģ����ת���ӣ������ʺ�û����ת������
     * required = false
     */
    private String url;

    /**
     * ��С�����������ݣ�������С����ɲ��ô�������
     * required = false
     */
    private Miniprogram miniprogram;

    /**
     * ģ������
     * required = true
     */
    private Map<String, Object> data;

    @Data
    @AllArgsConstructor
    public static class Miniprogram {
        /**
         * ������ת����С����appid����С����appid�����뷢ģ����Ϣ�Ĺ��ں��ǰ󶨹�����ϵ���ݲ�֧��С��Ϸ��
         * required = true
         */
        String appid;
        /**
         * ������ת��С����ľ���ҳ��·����֧�ִ�����,��ʾ��index?foo=bar����Ҫ���С�����ѷ������ݲ�֧��С��Ϸ
         * required = false
         */
        String pagepath;
    }
}
