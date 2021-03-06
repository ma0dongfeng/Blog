package com.lmy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmy.entity.Blogger;
import com.lmy.service.BloggerService;
import com.lmy.util.CryptographyUtil;

/**
 * 博主controller层
 * 
 * @author luomengyuan
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Resource
	private BloggerService bloggerService;

	@RequestMapping("/login")
	public String login(Blogger blogger, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "111111"));
		try {
			subject.login(token);
			return "redirect:/admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("blogger", blogger);
			request.setAttribute("errorInfo", "用户名或秘密错误");
			return "login";
		}
	}
	
	@RequestMapping("/aboutMe")
	public 	ModelAndView aboutMe()throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("mainPage","foreground/blogger/info.jsp");
		mav.addObject("pageTitle", "博主信息");
		mav.setViewName("mainTemp");
		return mav;
	}
	
	

}
