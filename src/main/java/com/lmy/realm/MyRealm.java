package com.lmy.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.lmy.entity.Blogger;
import com.lmy.service.BloggerService;

/**
 * 自定义realm
 * 
 * @author luomengyuan
 *
 */
public class MyRealm extends AuthorizingRealm {

	@Resource
	private BloggerService bloggerService;

	// 为当前登入用户获取用户角色和权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	// 验证当前登入用户
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		Blogger blogger = bloggerService.getByUserName(userName);
		if (blogger != null) {
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);//把当前用户信息存入session中
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(),
					""); 
			return authcInfo; 
		}
		return null; 
	}

}
