package com.duqio.boot.secret.shiro.realm;

import java.util.Objects;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.duqio.boot.secret.shiro.util.SpringContextUtil;
import com.duqio.boot.test.entity.ShiroUser;
import com.duqio.boot.test.service.ShiroService;


public class SecurityShiroRealm extends AuthorizingRealm {


	/**
	 * 提供用户信息返回权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String userName = (String) principals.getPrimaryPrincipal();
		ShiroService shiroService = (ShiroService) SpringContextUtil.getBean("shiroService");
		ShiroUser shiroUser = shiroService.findShiroUserByUserName(userName);
		shiroUser.getRoles().forEach(role -> {
			authorizationInfo.addRole(role.getRole());
			role.getPermissions().forEach(permission -> {
				authorizationInfo.addStringPermission(permission.getName());
			});
		});
		return authorizationInfo;
	}

	
	/**
	 * 提供账户信息返回认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		ShiroService shiroService = (ShiroService) SpringContextUtil.getBean("shiroService");
		ShiroUser shiroUser = shiroService.findShiroUserByUserName(userName);

        if (Objects.isNull(shiroUser)) {
            return null;
        }else{
        	SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser.getShiroUsername(), shiroUser.getShiroPassword(),
                    ByteSource.Util.bytes(shiroUser.getCredentialsSalt()), getName());
            return authenticationInfo;	
        }
	}

}
