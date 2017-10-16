package com.lmy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmy.dao.BloggerDao;
import com.lmy.entity.Blogger;
import com.lmy.service.BloggerService;

/**
 * 博主service实现类
 * 
 * @author luomengyuan
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerDao bloggerDao;

	@Override
	public Blogger getByUserName(String username) {

		return bloggerDao.getByUserName(username);
	}

	@Override
	public Blogger find() {
		
		return bloggerDao.find();
	}

}
