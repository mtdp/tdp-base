package com.github.mtdp.base.dubbo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.github.mtdp.base.shorturl.service.IShortURLService;

public class ShortURLServiceDubboTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ShortURLServiceDubboTest.class);
	
	private IShortURLService shortURLService;
	
	@Test
	public void createShortURLTest4Dubbo(){
		this.getShortURLDubboService();
		String  shortCode = shortURLService.createShortURL("http://www.99wuxian.com");
		logger.info("***************短URL="+shortCode);
	}
	
	private void getShortURLDubboService(){
		String ip = "127.0.0.1";
		String port = "20880";
		String service = "com.github.mtdp.base.shorturl.service.IShortURLService";
		String version = "1.0.0";
		String url = "dubbo://" + ip + ":" + port + "/" + service + "?version="+ version + "&timeout=30000" + "&threads=500&threadpool=cached";
		ApplicationConfig application = new ApplicationConfig();
		application.setName("core-hestia-impl");
		ReferenceConfig<IShortURLService> reference = new ReferenceConfig<IShortURLService>();
		reference.setUrl(url);
		reference.setApplication(application);
		reference.setInterface(IShortURLService.class);
		shortURLService = reference.get();
	}

}
