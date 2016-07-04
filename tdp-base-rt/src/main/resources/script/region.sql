#--行政区
CREATE TABLE t_base_region(
	regCode varchar(6),
	regName varchar(50),
	parentCode varchar(6),
	regType int,
	regMark varchar(100),
	rank int,
	createTime varchar(14),
	updateTime varchar(14),
	PRIMARY KEY(regCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;