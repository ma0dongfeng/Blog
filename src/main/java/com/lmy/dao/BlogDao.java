package com.lmy.dao;

import java.util.List;
import java.util.Map;

import com.lmy.entity.Blog;

/**
 * 博客Dao接口
 * @author Administrator
 *
 */
public interface BlogDao {
	
	/**
	 * 根据日期分月查询
	 * @return
	 */
	public List<Blog> countList();
	
	/**
	 * 分页查询博客
	 * @param map
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public long getTotal(Map<String, Object> map);

}
