package com.github.mtdp.base.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.mtdp.base.BaseTest;
import com.github.mtdp.base.region.bean.RegionBean;
import com.github.mtdp.base.region.service.IRegionService;
import com.github.mtdp.util.DateUtil;

public class RegionServiceTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(CaptchaServiceTest.class);
	
	@Autowired
	private IRegionService regionService;
	
	@Test
	public void getAllProvince(){
		List<RegionBean> regBeans = this.regionService.getAllProvince();
		logger.info("**********regBeans={}",regBeans);
	}
	
	@Test
	public void exportAllProvinceSql(){
		List<RegionBean> regBeans = this.regionService.getAllProvince();
		for(RegionBean b : regBeans){
			String pIds = "100000,"+b.getRegCode()+",";
			String pId = "100000";
			String d = DateUtil.getCurrentTime2();
			String c = "1";
			logger.info("insert into sys_area (id,parent_id,parent_ids,name,sort,code,type,create_by,update_by,create_date,update_date,del_flag) "
					+ "values ('{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}');",b.getRegCode(),pId,pIds,b.getRegName(),b.getRegCode(),b.getRegCode(),b.getRegType(),c,c,d,d,"0");
		}
	}
	
	@Test
	public void exportAllCitySql(){
		List<RegionBean> regBeans = this.regionService.getAllCity();
		for(RegionBean b : regBeans){
			String pIds = "100000,"+b.getParentCode()+","+b.getRegCode()+",";
			String d = DateUtil.getCurrentTime2();
			String c = "1";
			logger.info("insert into sys_area (id,parent_id,parent_ids,name,sort,code,type,create_by,update_by,create_date,update_date,del_flag) "
					+ "values ('{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}');",b.getRegCode(),b.getParentCode(),pIds,b.getRegName(),b.getRegCode(),b.getRegCode(),b.getRegType(),c,c,d,d,"0");
		}
	}
	
	

}
