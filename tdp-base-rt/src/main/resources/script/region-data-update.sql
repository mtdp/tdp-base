#--更新时间字段
update t_base_region set createTime = now(),updateTime=now();
update t_base_region set isEnable=1;