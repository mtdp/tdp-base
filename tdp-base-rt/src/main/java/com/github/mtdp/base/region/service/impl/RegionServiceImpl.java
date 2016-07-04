package com.github.mtdp.base.region.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mtdp.base.bean.BaseServiceConstantsCode;
import com.github.mtdp.base.region.bean.RegionBean;
import com.github.mtdp.base.region.dao.IRegionMapper;
import com.github.mtdp.base.region.dao.domain.Region;
import com.github.mtdp.base.region.service.IRegionService;

/**
 *
 * @Description 地区服务
 * @author wangguoqing
 * @date 2016年6月24日下午3:15:56
 *
 */
@Service
public class RegionServiceImpl implements IRegionService{
	
	private static final Logger logger = LoggerFactory.getLogger(RegionServiceImpl.class);
	
	@Autowired
	private IRegionMapper<Region> regionMapper;

	@Override
	public List<RegionBean> getAllArea() {
		logger.info("获取所有区域");
		List<RegionBean> regBeans = new ArrayList<RegionBean>();
		List<Region> regs = this.regionMapper.getByRegType(BaseServiceConstantsCode.REGION_AREA_TYPE);
		for(Region r : regs){
			RegionBean e = new RegionBean();
			e.setRegCode(r.getRegCode());
			e.setParentCode(r.getParentCode());
			e.setRegName(r.getRegName());
			e.setRegType(r.getRegType());
			regBeans.add(e);
		}
		return regBeans;
	}
	
	@Override
	public List<RegionBean> getAllProvince() {
		logger.info("获取所有省份");
		List<RegionBean> regBeans = new ArrayList<RegionBean>();
		List<Region> regs = this.regionMapper.getByRegType(BaseServiceConstantsCode.REGION_PROVINCE_TYPE);
		for(Region r : regs){
			RegionBean e = new RegionBean();
			e.setRegCode(r.getRegCode());
			e.setParentCode(r.getParentCode());
			e.setRegName(r.getRegName());
			e.setRegType(r.getRegType());
			regBeans.add(e);
		}
		return regBeans;
	}

	@Override
	public List<RegionBean> getRegionByParentCode(String parentCode) {
		logger.info("获取同一parentCode的地址数据,parentCode={}",parentCode);
		List<RegionBean> regBeans = new ArrayList<RegionBean>();
		List<Region> regs = this.regionMapper.getByParentCode(parentCode);
		for(Region r : regs){
			RegionBean e = new RegionBean();
			e.setRegCode(r.getRegCode());
			e.setParentCode(r.getParentCode());
			e.setRegName(r.getRegName());
			e.setRegType(r.getRegType());
			regBeans.add(e);
		}
		return regBeans;
	}

	
}