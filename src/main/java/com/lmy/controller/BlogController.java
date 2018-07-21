package com.lmy.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmy.entity.Blog;
import com.lmy.service.BlogService;
import com.lmy.service.CommentService;
import com.lmy.util.StringUtil;

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
	
	@Resource
	private CommentService commentService;
	
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id")Integer id,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		Blog blog = blogService.findById(id);
		String keyWord = blog.getKeyWord();
		if(StringUtil.isNotEmpty(keyWord)) {
			String arr[] = keyWord.split(" ");
			mav.addObject("keyWords",StringUtil.filterWhite(Arrays.asList(arr)));
		}else {
			mav.addObject("keyWords",null);
		}
		mav.addObject("blog",blog);
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		Map<String, Object> map = new HashMap<>();
		map.put("blogId", blog.getId());
		map.put("state", 1);
		mav.addObject("commentList",commentService.list(map));
		Blog lastBlog = blogService.getLastBlog(id);
		Blog nextBlog = blogService.getNextBlog(id);
		mav.addObject("pageCode",this.getUpAndDownPageCode(lastBlog,nextBlog, request.getServletContext().getContextPath()));
		mav.addObject("pageTitle", blog.getTitle());
		mav.addObject("mainPage","foreground/blog/view.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * 获取上一篇和下一批博客
	 * @param lastBlog
	 * @param nextBlog
	 * @return
	 */
	private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String prjectContext ) {
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()==null) {
			pageCode.append("<p>上一篇：没有了</p>");
		}else {
			pageCode.append("<p><a href='"+prjectContext +"/blog/articles/"+lastBlog.getId()+".html'>上一篇："+lastBlog.getTitle()+"</a></p>");
		}
		if(nextBlog==null || nextBlog.getId()==null) {
			pageCode.append("<p>下一篇：没有了</p>");
		}else {
			pageCode.append("<p><a href='"+prjectContext +"/blog/articles/"+nextBlog.getId()+".html'>下一篇："+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}

}

