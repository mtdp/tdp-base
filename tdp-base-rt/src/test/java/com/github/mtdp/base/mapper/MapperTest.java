package com.github.mtdp.base.mapper;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.mtdp.base.BaseTest;
import com.github.mtdp.base.shorturl.dao.IShortURLMapper;
import com.github.mtdp.base.shorturl.dao.domain.ShortURL;


public class MapperTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(MapperTest.class);
	
	@Autowired
	private IShortURLMapper shortURLMapper;
	
	
	@Test
	public void testAdd(){
		ShortURL t = new ShortURL();
		t.setOriginalURL("http://www.99wuxian.com");
		t.setShortURLName("99wuxian首页");
		t.setShortCode("99wuxian");
		t.setUpdateTime(new Date());
		t.setCreateTime(new Date());
		int c = this.shortURLMapper.add(t);
		logger.info("***********************c="+c);
		logger.info("***********************t="+t);
	}
	
	@Test
	public void testGet(){
		ShortURL t = this.shortURLMapper.get(1L);
		logger.info("***********************t="+t);
	}
	
}
