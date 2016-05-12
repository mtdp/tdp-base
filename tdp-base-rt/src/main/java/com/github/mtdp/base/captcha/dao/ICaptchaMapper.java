package com.github.mtdp.base.captcha.dao;

import com.github.mtdp.base.captcha.dao.domain.Captcha;
import com.github.mtdp.persistence.BaseMapper;


public interface ICaptchaMapper <T extends Captcha> extends BaseMapper<T>{
	
	/**
	 * 根据captchaCode查询验证码
	 * @param captchaCode
	 * @return
	 */
	public Captcha getByCaptchaCode(String captchaCode);

}
