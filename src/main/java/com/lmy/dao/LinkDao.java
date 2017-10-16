package com.lmy.dao;

import java.util.List;
import java.util.Map;

import com.lmy.entity.Link;

/**
 * 友情链接dao接口
 * @author luomengyuan
 *
 */
public interface LinkDao {
	
	//查询所以友情链接
	public List<Link> list(Map<String, Object> map);

}
