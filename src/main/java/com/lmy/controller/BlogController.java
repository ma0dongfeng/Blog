package com.lmy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmy.entity.Blog;
import com.lmy.service.BlogService;

/**
 * 博客controller层
 * 
 * @author luomengyuan
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id")Integer id,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		Blog blog = blogService.findById(id);
		mav.addObject("blog",blog);
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		mav.addObject("pageTitle", blog.getTitle());
		mav.addObject("mainPage","foreground/blog/view.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}

}
