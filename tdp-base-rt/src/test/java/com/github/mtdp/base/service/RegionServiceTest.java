package com.github.mtdp.base.service;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.mtdp.base.BaseTest;
import com.github.mtdp.base.region.bean.RegionBean;
import com.github.mtdp.base.region.service.IRegionService;

public class RegionServiceTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(CaptchaServiceTest.class);
	
	@Autowired
	private IRegionService regionService;
	
	@Test
	public void getAllProvince(){
		List<RegionBean> regBeans = this.regionService.getAllArea();
		logger.info("**********regBeans={}",regBeans);
	}

}
