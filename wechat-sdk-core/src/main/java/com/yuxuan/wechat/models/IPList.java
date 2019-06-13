package com.yuxuan.wechat.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 微信ip列表
 * @author yuxuan
 * @date 2018/5/16
 */
@Data
public class IPList implements Serializable{

    /**
     * ip列表
     */
    private List<String> ip_list;
}
