package com.lmy.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.lmy.entity.Blog;
import com.lmy.entity.BlogType;
import com.lmy.entity.Blogger;
import com.lmy.entity.Link;
import com.lmy.service.BlogService;
import com.lmy.service.BlogTypeService;
import com.lmy.service.BloggerService;
import com.lmy.service.LinkService;

/**
 * 初始化组件
 * @author luomengyuan
 *
 */
@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext sce) throws BeansException {
		applicationContext = sce;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");
		Blogger blogger = bloggerService.find();
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);
		
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		List<Link> linkList = linkService.list(null);
		application.setAttribute("linkList", linkList);
		
		BlogTypeService blogTypeService = (BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeCountList = blogTypeService.countList();
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		BlogService blogService = (BlogService) applicationContext.getBean("blogService");
		List<Blog> blogCountList = blogService.countList();
		application.setAttribute("blogCountList", blogCountList);
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
