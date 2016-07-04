package com.github.mtdp.base.region.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.mtdp.base.region.bean.RegionBean;
import com.github.mtdp.base.region.service.IRegionService;

/**
 * 
 *
 * @Description 地区action
 * @author wangguoqing
 * @date 2016年7月1日下午5:02:19
 *
 */
@Controller
@RequestMapping("/region")
public class RegionAction {
	
	private static final Logger logger = LoggerFactory.getLogger(RegionAction.class);
	
	@Autowired
	private IRegionService regionService;

	@RequestMapping("/getAllArea")
	@ResponseBody
	public List<RegionBean> getAllArea(){
		logger.info("获取所有区域");
		List<RegionBean> regBeans = this.regionService.getAllArea();
		return regBeans;
	}
	
	@RequestMapping("/getAllProvince")
	@ResponseBody
	public List<RegionBean> getAllProvince(){
		logger.info("获取所有省份");
		List<RegionBean> regBeans = this.regionService.getAllProvince();
		return regBeans;
	}
	
	
	
	@RequestMapping("/getRegionByParentCode/{parentCode}")
	@ResponseBody
	public List<RegionBean> getRegionByParentCode(@PathVariable String parentCode){
		logger.info("通过parentCode获取地区数据,parentCode={}",parentCode);
		List<RegionBean> regBeans = this.regionService.getRegionByParentCode(parentCode);
		return regBeans;
	}
	
}
