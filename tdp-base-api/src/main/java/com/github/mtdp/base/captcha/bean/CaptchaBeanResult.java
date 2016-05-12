package com.github.mtdp.base.captcha.bean;

import java.io.Serializable;

/**
 * 
 *
 * @Description 验证码业务返回bean
 * @author gqwang
 * @date 2016年1月5日上午9:06:31
 *
 */
public class CaptchaBeanResult implements Serializable{
	
	private static final long serialVersionUID = -5526310944394253662L;
	
	//数据库保存的id
	private Integer capchaId;
	//验证码字符串
	private String capchaStr;
	//验证码图片的byte数组 请求返回类型是图片才有值,否则为空
	private byte[] image;
	
	
	public Integer getCapchaId() {
		return capchaId;
	}
	public void setCapchaId(Integer capchaId) {
		this.capchaId = capchaId;
	}
	public String getCapchaStr() {
		return capchaStr;
	}
	public void setCapchaStr(String capchaStr) {
		this.capchaStr = capchaStr;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

}
