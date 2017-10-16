package com.lmy.service;

import com.lmy.entity.Blogger;

/**
 * 博主service接口
 * 
 * @author luomengyuan
 *
 */
public interface BloggerService {

	// 通过用户名查询用户
	public Blogger getByUserName(String username);

	// 获取博主信息
	public Blogger find();

}
