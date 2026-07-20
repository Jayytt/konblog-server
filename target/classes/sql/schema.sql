-- KonBlog Schema (MySQL 8+)
CREATE DATABASE IF NOT EXISTS kon_blog DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE kon_blog;
SET NAMES utf8mb4;

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(64) NOT NULL, nick_name VARCHAR(64), password VARCHAR(255) NOT NULL,
  email VARCHAR(128), phone_number VARCHAR(32), sex VARCHAR(4), avatar VARCHAR(255),
  status CHAR(1) DEFAULT '0', login_ip VARCHAR(64), login_date DATETIME,
  create_time DATETIME, update_time DATETIME, create_by BIGINT, update_by BIGINT, del_flag INT DEFAULT 0
) ENGINE=InnoDB;

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(64), role_key VARCHAR(64),
  status CHAR(1) DEFAULT '0', del_flag INT DEFAULT 0,
  create_time DATETIME, update_time DATETIME, create_by BIGINT, update_by BIGINT
) ENGINE=InnoDB;

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu (
  id BIGINT AUTO_INCREMENT PRIMARY KEY, menu_name VARCHAR(64), parent_id BIGINT DEFAULT 0,
  order_num INT DEFAULT 0, path VARCHAR(255), component VARCHAR(255),
  is_cache INT DEFAULT 0, visible INT DEFAULT 0, status CHAR(1) DEFAULT '0',
  perms VARCHAR(255), icon VARCHAR(128), menu_type CHAR(1), remark VARCHAR(255),
  create_time DATETIME, update_time DATETIME, create_by BIGINT, update_by BIGINT
) ENGINE=InnoDB;

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role (id BIGINT AUTO_INCREMENT PRIMARY KEY, user_id BIGINT NOT NULL, role_id BIGINT NOT NULL) ENGINE=InnoDB;

DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu (id BIGINT AUTO_INCREMENT PRIMARY KEY, role_id BIGINT NOT NULL, menu_id BIGINT NOT NULL) ENGINE=InnoDB;

DROP TABLE IF EXISTS sg_article;
CREATE TABLE sg_article (
  id BIGINT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(256), content LONGTEXT, summary VARCHAR(1024),
  category_id BIGINT, thumbnail VARCHAR(255), is_top CHAR(1) DEFAULT '0',
  status CHAR(1) DEFAULT '1', view_count BIGINT DEFAULT 0, is_comment CHAR(1) DEFAULT '1',
  create_by BIGINT, create_time DATETIME, update_by BIGINT, update_time DATETIME, del_flag INT DEFAULT 0
) ENGINE=InnoDB;

DROP TABLE IF EXISTS sg_article_tag;
CREATE TABLE sg_article_tag (id BIGINT AUTO_INCREMENT PRIMARY KEY, article_id BIGINT NOT NULL, tag_id BIGINT NOT NULL) ENGINE=InnoDB;

DROP TABLE IF EXISTS sg_category;
CREATE TABLE sg_category (
  id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(64), description VARCHAR(255),
  status CHAR(1) DEFAULT '0', del_flag INT DEFAULT 0,
  create_time DATETIME, update_time DATETIME, create_by BIGINT, update_by BIGINT
) ENGINE=InnoDB;

DROP TABLE IF EXISTS sg_tag;
CREATE TABLE sg_tag (
  id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(64), status CHAR(1) DEFAULT '0',
  create_time DATETIME, update_time DATETIME, create_by BIGINT, update_by BIGINT, del_flag INT DEFAULT 0
) ENGINE=InnoDB;

DROP TABLE IF EXISTS sg_comment;
CREATE TABLE sg_comment (
  id BIGINT AUTO_INCREMENT PRIMARY KEY, type VARCHAR(32), article_id BIGINT, root_id BIGINT,
  content TEXT, to_comment_user_id BIGINT, to_comment_id BIGINT,
  create_by BIGINT, create_time DATETIME, update_by BIGINT, update_time DATETIME, del_flag INT DEFAULT 0
) ENGINE=InnoDB;

DROP TABLE IF EXISTS sg_link;
CREATE TABLE sg_link (
  id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(64), logo VARCHAR(255), description VARCHAR(255),
  address VARCHAR(255), status CHAR(1) DEFAULT '0', create_time DATETIME, update_time DATETIME,
  create_by BIGINT, update_by BIGINT, del_flag INT DEFAULT 0
) ENGINE=InnoDB;