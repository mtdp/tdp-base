package com.github.mtdp.base.captcha.bean;

import java.io.Serializable;

/**
 * 
 *
 * @Description 验证码业务bean
 * @author gqwang
 * @date 2016年1月5日上午9:06:14
 *
 */
public class CaptchaBean implements Serializable{
	private static final long serialVersionUID = -1631032609193599984L;
	
	//数量 默认6为
	private Integer codeNum = 6;
	//是否纯数字 默认是纯数字
	private boolean isDigit = true;
	//返回类型 默认返回字符串
	private CaptchaResultType resultType = CaptchaResultType.CHARACTER;
	//过期时间 单位秒 默认30分钟
	private int expireTime = 30*60;
	
	public Integer getCodeNum() {
		return codeNum;
	}
	public void setCodeNum(Integer codeNum) {
		this.codeNum = codeNum;
	}
	public boolean isDigit() {
		return isDigit;
	}
	public void setDigit(boolean isDigit) {
		this.isDigit = isDigit;
	}
	public CaptchaResultType getResultType() {
		return resultType;
	}
	public void setResultType(CaptchaResultType resultType) {
		this.resultType = resultType;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	
}

