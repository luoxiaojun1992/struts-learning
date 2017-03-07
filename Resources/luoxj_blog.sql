# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.17)
# Database: luoxj_blog
# Generation Time: 2017-03-07 07:47:38 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table article
# ------------------------------------------------------------

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '文章标题',
  `content` text NOT NULL COMMENT '文章内容',
  `publishAt` datetime NOT NULL COMMENT '发布时间',
  `updateAt` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;

INSERT INTO `article` (`id`, `title`, `content`, `publishAt`, `updateAt`)
VALUES
	(1,'article title','article content','2017-03-01 00:00:00','2017-03-01 00:00:00'),
	(2,'article title2','article content2','2017-03-02 00:00:00','2017-03-02 00:00:00'),
	(3,'监控报警系统搭建及二次开发经验','本次分享的内容是监控报警系统搭建，以及基于开源组件的二次开发。自从接受了公司监控报警系统二期开发需求以来，我们完成了监控数据的补全完善、报警系统搭建调试和报警规则配置界面的开发。下图是监控报警系统的架构图，除了业务数据收集器外，其余全部基于原生开源组件或二次开发完成，整个系统采用TICK(telegraf + influxdb + chronograf + kapacitor)架构，使用go语言实现。\n\n![输入图片说明](https://static.oschina.net/uploads/img/201612/11213313_QgXy.png \"在这里输入图片标题\")\n\n+ influxdb时间序列数据库\n\n[influxdb](https://github.com/influxdata/influxdb)数据库是一个时间序列数据库，他会为每行数据打上时间戳，即使数据被并发写入，也会按照时间先后顺序存储。同时它也是一个关系型数据库，可以通过sql语言进行增删改查，学习成本低。官方提供了一个简单实用的web界面，非常地人性化。在工程实践中，我们发现了它的一个坑，在大数据量查询时会crash，重启后才能恢复，这个问题仍待研究。不必担心的是，因为监控系统中不存在特别大数据量的查询，生产环境下influxdb的性能表现十分良好。\n\n+ telegraf数据收集器\n\n[telegraf](https://github.com/luoxiaojun1992/telegraf/tree/feature-angejia-monitor)是一个数据收集器，负责收集所有的原始数据，格式化后存入influxdb。telegraf内置了大量的数据输入、输出和分析插件，能够收集php-fpm、nginx、access log、mysql、redis等组件的监控数据。telegraf的扩展性很强，开源社区也十分活跃，来自世界各地的开发者们会源源不断地贡献新的插件。我们基于它的插件架构开发了redis queue input plugin和access log parser plugin，用于收集和分析Laravel框架队列和access log数据。\n\n+ collector业务数据收集器\n\n[collector](https://github.com/luoxiaojun1992/telegraf-collector/tree/feature-sql-watch)是整个系统中唯一自研的组件。由于业务监控数据查询规则复杂多变，我们开发了这个组件，用于从MySQL中查询业务数据，支持配置sql语句、收集频率、时间延迟等，并且按照influxdb的格式发送给telegraf数据收集器。\n\n+ kapacitor报警器\n\n[kapacitor](https://github.com/influxdata/kapacitor)是一个可以按照预先编写好的规则，实时地订阅influxdb数据或者批量查询数据，并进行报警(邮件、短信、日志、exec等方式)的工具。官方为它设计了一个tickscript语言，可以方便地编写规则脚本。我们的主要工作是tickscript的学习调试、报警规则的设计、报警周期(every字段)的调整和数据窗口(period字段)的调整。我们将报警脚本的修改重启、报警脚本运行状态的查询和influxdb数据订阅状态的查询等命令编写成了shell脚本，便于后期维护和自动化。\n\n+ grafana数据可视化界面\n\n![输入图片说明](https://static.oschina.net/uploads/img/201612/11224716_YAZP.png \"在这里输入图片标题\")\n\n[grafana](https://github.com/grafana/grafana)是一个数据可视化的组件，类似著名ELK架构中的kibana组件，支持多种数据源(influxdb、zabbix、elasticsearch等)，还有很多插件可供安装，在最新版本中加入了简单的alert、电视模式等新功能。特别需要分享的是某些监控数据是随时间不断累加的，在展示时要应用聚合函数(difference、max、min等)进行处理。同时还可以为单个图表配置超链接，增强交互性和可用性。还有很多有趣的功能，留待大家研究发现。\n\n+ chronograf可视化界面\n\n![输入图片说明](https://static.oschina.net/uploads/img/201612/11224830_5dt2.png \"在这里输入图片标题\")\n\n[chronograf](https://github.com/luoxiaojun1992/chronograf)是influxdata官方提供的一个数据可视化组件，可视化功能不如grafana强大，亮点是附带了kapacitor组件的web界面，可以方便地配置报警规则，自动生成并启用tickscript，还可以查询报警历史。我们对它进行了修改，美化了报警邮件的模板，增加了报警周期(every字段)和报警时间段的配置，让邮件内容更加友好，并且可以自由调整报警周期。\n\n综上，我们在TICK开源架构上，结合我们自身业务特点和需求，研发了一整套包含数据采集格式化、可视化监控、自动化报警功能的监控报警系统，今后还将不断调整优化，更好地为公司业务发展和技术研发团队服务。','2017-03-07 00:00:00','2017-03-07 00:00:00');

/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
