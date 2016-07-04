package com.github.mtdp.base.region.bean;

import java.io.Serializable;

/**
 * 
 * @Description 地区前端展示bean
 * @author wangguoqing
 * @date 2016年7月1日下午4:08:40
 *
 */
public class RegionBean implements Serializable{
	
	private static final long serialVersionUID = 8122388564906470087L;
	
	
	private String regCode;
	private String regName;
	private String parentCode;
	private Integer regType;
//	private String regMark;
//	private Integer rank;
//	private String createTime;
//	private String updateTime;
	
	public String getRegCode() {
		return regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public Integer getRegType() {
		return regType;
	}
	public void setRegType(Integer regType) {
		this.regType = regType;
	}
	
//	public String getRegMark() {
//		return regMark;
//	}
//	public void setRegMark(String regMark) {
//		this.regMark = regMark;
//	}
//	public Integer getRank() {
//		return rank;
//	}
//	public void setRank(Integer rank) {
//		this.rank = rank;
//	}
//	public String getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(String createTime) {
//		this.createTime = createTime;
//	}
//	public String getUpdateTime() {
//		return updateTime;
//	}
//	public void setUpdateTime(String updateTime) {
//		this.updateTime = updateTime;
//	}

}
