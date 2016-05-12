package com.github.mtdp.base.shorturl.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 *
 * @Description 短链接bean
 * @author gqwang
 * @date 2016年1月5日上午9:05:51
 *
 */
public class ShortURLBean implements Serializable {
	private static final long serialVersionUID = 653003082986488946L;
	
	private String shortURLName;
	private String shortCode;
	private String originalURL;
	//有效访问次数
	private Integer validVisitTimes;
	//已经访问次数
	private Integer visitedTimes;
	//有效开始时间
	private Date startValidTime;
	//有限结束时间
	private Date endValidTime;
	
	public String getShortURLName() {
		return shortURLName;
	}
	public void setShortURLName(String shortURLName) {
		this.shortURLName = shortURLName;
	}
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getOriginalURL() {
		return originalURL;
	}
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
	public Integer getValidVisitTimes() {
		return validVisitTimes;
	}
	public void setValidVisitTimes(Integer validVisitTimes) {
		this.validVisitTimes = validVisitTimes;
	}
	public Integer getVisitedTimes() {
		return visitedTimes;
	}
	public void setVisitedTimes(Integer visitedTimes) {
		this.visitedTimes = visitedTimes;
	}
	public Date getStartValidTime() {
		return startValidTime;
	}
	public void setStartValidTime(Date startValidTime) {
		this.startValidTime = startValidTime;
	}
	public Date getEndValidTime() {
		return endValidTime;
	}
	public void setEndValidTime(Date endValidTime) {
		this.endValidTime = endValidTime;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
