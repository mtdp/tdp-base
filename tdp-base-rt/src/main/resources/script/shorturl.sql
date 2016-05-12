#--timestamp mysql5.5,5.6 如果不设置null默认是not null 且把第一个字段默认值设置成当前时间(CURRENT_TIMESTAMP ) 5.6.6后修改
create table t_base_short_url(
	shortURLId int auto_increment,
	shortURLName varchar(64) comment '短连接名称',
	shortCode varchar(256) comment '短连接code',
	originalURL varchar(1024) comment '原连接',
	validVisitTimes tinyint comment '可以访问的次数,空没有限制',
	visitedTimes tinyint default 0 comment '已经访问的次数默认值是0',
	startValidTime timestamp null default null comment '生效时间',
	endValidTime timestamp null default null comment '过期时间,空没有过期时间',
	updateTime timestamp null default null,
	createTime timestamp null default null,
	primary key(shortURLId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;