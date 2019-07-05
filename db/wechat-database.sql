CREATE TABLE `wechat_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(30) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '原始ID',
  `scene` varchar(30) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '场景：wechat 公众号，applet 小程序',
  `name` varchar(100) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '名称',
  `appid` varchar(30) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'appid',
  `secret` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '开发密钥',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='微信公众号|小程序配置';

CREATE TABLE `wechat_oauth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `appid` varchar(128) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'appid',
  `grant_code` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '网页授权回调的code',
  `grant_type` varchar(128) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '授权类型:authorization_code',
  `access_token` varchar(128) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '网页授权接口调用凭证',
  `expires_in` bigint(30) NOT NULL DEFAULT '0' COMMENT '接口调用凭证超时时间',
  `refresh_token` varchar(128) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户刷新access_token',
  `openid` varchar(128) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `scope` varchar(30) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户授权的作用域',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='微信公众号网页授权';

CREATE TABLE `wechat_phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `scene` varchar(64) NOT NULL DEFAULT '' COMMENT '场景：公众号 | 小程序',
  `appid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'appid',
  `openid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户的唯一标识',
  `unionid` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '用户在开放平台的唯一标识符',
  `phone_number` varchar(64) NOT NULL DEFAULT '' COMMENT '用户绑定的手机号（国外手机号会有区号）',
  `pure_phone_number` varchar(64) NOT NULL DEFAULT '' COMMENT '没有区号的手机号',
  `country_code` varchar(64) NOT NULL DEFAULT '' COMMENT '区号',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='微信公众号|小程序统一信息';

CREATE TABLE `wechat_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `appid` varchar(64) NOT NULL DEFAULT '' COMMENT 'appid',
  `js_code` varchar(64) NOT NULL DEFAULT '' COMMENT '登录获取的code',
  `grant_type` varchar(64) NOT NULL DEFAULT '' COMMENT '授权类型: authorization_code',
  `openid` varchar(64) NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `session_key` varchar(64) NOT NULL DEFAULT '' COMMENT '会话密钥',
  `unionid` varchar(64) DEFAULT NULL COMMENT '用户在开放平台的唯一标识符',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='微信小程序会话';

CREATE TABLE `wechat_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `appid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'appid',
  `type` varchar(64) NOT NULL DEFAULT '' COMMENT '类型: jsapi',
  `jsapi_ticket` varchar(512) CHARACTER SET ascii COLLATE ascii_bin NOT NULL DEFAULT '' COMMENT '公众号JS接口临时票据',
  `expires_at` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '过期时间',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公众号JS接口临时票据';

CREATE TABLE `wechat_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `appid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'appid',
  `grant_type` varchar(64) NOT NULL DEFAULT '' COMMENT '授权类型：client_credential',
  `access_token` varchar(512) CHARACTER SET ascii COLLATE ascii_bin NOT NULL COMMENT '接口调用凭据',
  `expires_at` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '过期时间',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='微信公众号|小程序接口调用凭据';

CREATE TABLE `wechat_union` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `scene` varchar(64) NOT NULL DEFAULT '' COMMENT '场景：公众号 | 小程序',
  `appid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'appid',
  `openid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户的唯一标识',
  `unionid` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '用户在开放平台的唯一标识符',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='微信公众号|小程序统一信息';

CREATE TABLE `wechat_userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `scene` varchar(64) NOT NULL DEFAULT '' COMMENT '场景：公众号 | 小程序',
  `appid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'appid',
  `openid` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '用户的唯一标识',
  `unionid` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '用户在开放平台的唯一标识符',
  `nick_name` varchar(64) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `gender` char(1) CHARACTER SET utf8mb4 NOT NULL DEFAULT '0' COMMENT '性别：1男性，2女性，0未知',
  `avatar_url` varchar(512) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '头像',
  `province` varchar(64) CHARACTER SET utf8mb4 NOT NULL COMMENT '省份',
  `city` varchar(64) CHARACTER SET utf8mb4 NOT NULL COMMENT '城市',
  `country` varchar(64) NOT NULL COMMENT '国家',
  `privilege` varchar(255) NOT NULL DEFAULT '' COMMENT '用户特权信息，json 数组',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='微信公众号|小程序用户信息';