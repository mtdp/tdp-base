package com.github.mtdp.base.captcha.bean;

/**
 * 
 *
 * @Description 验证码返回类型枚举
 * @author gqwang
 * @date 2016年1月5日上午9:06:41
 *
 */
public enum CaptchaResultType {
	
	IMAGE(10,"图片"),CHARACTER(20,"字符串");
	
	private int code;
	private String name;
	
	private CaptchaResultType(int code,String name){
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
