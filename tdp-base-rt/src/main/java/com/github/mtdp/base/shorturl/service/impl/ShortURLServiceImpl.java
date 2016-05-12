package com.github.mtdp.base.shorturl.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mtdp.base.shorturl.bean.ShortURLBean;
import com.github.mtdp.base.shorturl.dao.IShortURLMapper;
import com.github.mtdp.base.shorturl.dao.domain.ShortURL;
import com.github.mtdp.base.shorturl.service.IShortURLService;
import com.github.mtdp.util.GenerateCharacter;

/**
 * 
 *
 * @Description 短链接实现
 * @author gqwang
 * @date 2016年1月5日上午9:09:09
 *
 */
@Service
public class ShortURLServiceImpl implements IShortURLService{
	
	private static final Logger logger = LoggerFactory.getLogger(ShortURLServiceImpl.class);
	
	
	@Autowired
	private IShortURLMapper<ShortURL> shortURLMapper;

	@Override
	public String createShortURL(ShortURLBean shortURLBean) {
		//1.校验参数 TODO
		String originalURL = shortURLBean.getOriginalURL();
		//2.根据长连接生成短连接
		String shortCode = this.getShortCodeByRandom(originalURL, 0, 0);
		//3.查询数据库是否有此短连接
		while(this.shortURLMapper.getByShortCode(shortCode) != null){
			//数据库有继续生成
			shortCode = this.getShortCodeByRandom(originalURL, 0, 0);
		}
		shortURLBean.setShortCode(shortCode);
		//4.保存到数据库
		ShortURL t = new ShortURL();
		BeanUtils.copyProperties(shortURLBean, t);
		t.setCreateTime(new Date());
		t.setUpdateTime(new Date());
		//默认访问次数是0
		t.setVisitedTimes(new Integer(0));
		this.shortURLMapper.add(t);
		//5.返回短连接字符串
		return shortCode;
	}
	
	@Override
	public String createShortURL(String originalURL) {
		ShortURLBean shortURLBean = new ShortURLBean();
		shortURLBean.setOriginalURL(originalURL);
		return this.createShortURL(shortURLBean);
	}
	
	@Override
	public String createShortURL(String originalURL, int validVisitTimes) {
		ShortURLBean shortURLBean = new ShortURLBean();
		shortURLBean.setOriginalURL(originalURL);
		shortURLBean.setValidVisitTimes(validVisitTimes);
		return this.createShortURL(shortURLBean);
	}
	
	@Override
	public String createShortURL(String originalURL, Date startValidTime,int minute) {
		ShortURLBean shortURLBean = new ShortURLBean();
		shortURLBean.setOriginalURL(originalURL);
		long endTime = startValidTime.getTime() + (minute * 60 * 1000L);
		shortURLBean.setEndValidTime(new Date(endTime));
		return this.createShortURL(shortURLBean);
	}
	
	@Override
	public ShortURLBean getShortURLByShortCode(String shortCode) {
		ShortURL shortURL = this.shortURLMapper.getByShortCode(shortCode);
		if(null == shortURL){
			return null;
		}
		//判断是否有访问次数限制
		Integer visitTimes = shortURL.getValidVisitTimes();
		if(visitTimes != null && visitTimes > 0){
			if(shortURL.getVisitedTimes() >= visitTimes){
				logger.error("[{}]短连接访问次数大于预设值",shortCode);
				return null;
			}
		}
		long currTime = System.currentTimeMillis();
		if(shortURL.getStartValidTime() != null && shortURL.getEndValidTime() != null){
			long startTime = shortURL.getStartValidTime().getTime();
			long endTime = shortURL.getEndValidTime().getTime();
			if(currTime < startTime || currTime > endTime){
				logger.error("[{}]短连接不再有效期内",shortCode);
				return null;
			}
		}
		ShortURLBean shortURLBean = new ShortURLBean();
		BeanUtils.copyProperties(shortURL, shortURLBean);
		return shortURLBean;
	}
	
	@Override
	public boolean updateVisitTimes(String shortCode) {
		ShortURL shortURL = this.shortURLMapper.getByShortCode(shortCode);
		if(null == shortURL){
			logger.error("根据[{}]查询不到短连接,更新访问次数失败",shortCode);
			return false;
		}
//		int countVisitTimes = shortURL.getValidVisitTimes();
		int visit = shortURL.getVisitedTimes() + 1;
		//总访问次数等于0时表示无限次数
//		if(countVisitTimes > 0 && visit > countVisitTimes){
//			logger.error("访问总次数超限");
//			return false;
//		}
		ShortURL t = new ShortURL();
		t.setShortURLId(shortURL.getShortURLId());
		t.setVisitedTimes(visit);
		t.setUpdateTime(new Date());
		int c = this.shortURLMapper.update(t);
		if(c == 1){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取短链码方法（最短5位，最长10位）
	 * @param originalURL 原始链接
	 * @param amount 有效数量
	 * @param probability 如果是4 就是概率是10的4次方分之1
	 * @return String 短链接码，默认是6位（amount和probability都传入0）
	 */
	private String getShortCodeByRandom(String originalURL,int amount,int probability){
		//amount有效数量 ，probability是4 就是10的4次方分之1
		//得出总数量
		Double sum = amount /(1 / Math.pow(10, probability));
		//以62为底，sum的对数
		Double x=Math.log(sum) / Math.log(62);
		//位数
		int y = x.intValue() + 1;
		if(y < 5){
			y = 5;
		}
		if(y > 10){
			y = 10;
		}
//		String[] chars = new String[] {"0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h","i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t","u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H","I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T","U", "V", "W", "X", "Y", "Z"};
//		String shortURLCode = "";
//		for(int i = 0; i < y; i++){
//			shortURLCode += chars[new Random().nextInt(chars.length)];
//		}
		return GenerateCharacter.randomGenernateCharacter(y, false);
	}

}
