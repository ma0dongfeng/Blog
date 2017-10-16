package com.lmy.dao;

import com.lmy.entity.Blogger;

/**
 * 博主dao接口
 * @author luomengyuan
 *
 */
public interface BloggerDao {
	
	//通过用户名查询用户
	public Blogger getByUserName(String username);
	
	//获取博主信息
	public Blogger find();

}
