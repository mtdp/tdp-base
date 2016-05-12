package com.github.mtdp.base.shorturl.dao.domain.tbl;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @Description 与t_short_url字段一一对应
 * @author gqwang
 * @date 2016年1月5日上午9:09:28
 *
 */
public class ShortURLTbl implements Serializable{
	
	private static final long serialVersionUID = -3486892743838582784L;
	
	private Long shortURLId;
	//名称
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
	private Date updateTime;
	private Date createTime;
	
	public Long getShortURLId() {
		return shortURLId;
	}
	public void setShortURLId(Long shortURLId) {
		this.shortURLId = shortURLId;
	}
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
