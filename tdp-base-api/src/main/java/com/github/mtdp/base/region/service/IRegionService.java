/**
 *
 * @Description 地区服务
 * @author wangguoqing
 * @date 2016年6月24日下午3:16:19
 *
 */
package com.github.mtdp.base.region.service;

import java.util.List;

import com.github.mtdp.base.region.bean.RegionBean;

public interface IRegionService{
	
	/**
	 * 获取所有的片区数据:东北区、华北区、华东区、华中区、华南区、华西区、西北区
	 * @return
	 */
	public List<RegionBean> getAllArea();
	
	/**
	 * 获取所有省份
	 * @return
	 */
	public List<RegionBean> getAllProvince();
	
	/**
	 * 获取所有城市
	 * @return
	 */
	public List<RegionBean> getAllCity();
	
	/**
	 * 通过parentCode获取数据
	 * @param parentCode
	 * @return
	 */
	public List<RegionBean> getRegionByParentCode(String parentCode);
	
	
}