package com.lmy.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmy.dao.LinkDao;
import com.lmy.entity.Link;
import com.lmy.service.LinkService;


/**
 * 友情链接service层实现
 * @author luomengyuan
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
	
	@Resource
	private LinkDao linkDao;

	@Override
	public List<Link> list(Map<String, Object> map) {
		
		return linkDao.list(map);
	}

}
