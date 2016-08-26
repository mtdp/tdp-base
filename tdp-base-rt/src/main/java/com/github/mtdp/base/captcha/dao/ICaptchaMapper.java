package com.github.mtdp.base.captcha.dao;

import com.github.mtdp.base.captcha.dao.domain.Captcha;
import com.github.mtdp.persistence.BaseMapper;


public interface ICaptchaMapper extends BaseMapper<Captcha,Long>{
	
	/**
	 * 根据captchaCode查询验证码
	 * @param captchaCode
	 * @return
	 */
	public Captcha getByCaptchaCode(String captchaCode);

}
