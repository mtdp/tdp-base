package com.github.mtdp.base.shorturl.dao.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.mtdp.base.shorturl.dao.domain.tbl.ShortURLTbl;

public class ShortURL extends ShortURLTbl{

	private static final long serialVersionUID = 4165942670754913051L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
