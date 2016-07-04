#--更新时间字段
update t_base_region set createTime = date_format(now(),'%Y%m%d%H%i%S'),updateTime=date_format(now(),'%Y%m%d%H%i%S');