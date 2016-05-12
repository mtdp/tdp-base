package com.github.mtdp.base.shorturl.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.mtdp.base.shorturl.bean.ShortURLBean;
import com.github.mtdp.base.shorturl.service.IShortURLService;
/**
 * 
 *
 * @Description 访问短链接action
 * @author gqwang
 * @date 2016年1月5日上午9:08:47
 *
 */
@Controller
@RequestMapping("/**")
public class ShortURLAction {
	private static final Logger logger = LoggerFactory.getLogger(ShortURLAction.class);
	
	@Autowired
	private IShortURLService shortURLService;
	
	@RequestMapping(value="/*")
	public String parseShortURL(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String shortURL = request.getRequestURL().toString();
		logger.info("需要解析的短连接是shortURL="+shortURL);
		//1.解析url找到短urlcode
		String shortCode = shortURL.substring(shortURL.lastIndexOf("/")+1, shortURL.length());
		//2.数据库查询短url对应的长url
		ShortURLBean shortURLBean = this.shortURLService.getShortURLByShortCode(shortCode);
		if(null == shortURLBean){
			logger.error("通过[{}]短连接找不到长连接,(短连接访问次数限制或者不在访问时间内)",shortURL);
			model.addAttribute("errMsg", shortURL+" 短连接找不到长连接,(短连接访问次数限制或者不在访问时间内)");
			return "error";
		}
		//3.更新updateTime,访问次数
		this.shortURLService.updateVisitTimes(shortCode);
		logger.info("短连接[{}]对应的长连接是[{}]",shortURL,shortURLBean.getOriginalURL());
		return "redirect:" + shortURLBean.getOriginalURL();
	}
	
}
