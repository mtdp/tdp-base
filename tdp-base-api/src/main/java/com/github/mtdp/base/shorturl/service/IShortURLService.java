package com.github.mtdp.base.shorturl.service;

import java.util.Date;

import com.github.mtdp.base.shorturl.bean.ShortURLBean;

/**
 * 
 *
 * @Description 短连接
 * @author gqwang
 * @date 2016年1月5日上午9:05:31
 *
 */
public interface IShortURLService {
	
	/**
	 * 根据shortURLBean 创建短连接
	 * @param shortURLBean
	 * @return
	 */
	public String createShortURL(ShortURLBean shortURLBean);
	
	/**
	 * 根据原url 创建短连接
	 * @param originalURL
	 * @return
	 */
	public String createShortURL(String originalURL);
	
	/**
	 * 根据原url 创建可以访问validVisitTimes次数的短连接
	 * @param originalURL
	 * @return
	 */
	public String createShortURL(String originalURL,int validVisitTimes);
	
	/**
	 * 根据原url 创建有效期从startValidTime开始是minute分钟的短连接
	 * @param originalURL
	 * @return
	 */
	public String createShortURL(String originalURL,Date startValidTime,int minute);
	
	/**
	 * 1.根据短连接code 查询<br/>
	 * 2.判断是否在访问时间内<br/>
	 * 3.判断是否超过总的访问次数<br/>
	 * @param shortCode
	 * @return
	 */
	public ShortURLBean getShortURLByShortCode(String shortCode);
	
	/**
	 * 通过shortCode更新访问次数
	 * @param shortCode
	 * @return
	 */
	public boolean updateVisitTimes(String shortCode);
	
}
