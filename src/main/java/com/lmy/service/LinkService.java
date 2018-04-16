package com.lmy.service;

import java.util.List;
import java.util.Map;

import com.lmy.entity.Link;

/**
 * 友情链接service接口
 * 
 * @author luomengyuan
 *
 */
public interface LinkService {

	/**
	 * 查找友情链接信息
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object> map);

}
