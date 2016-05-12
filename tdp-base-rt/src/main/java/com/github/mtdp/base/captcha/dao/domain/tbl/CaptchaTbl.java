package com.github.mtdp.base.captcha.dao.domain.tbl;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @Description 与表t_captcha字段一一对应
 * @author gqwang
 * @date 2016年1月5日上午9:07:18
 *
 */
public class CaptchaTbl implements Serializable{
	private static final long serialVersionUID = -4309850439846248778L;
	
	private Long captchaId;
	
	private String captchaCode;
	
	//状态 10=未使用,20=已使用
	private Integer status;

	//过期时间
	private Date expireTime;
	
	private Date createTime;
	
	private Date updateTime;

	public Long getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(Long captchaId) {
		this.captchaId = captchaId;
	}

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
