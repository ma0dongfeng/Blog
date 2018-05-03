package com.lmy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lmy.entity.Blog;
import com.lmy.entity.PageBean;
import com.lmy.service.BlogService;
import com.lmy.util.StringUtil;

/**
 * 主页controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	@Resource
	private BlogService blogService;
	
	/**
	 * 请求主页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false)String page)throws Exception {
		ModelAndView mav = new ModelAndView();
		if(StringUtil.isEmpty(page)) {
			page="1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList = blogService.list(map);
		mav.addObject("blogList",blogList);
		mav.addObject("pageTitle", "个人主页");
		mav.addObject("mainPage","foreground/blog/list.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}

}
