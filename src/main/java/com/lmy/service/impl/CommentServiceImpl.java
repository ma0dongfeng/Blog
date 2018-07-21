package com.lmy.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmy.dao.CommentDao;
import com.lmy.entity.Comment;
import com.lmy.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	@Resource
	private CommentDao commentDao;

	@Override
	public List<Comment> list(Map<String, Object> map) {
		return commentDao.list(map);
	}

}
