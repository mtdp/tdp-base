package com.github.mtdp.base.captcha.service;

import com.github.mtdp.base.captcha.bean.CaptchaBean;
import com.github.mtdp.base.captcha.bean.CaptchaBeanResult;
/**
 * 
 *
 * @Description 验证码生成
 * @author gqwang
 * @date 2016年1月5日上午9:05:03
 *
 */
public interface ICaptchaService {
	
	/**
	 * 根据captchaBean 生成字符串验证码
	 * @param captchaBean
	 * @return
	 */
	public CaptchaBeanResult createCaptcha(CaptchaBean captchaBean);
	
	/**
	 * 按照默认规则生成验证码
	 * 数字
	 * @return
	 */
	public CaptchaBeanResult createCaptcha();
	
	/**
	 * 生成验证码是否是纯数字
	 * true 是
	 * false 否
	 * @return
	 */
	public CaptchaBeanResult createCaptcha(boolean isDigit);
	
	/**
	 * 根据captchaId验证用户输入的验证码是否正确
	 * @param captchaId
	 * @param inputCaptchaCode
	 * @return
	 */
	public boolean verifyCaptcha(Long captchaId,String inputCaptchaCode);

}
