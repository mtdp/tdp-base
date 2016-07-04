package com.github.mtdp.base.region.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.mtdp.base.region.dao.domain.Region;
import com.github.mtdp.persistence.BaseMapper;

/**
 * 
 *
 * @Description 地区dao
 * @author wangguoqing
 * @date 2016年6月24日下午2:46:16
 *
 */
public interface IRegionMapper<T extends Region> extends BaseMapper<T> {
	
	/**
	 * 通过地区类型查询地区信息
	 * @param regType
	 * 0-国家、1-区域、2-省、3-市、4-县
	 * @return
	 */
	public List<Region> getByRegType(@Param("regType")String regType);
	
	public List<Region> getByParentCode(@Param("parentCode")String parentCode);

}
