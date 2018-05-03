package com.lmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmy.dao.BlogTypeDao;
import com.lmy.entity.BlogType;
import com.lmy.service.BlogTypeService;

/**
 * 博客类型service实现类
 * @author Administrator
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
	
	@Resource
	private BlogTypeDao blogTypeDao;

	@Override
	public List<BlogType> countList() {
		
		return blogTypeDao.countList();
	}

	@Override
	public BlogType findById(Integer id) {
		
		return blogTypeDao.findById(id);
	}
	
}
