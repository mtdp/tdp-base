package com.github.mtdp.base.captcha.dao.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.mtdp.base.captcha.dao.domain.tbl.CaptchaTbl;

/**
 * 
 *
 * @Description 验证码domain
 * @author gqwang
 * @date 2016年1月5日上午9:07:13
 *
 */
public class Captcha extends CaptchaTbl{

	private static final long serialVersionUID = -4763831199328433375L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
