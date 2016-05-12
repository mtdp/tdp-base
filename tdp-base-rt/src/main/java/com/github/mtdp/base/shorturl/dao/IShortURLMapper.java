package com.github.mtdp.base.shorturl.dao;

import com.github.mtdp.base.shorturl.dao.domain.ShortURL;
import com.github.mtdp.persistence.BaseMapper;

public interface IShortURLMapper<T extends ShortURL> extends BaseMapper<T>{
	
	/**
	 * 根据短url地址查询
	 * @param shortURL
	 * @return
	 */
	public ShortURL getByShortCode(String shortCode);

}
