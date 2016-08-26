package com.github.mtdp.base.region.dao.domain.tbl;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @Description 地区表对应的实体
 * @author wangguoqing
 * @date 2016年6月24日下午2:44:59
 *
 */
public class RegionTbl implements Serializable{

	private static final long serialVersionUID = 3581427817783848918L;
	
	private String regCode;
	private String regName;
	private String parentCode;
	private Integer regType;
	private String regMark;
	private Integer rank;
	private boolean isEnable;
	private Date createTime;
	private Date updateTime;
	
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
	public String getRegMark() {
		return regMark;
	}
	public void setRegMark(String regMark) {
		this.regMark = regMark;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
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
