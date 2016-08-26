package com.github.mtdp.base.shorturl.dao;

import com.github.mtdp.base.shorturl.dao.domain.ShortURL;
import com.github.mtdp.persistence.BaseMapper;

public interface IShortURLMapper extends BaseMapper<ShortURL,Long>{
	
	/**
	 * 根据短url地址查询
	 * @param shortURL
	 * @return
	 */
	public ShortURL getByShortCode(String shortCode);

}
