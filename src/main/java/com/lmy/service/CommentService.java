package com.lmy.service;

import java.util.List;
import java.util.Map;

import com.lmy.entity.Comment;

/**
 * @author luomengyuan
 *
 */
public interface CommentService {
	
	/**
	 * 查询评论信息
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String, Object> map);
	
}
