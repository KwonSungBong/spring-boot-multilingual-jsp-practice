
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` bigint(20),
  `use_yn` char NOT NULL DEFAULT 'y' comment 'Y : 사용	,N : 미사용',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255),
  `order` smallint(6) NOT NULL DEFAULT 0,
  `depth` smallint(20) NOT NULL DEFAULT 0,
  `parent` bigint(20),
  `menu_type` varchar(255) NOT NULL DEFAULT 'menu',
  `use_yn` char NOT NULL comment 'Y : 사용,	N : 미사용',
  PRIMARY KEY (`id`),
  KEY `memu_parent` (`parent`) USING BTREE,
  CONSTRAINT `memu_parent` FOREIGN KEY (`parent`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `use_yn` char NOT NULL DEFAULT 'y' comment 'Y : 사용,	N : 미사용',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_menu` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  `use_yn` char NOT NULL DEFAULT 'y' comment 'Y : 사용,	N : 미사용',
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `role_foreign_key` (`role_id`) USING BTREE,
  CONSTRAINT `role_foreign_key` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  KEY `memu_foreign_key` (`menu_id`) USING BTREE,
  CONSTRAINT `memu_foreign_key` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user(name, username, password) values('admin', 'admin', 'password');


