package com.lmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmy.dao.BlogDao;
import com.lmy.entity.Blog;
import com.lmy.service.BlogService;

/**
 * 博客service实现
 * @author Administrator
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogDao blogDao;
	
	@Override
	public List<Blog> countList() {
		return blogDao.countList();
	}

}
