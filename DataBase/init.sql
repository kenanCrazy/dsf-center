CREATE TABLE `s_sys_config` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `groups` varchar(50) NOT NULL,
  `keys` varchar(100) NOT NULL,
  `values` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_cp_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `siteCode` varchar(12) NOT NULL,
  `siteName` varchar(40) DEFAULT NULL,
  `schemaName` varchar(12) DEFAULT NULL,
  `isapi` tinyint(4) NOT NULL DEFAULT '1',
  `currency` varchar(4) NOT NULL DEFAULT 'RMB',
  `companyId` int(11) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `endDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `available` tinyint(4) NOT NULL DEFAULT '1',
  `useTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `memo` varchar(200) DEFAULT NULL,
  `createUser` varchar(16) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyUser` varchar(16) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `companyUser` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`,`siteCode`) USING BTREE,
  UNIQUE KEY `t_cp_site_schema_uindex` (`schemaName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_cp_siteurl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `siteId` int(11) NOT NULL,
  `siteCode` varchar(12) NOT NULL,
  `siteUrl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_api` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depotId` int(12) NOT NULL,
  `apiName` varchar(40) NOT NULL,
  `pcUrl` varchar(100) NOT NULL,
  `pcUrl2` varchar(100) DEFAULT NULL,
  `mbUrl` varchar(100) NOT NULL,
  `mbUrl2` varchar(100) DEFAULT NULL,
  `agyAcc` varchar(20) NOT NULL,
  `md5Key` varchar(32) NOT NULL,
  `secureCode` text,
  `webName` varchar(60) DEFAULT NULL,
  `proxyFore` varchar(20) NOT NULL,
  `sortId` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `available` tinyint(4) NOT NULL,
  `createUser` varchar(16) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyUser` varchar(16) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `defApi` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_gm_api_name` (`apiName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_api_prefix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apiId` int(12) NOT NULL,
  `prefix` varchar(40) NOT NULL,
  `siteId` int(11) DEFAULT NULL,
  `available` tinyint(4) NOT NULL,
  `createUser` varchar(255) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifyUser` varchar(255) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(40) NOT NULL,
  `sortId` int(11) NOT NULL,
  `available` tinyint(4) NOT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `createUser` varchar(16) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyUser` varchar(16) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `parentId` int(11) NOT NULL,
  `treeId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_t_gm_depotcatName` (`catName`) USING BTREE,
  UNIQUE KEY `index_t_gm_depottreeId` (`treeId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_depot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depotName` varchar(40) NOT NULL,
  `depotCode` varchar(255) DEFAULT NULL,
  `available` tinyint(4) NOT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `createUser` varchar(16) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyUser` varchar(16) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `sortId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_t_gm_depot_depotName` (`depotName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_depot_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depotId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_gm_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catId` int(11) NOT NULL,
  `depotId` int(11) NOT NULL,
  `depotName` varchar(45) DEFAULT NULL,
  `gameCode` varchar(100) DEFAULT NULL,
  `gameName` varchar(40) NOT NULL,
  `gameTag` varchar(100) DEFAULT NULL,
  `gameParam` varchar(200) DEFAULT NULL,
  `available` tinyint(4) DEFAULT '0',
  `PcLogo` varchar(100) DEFAULT NULL,
  `PhoneLogo` varchar(100) DEFAULT NULL,
  `enablePc` tinyint(4) DEFAULT '1',
  `enableMb` tinyint(4) DEFAULT '1',
  `enableTest` tinyint(4) DEFAULT '0',
  `enableHot` tinyint(4) DEFAULT NULL,
  `ebableNew` tinyint(4) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `createUser` varchar(16) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyUser` varchar(16) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gameNameEn` varchar(40) DEFAULT NULL,
  `gameId` varchar(20) DEFAULT NULL,
  `lastdayPer` int(11) DEFAULT '0',
  `sortId` int(11) NOT NULL DEFAULT '0',
  `clickNum` int(11) NOT NULL DEFAULT '0',
  `goodNum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `t_schema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schemaName` varchar(12) NOT NULL,
  `simpleName` varchar(4) DEFAULT NULL,
  `isUsed` tinyint(4) NOT NULL DEFAULT '0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `siteCode` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `transfer_log` (
  `transaction_id` varchar(64) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `siteCode` varchar(12) NOT NULL,
  `dsf_player_id` varchar(64) NOT NULL,
  `game_platform` varchar(20) NOT NULL,
  `state` varchar(100) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_time` datetime DEFAULT NULL,
  `version` int(20) NOT NULL DEFAULT '1',
  `type` varchar(20) NOT NULL,
  `username` varchar(64) NOT NULL,
  `amount` double(10,2) NOT NULL,
  `balance_changed_id` bigint(20) DEFAULT NULL,
  `agent_id` bigint(20) NOT NULL,
  `operator_id` bigint(20) DEFAULT NULL,
  `operator_username` varchar(64) DEFAULT NULL,
  `fail_reason` varchar(64) DEFAULT NULL,
  `dsf_transaction_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`) USING BTREE,
  KEY `combo1` (`create_time`,`type`,`username`) USING BTREE,
  KEY `combo2` (`create_time`,`game_platform`,`username`,`type`) USING BTREE,
  KEY `combo5` (`create_time`,`siteCode`),
  KEY `combo3` (`create_time`),
  KEY `combo6` (`game_platform`,`username`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;