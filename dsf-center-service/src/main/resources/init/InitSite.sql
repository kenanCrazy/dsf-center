
create database `dsf_center_{{siteCode}}` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use `dsf_center_{{siteCode}}`

CREATE TABLE `t_sys_config` (
  `id`  int(11) unsigned NOT NULL AUTO_INCREMENT,
  `groups` varchar(50) NOT NULL,
  `keys` varchar(100) NOT NULL,
  `values` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_site` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `site_code` varchar(12) NOT NULL,
  `site_name` varchar(40) DEFAULT NULL,
  `schema_name` varchar(25) DEFAULT NULL,
  `is_api` tinyint(4) NOT NULL DEFAULT '1',
  `currency` varchar(4) NOT NULL DEFAULT 'RMB',
  `company_id` int(11) DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `available` tinyint(4) NOT NULL DEFAULT '1',
  `use_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `memo` varchar(200) DEFAULT NULL,
  `create_user` varchar(16) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_user` varchar(16) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `company_user` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`,`site_code`) USING BTREE,
  UNIQUE KEY `t_site_schema_uindex` (`schema_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_site_url` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `site_code` varchar(12) NOT NULL,
  `site_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_api` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `depot_id` int(12) NOT NULL,
  `api_name` varchar(40) NOT NULL,
  `pc_url` varchar(100) NOT NULL,
  `pc_url2` varchar(100) DEFAULT NULL,
  `mb_url` varchar(100) NOT NULL,
  `mb_url2` varchar(100) DEFAULT NULL,
  `agy_acc` varchar(20) NOT NULL,
  `md5_key` varchar(32) NOT NULL,
  `secure_code` text,
  `web_name` varchar(60) DEFAULT NULL,
  `proxy_fore` varchar(20) NOT NULL,
  `sort_id` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `available` tinyint(4) NOT NULL,
  `create_user` varchar(16) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_user` varchar(16) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `def_api` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_gm_api_name` (`api_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_api_prefix` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `api_id` int(12) NOT NULL,
  `prefix` varchar(40) NOT NULL,
  `siteid` int(11) DEFAULT NULL,
  `available` tinyint(4) NOT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modify_user` varchar(255) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(40) NOT NULL,
  `sort_id` int(11) NOT NULL,
  `available` tinyint(4) NOT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `create_user` varchar(16) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_user` varchar(16) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `parent_id` int(11) NOT NULL,
  `tree_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_t_gm_depotcat_name` (`category_name`) USING BTREE,
  UNIQUE KEY `index_t_gm_depot_tree_id` (`tree_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_depot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `depot_name` varchar(40) NOT NULL,
  `depot_code` varchar(255) DEFAULT NULL,
  `available` tinyint(4) NOT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `create_user` varchar(16) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_user` varchar(16) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `sort_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_t_gm_depot_depot_name` (`depot_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_depot_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `depot_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_game` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `depot_id` int(11) NOT NULL,
  `depot_name` varchar(45) DEFAULT NULL,
  `game_code` varchar(100) DEFAULT NULL,
  `h5_game_code` varchar(100) DEFAULT NULL,
  `adriod_game_code` varchar(100) DEFAULT NULL,
  `pc_game_code` varchar(100) DEFAULT NULL,
  `game_name` varchar(40) NOT NULL,
  `game_tag` varchar(100) DEFAULT NULL,
  `game_param` varchar(200) DEFAULT NULL,
  `available` tinyint(4) DEFAULT '0',
  `pc_logo` varchar(100) DEFAULT NULL,
  `phone_logo` varchar(100) DEFAULT NULL,
  `enable_pc` tinyint(4) DEFAULT '1',
  `enable_Mobile` tinyint(4) DEFAULT '1',
  `enable_test` tinyint(4) DEFAULT '0',
  `enable_hot` tinyint(4) DEFAULT NULL,
  `ebable_new` tinyint(4) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `create_user` varchar(16) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_user` varchar(16) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `game_name_en` varchar(40) DEFAULT NULL,
  `game_id` varchar(20) DEFAULT NULL,
  `lastday_per` int(11) DEFAULT '0',
  `sort_id` int(11) NOT NULL DEFAULT '0',
  `click_num` int(11) NOT NULL DEFAULT '0',
  `good_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_schema` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `schema_name` varchar(25) NOT NULL,
  `simple_name` varchar(4) DEFAULT NULL,
  `is_used` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `site_code` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `transfer_log` (
  `transaction_id` varchar(64) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `site_code` varchar(12) NOT NULL,
  `dsf_player_id` varchar(64) NOT NULL,
  `game_platform` varchar(20) NOT NULL,
  `state` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_time` datetime DEFAULT NULL,
  `version` int(20) NOT NULL DEFAULT '1',
  `type` varchar(20) NOT NULL,
  `nickname` varchar(64) NOT NULL,
  `amount` double(10,2) NOT NULL,
  `balance_changed_id` bigint(20) DEFAULT NULL,
  `operator_id` bigint(20) DEFAULT NULL,
  `operator_username` varchar(64) DEFAULT NULL,
  `fail_reason` varchar(64) DEFAULT NULL,
  `dsf_transaction_id` varchar(128) NOT NULL,
  `api_name` varchar(40) NOT NULL,
  PRIMARY KEY (`transaction_id`) USING BTREE,
  KEY `combo1` (`create_time`,`type`,`dsf_player_id`) USING BTREE,
  KEY `combo2` (`create_time`,`game_platform`,`dsf_player_id`,`type`) USING BTREE,
  KEY `combo5` (`create_time`,`site_code`),
  KEY `combo4` (`create_time`),
  KEY `combo3` (`api_name`),
  KEY `combo6` (`game_platform`,`dsf_player_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



CREATE TABLE `dsf_statements_player_day_{{month}}` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) NOT NULL,
  `site_code` varchar(20) NOT NULL COMMENT '站点',
  `game_platform` varchar(20) NOT NULL COMMENT '游戏平台',
  `day` datetime NOT NULL COMMENT '日期',
  `total_bet` decimal(10,2) NOT NULL COMMENT '总投注',
  `bet_count` bigint(11) NOT NULL COMMENT '注单量',
  `total_win` decimal(10,2) NOT NULL COMMENT '总赢得',
  `total_notsettled` decimal(10,2) unsigned zerofill DEFAULT '00000000.00' COMMENT '未结算(只有日报表有数据)',
  `dsf_player_id` varchar(20) NOT NULL COMMENT '第三方玩家Id',
  `nickname` varchar(64) NOT NULL COMMENT '玩家名称',
  `category_name` varchar(40) NOT NULL COMMENT '游戏类型',
  `result` decimal(10,2) NOT NULL COMMENT '总输赢',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rebate_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '返水',
  `total_member_exposure` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '玩家实际投注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `player_day_uion` (`game_platform`,`day`,`player_id`,`category_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


CREATE TABLE `dsf_statements_month` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `site_code` varchar(20) NOT NULL COMMENT '站点',
  `game_platform` varchar(20) NOT NULL COMMENT '游戏平台',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  `total_bet` decimal(10,2) NOT NULL COMMENT '总收入',
  `bet_count` bigint(11) NOT NULL COMMENT '注单量',
  `total_win` decimal(10,2) NOT NULL COMMENT '总赢得',
  `player_result` decimal(10,2) NOT NULL COMMENT '输赢后结果',
  `mon` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `platform_frand` (`site_code`,`game_platform`,`mon`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


