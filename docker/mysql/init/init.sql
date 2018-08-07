
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` bigint(20),
  `use_yn` char NOT NULL DEFAULT 'Y' comment 'Y,N',
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
  `use_yn` char NOT NULL comment 'Y,N',
  PRIMARY KEY (`id`),
  KEY `memu_parent` (`parent`) USING BTREE,
  CONSTRAINT `memu_parent` FOREIGN KEY (`parent`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `use_yn` char NOT NULL DEFAULT 'Y' comment 'Y,N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_menu` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  `use_yn` char NOT NULL DEFAULT 'Y' comment 'Y,N',
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `role_foreign_key` (`role_id`) USING BTREE,
  CONSTRAINT `role_foreign_key` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  KEY `memu_foreign_key` (`menu_id`) USING BTREE,
  CONSTRAINT `memu_foreign_key` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `I18N` (
  `CODE` varchar(32) not null,
  `LOCALE` varchar(6) not null,
  `TYPE` varchar(6) null,
  `TEXT` text null,
  `USE_YN` char NOT NULL DEFAULT 'Y' comment 'Y,N',
  `CREATED_DATE` timestamp default CURRENT_TIMESTAMP not null,
  `MODIFIED_DATE` timestamp default CURRENT_TIMESTAMP not null,
  PRIMARY KEY (`CODE`, `LOCALE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `I18N_REFER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LOCALE` varchar(6) not null,
  `TABLE` varchar(30) not null,
  `TEXT` text null,
  `USE_YN` char NOT NULL DEFAULT 'Y' comment 'Y,N',
  `CREATED_DATE` timestamp default CURRENT_TIMESTAMP not null,
  `MODIFIED_DATE` timestamp default CURRENT_TIMESTAMP not null,
  primary key (`ID`, `LOCALE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `POST` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE_REFER_ID` bigint(20) NOT NULL,
  `CONTENT_REFER_ID` bigint(20) NOT NULL,
  `USE_YN` char NOT NULL DEFAULT 'Y' comment 'Y,N',
  `CREATED_DATE` timestamp default CURRENT_TIMESTAMP not null,
  `MODIFIED_DATE` timestamp default CURRENT_TIMESTAMP not null,
  primary key (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into user(name, username, password) values('admin', 'admin', 'password');


INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu', null, 1, 0, null, 'category', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu1', '', 1, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu2', '', 2, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu3', '', 3, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu4', '', 4, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu5', '', 5, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu6', '', 6, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu7', '', 7, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu8', '', 8, 1, 1, 'category', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu9', '', 9, 1, 1, 'category', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu11', '/board/menu11', 1, 3, 2, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu12', '/board/menu12', 2, 3, 2, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu13', '/board/menu13', 3, 3, 2, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu21', '/board/menu21', 1, 3, 3, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu22', '/board/menu22', 2, 3, 3, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu23', '/board/menu23', 3, 3, 3, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu31', '/board/menu31', 1, 3, 4, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu32', '/board/menu32', 2, 3, 4, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu33', '/board/menu33', 3, 3, 4, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu41', '/board/menu41', 1, 3, 5, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu42', '/board/menu42', 2, 3, 5, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu43', '/board/menu43', 3, 3, 5, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu51', '/board/menu51', 1, 3, 6, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu52', '/board/menu52', 2, 3, 6, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu53', '/board/menu53', 3, 3, 6, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu61', '/board/menu61', 1, 3, 7, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu62', '/board/menu62', 2, 3, 7, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu63', '/board/menu63', 3, 3, 7, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu71', '/board/menu71', 1, 3, 8, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu72', '/board/menu72', 2, 3, 8, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu74', '/board/menu74', 3, 3, 8, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu81', '/board/menu81', 1, 3, 9, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu82', '/board/menu82', 2, 3, 9, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu83', '/board/menu83', 3, 3, 9, 'menu', 'Y');

INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu91', '/board/menu91', 1, 3, 10, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu92', '/board/menu92', 2, 3, 10, 'menu', 'Y');
INSERT INTO menu (name, url, `order`, depth, parent, menu_type, use_yn) VALUES ('menu93', '/board/menu93', 3, 3, 10, 'menu', 'Y');


INSERT INTO I18N (CODE, LOCALE, TYPE, TEXT, USE_YN, CREATED_DATE, MODIFIED_DATE) VALUES ('I18N.CONTENT', 'en_US', 'label', 'Contents', 'Y', '2018-08-06 08:48:07', '2018-08-06 08:48:07');
INSERT INTO I18N (CODE, LOCALE, TYPE, TEXT, USE_YN, CREATED_DATE, MODIFIED_DATE) VALUES ('I18N.CONTENT', 'ko_KR', 'label', '내용', 'Y', '2018-08-06 08:47:12', '2018-08-06 08:47:12');
INSERT INTO I18N (CODE, LOCALE, TYPE, TEXT, USE_YN, CREATED_DATE, MODIFIED_DATE) VALUES ('I18N.TITLE', 'en_US', 'label', 'Titles', 'Y', '2018-08-06 08:50:04', '2018-08-06 08:50:04');
INSERT INTO I18N (CODE, LOCALE, TYPE, TEXT, USE_YN, CREATED_DATE, MODIFIED_DATE) VALUES ('I18N.TITLE', 'ko_KR', 'label', '제목', 'Y', '2018-08-06 08:50:04', '2018-08-06 08:50:04');


