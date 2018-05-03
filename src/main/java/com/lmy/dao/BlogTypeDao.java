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
	
	/**
	 * 通过id查找博客类型实体
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
}
