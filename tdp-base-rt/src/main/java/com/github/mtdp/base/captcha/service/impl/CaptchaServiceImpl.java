package com.github.mtdp.base.captcha.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mtdp.base.bean.BaseServiceConstantsCode;
import com.github.mtdp.base.captcha.bean.CaptchaBean;
import com.github.mtdp.base.captcha.bean.CaptchaBeanResult;
import com.github.mtdp.base.captcha.bean.CaptchaResultType;
import com.github.mtdp.base.captcha.dao.ICaptchaMapper;
import com.github.mtdp.base.captcha.dao.domain.Captcha;
import com.github.mtdp.base.captcha.service.ICaptchaService;
import com.github.mtdp.util.GenerateCharacter;

/**
 * 
 *
 * @Description 验证码实现
 * @author gqwang
 * @date 2016年1月5日上午9:08:07
 *
 */
@Service
public class CaptchaServiceImpl implements ICaptchaService{
	
	private static final Logger logger = LoggerFactory.getLogger(CaptchaServiceImpl.class);

	@Autowired
	private ICaptchaMapper<Captcha> captchaMapper;
	
	@Override
	public CaptchaBeanResult createCaptcha(CaptchaBean captchaBean) {
		//0.校验参数 TODO
		//1.根据规则生成验证码
		CaptchaBeanResult result = new CaptchaBeanResult();
		String captchaCode = GenerateCharacter.randomGenernateCharacter(captchaBean.getCodeNum(), captchaBean.isDigit());
		result.setCapchaStr(captchaCode);
		//2.根据返回规则生成返回类型
		if(captchaBean.getResultType().equals(CaptchaResultType.IMAGE)){
			//返回图片  生成图片字节码
			BufferedImage image = this.createImage(captchaCode);
			ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
			try {
				ImageIO.write(image, "JPEG", byteArr);
			} catch (IOException e) {
				logger.error("验证码生成图片异常",e);
			}
			result.setImage(byteArr.toByteArray());
		}
		//3.落地数据库
		Captcha t = new Captcha();
		long currTime = System.currentTimeMillis() + (captchaBean.getExpireTime()*1000);
		t.setCaptchaCode(captchaCode);
		t.setExpireTime(new Date(currTime));
		t.setStatus(BaseServiceConstantsCode.CAPTCHA_STATUS_UNUSED);
		t.setCreateTime(new Date());
		t.setUpdateTime(new Date());
		this.captchaMapper.add(t);
		result.setCapchaId(t.getCaptchaId().intValue());
		return result;
	}

	@Override
	public CaptchaBeanResult createCaptcha() {
		CaptchaBean captchaBean = new CaptchaBean();
		return this.createCaptcha(captchaBean);
	}
	
	@Override
	public CaptchaBeanResult createCaptcha(boolean isDigit) {
		CaptchaBean captchaBean = new CaptchaBean();
		captchaBean.setDigit(isDigit);
		return this.createCaptcha(captchaBean);
	}
	
	@Override
	public boolean verifyCaptcha(Long captchaId, String inputCaptchaCode) {
		//1.根据id查询验证码
		Captcha t = this.captchaMapper.get(String.valueOf(captchaId));
		//2.对比验证码是否一样
        if(!t.getCaptchaCode().equals(inputCaptchaCode)){
          return false;
        }
		//3.校验是否过期并且未使用
		long currTime = System.currentTimeMillis();
		long expireTime = t.getExpireTime().getTime();
		if(currTime < expireTime){
			if(t.getStatus().intValue() == BaseServiceConstantsCode.CAPTCHA_STATUS_UNUSED){
			    // 更新验证码状态为使用
  			    t.setStatus(BaseServiceConstantsCode.CAPTCHA_STATUS_USED);
                this.captchaMapper.update(t);
				return true;
			}
		}
		return false;
	}
	
	private BufferedImage createImage(String captchaCode){
		int width = 60,height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		//设置线的颜色
		g.setColor(getRandColor(50,100));
		//划线
		Random random = new Random();
		for(int i = 0; i < 20; i++){
			int x1 = random.nextInt(height);
			int y1 = random.nextInt(width);
			int x2 = random.nextInt(100);
			int y2 = random.nextInt(20);
			g.drawLine(x1, y1, height+x2, width+y2);
		}
		char[] chs = captchaCode.toCharArray();
		int chsLng = chs.length;
		for(int j = 0; j < chsLng; j++){
			//设置字符的颜色
			g.setColor(getRandColor(60, 120));
			g.drawString(String.valueOf(chs[j]), (j*width/chsLng), height/2+7);
		}
		//生成图像
		g.dispose();
		return image;
	}
	
	/**
	 * 随机生产color
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc, int bc) { // 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());
	}

}
