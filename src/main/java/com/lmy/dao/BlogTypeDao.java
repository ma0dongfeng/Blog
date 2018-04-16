package com.lmy.dao;

import java.util.List;

import com.lmy.entity.BlogType;

/**
 * 博客类型dao接口
 * @author luomengyuan
 *
 */
public interface BlogTypeDao {

	/**
	 * 查询所有博客类型和数量
	 * @return
	 */
	public List<BlogType> countList();
}
