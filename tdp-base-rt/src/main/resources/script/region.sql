#--行政区
CREATE TABLE t_base_region(
	regCode varchar(6),
	regName varchar(50),
	parentCode varchar(6),
	regType int,
	regMark varchar(100),
	rank int,
	isEnable tinyint(4) DEFAULT '1' COMMENT '数据是否有效,1=true,0=false',
	createTime datetime default null,
	updateTime datetime default null,
	PRIMARY KEY(regCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
