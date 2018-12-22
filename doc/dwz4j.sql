/*
SQLyog Ultimate v9.30 
MySQL - 5.0.51b-community-nt-log : Database - dwz4j
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*Table structure for table `res_book` */

DROP TABLE IF EXISTS `res_book`;

CREATE TABLE `res_book` (
  `ID` int(10) unsigned NOT NULL auto_increment COMMENT '书目',
  `SN` varchar(30) default NULL COMMENT '编号',
  `NAME_CN` varchar(100) default NULL COMMENT '中文书目',
  `NAME_EN` varchar(100) default NULL COMMENT '英文书目',
  `PUBLISH` varchar(100) default NULL COMMENT '出版社',
  `PUBLISH_DATE` date default NULL COMMENT '出版日期',
  `INSERT_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `res_chapter` */

DROP TABLE IF EXISTS `res_chapter`;

CREATE TABLE `res_chapter` (
  `ID` int(10) unsigned NOT NULL auto_increment COMMENT '篇目章节',
  `BOOK_ID` int(10) unsigned default NULL COMMENT '书目ID',
  `AUTHOR_ID` int(10) unsigned default NULL COMMENT '作者ID',
  `TRANSLATOR` varchar(50) default NULL COMMENT '译者',
  `CHAPTER_NO` int(6) unsigned default NULL COMMENT '篇号',
  `NAME_CN` varchar(100) default NULL COMMENT '中文篇名',
  `NAME_EN` varchar(100) default NULL COMMENT '英文篇名',
  `SUMMARY` varchar(500) default NULL COMMENT '摘要',
  `PATH` varchar(255) default NULL COMMENT 'PDF路径',
  `KEYWORDS` varchar(200) default NULL COMMENT '关键词',
  `CONTENT` longtext COMMENT 'PDF文字内容',
  `INIT_CONTENT` tinyint(1) NOT NULL default '0' COMMENT '是否已抓取PDF文字内容',
  `START_PAGE_NO` int(10) unsigned default NULL COMMENT '起始页',
  `PAGE_COUNT` int(11) default NULL COMMENT '总页数',
  `INSERT_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`ID`),
  KEY `FK_res_chapter` (`BOOK_ID`),
  CONSTRAINT `FK_res_chapter` FOREIGN KEY (`BOOK_ID`) REFERENCES `res_book` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_baseinfo` (
   `uuid` varchar(150) DEFAULT NULL,
   `no` varchar(60) DEFAULT NULL,
   `name` varchar(90) DEFAULT NULL,
   `sex` double DEFAULT NULL,
   `age` double DEFAULT NULL,
   `birthday` date DEFAULT NULL,
   `deptno` varchar(60) DEFAULT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8

 insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0001','10001','宋文华','1','25','1978-01-03','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0002','10002','周燕','1','38','1978-12-21','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0003','10003','周红','1','45','1968-05-23','0003');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0004','10004','胡智波','1','35','1963-08-12','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0005','10005','胡秀青','1','36','1965-06-11','0002');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0006','10006','涂琦英','0','56','1959-05-03','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0007','10007','宋节斌','1','45','1957-11-05','0002');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0008','10008','周英龙','1','26','1980-10-09','0003');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0009','10009','吴树青','1','32','1983-11-15','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0010','10010','范新华','1','36','1983-08-17','0012');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0011','10011','吴国发','1','26','1980-07-19','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0012','10012','吴志枫','1','43','1978-08-13','0002');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0013','10013','范坚琴','0','28','1977-03-03','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0014','10014','周勇伟','1','36','1978-07-05','0005');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0015','10015','周节华','1','46','1976-05-17','0009');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0016','10016','范员波','1','35','1978-07-16','0009');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0017','10017','胡冬琴','0','56','1980-06-15','0005');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0018','10018','周红','0','28','1980-08-21','0007');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0019','10019','吴志清','1','37','1968-07-27','0004');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0020','10020','吴志国','1','38','1987-08-29','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0021','10021','吴清珊','0','28','1969-06-25','0009');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0022','10022','王志尖','1','36','1980-07-26','0012');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0023','10023','吴良光','1','28','1986-03-25','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0024','10024','胡玟乐','1','37','1976-03-21','0004');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0025','10025','洪亮亮','1','46','1978-04-23','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0026','10026','付瑞明','1','45','1966-06-12','0006');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0027','10027','胡志莹','0','29','1985-07-11','0010');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0028','10028','高洪波','1','34','1975-03-10','0008');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0029','10029','刘铭署','1','38','1973-07-15','0006');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0030','10030','胡婷','0','36','1976-11-03','0010');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0031','10031','吴建中','1','39','1988-12-15','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0032','10032','吴志诚','1','26','1986-04-19','0007');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0033','10033','苏伟官','1','28','1963-10-26','0007');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0034','10034','吴圆蛾','0','29','1968-08-27','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0035','10035','吴芝红','0','23','1965-01-21','0002');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0036','10036','万兴国','1','27','1958-11-20','0011');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0037','10037','范贵红','0','45','1980-10-23','0001');
insert into `tbl_baseinfo` (`uuid`, `no`, `name`, `sex`, `age`, `birthday`, `deptno`) values('8a9f8189297d71b001297d71b01a0038','10038','宋国珍','0','36','1982-06-13','0008');


CREATE TABLE `tbl_department` (
   `guid` varchar(150) DEFAULT NULL,
   `deptno` varchar(60) DEFAULT NULL,
   `deptname` varchar(90) DEFAULT NULL,
   `manager` varchar(90) DEFAULT NULL,
   `builtdate` date DEFAULT NULL,
   `performance` varchar(60) DEFAULT NULL,
   `description` blob
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
