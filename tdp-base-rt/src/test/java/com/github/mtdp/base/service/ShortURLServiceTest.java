package com.github.mtdp.base.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.mtdp.base.BaseTest;
import com.github.mtdp.base.shorturl.service.IShortURLService;

public class ShortURLServiceTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(ShortURLServiceTest.class);
	
	@Autowired
	private IShortURLService shortURLService;
	
	@Test
	public void createShortURLTest(){
		String  shortCode = shortURLService.createShortURL("http://www.99wuxian.com");
		logger.info("***************短URL="+shortCode);
	}
	
}
