create table t_base_captcha(
	captchaId int auto_increment,
	captchaCode varchar(128),
	status tinyint comment '10=未使用,20=已使用',
	expireTime datetime comment '过期时间',
	updateTime datetime null default null,
	createTime datetime null default null,
	primary key(captchaId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;