package com.github.mtdp.base.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.mtdp.base.BaseTest;
import com.github.mtdp.base.captcha.bean.CaptchaBean;
import com.github.mtdp.base.captcha.bean.CaptchaBeanResult;
import com.github.mtdp.base.captcha.bean.CaptchaResultType;
import com.github.mtdp.base.captcha.service.ICaptchaService;

public class CaptchaServiceTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(CaptchaServiceTest.class);
	
	
	@Autowired
	private ICaptchaService captchaService;
	
	@Test
	public void createCaptchaTest() throws IOException{
		CaptchaBean captchaBean = new CaptchaBean();
		captchaBean.setResultType(CaptchaResultType.IMAGE);
		captchaBean.setCodeNum(6);
		CaptchaBeanResult result = this.captchaService.createCaptcha(captchaBean);
		logger.info("*******************result="+result);
		
		//保存文件
		File file = new File("d:/tmp/1.jpg");
		file.createNewFile();
		FileOutputStream f = new FileOutputStream(file);
		f.write(result.getImage());
		f.flush();
		f.close();
		logger.info("*************d:/tmp/1.jpg 生成完成");
	}
}
