package com.duqio.boot.secret.shiro.autoconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.duqio.boot.secret.shiro.realm.SecurityShiroRealm;
import com.duqio.boot.secret.shiro.util.SaltUtil;

/**
 * 
 *************************************************
 * 功能描述:  Shiro的自动配置类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月28日 创建文件                                             
 * @see                        
 *************************************************
 */
@Configuration
public class ShiroAutoConfigure {

	/**
	 * 控制访问权限
	 * authc：所有已登陆用户可访问
	 *roles：有指定角色的用户可访问，通过[ ]指定具体角色，这里的角色名称与数据库中配置一致
	 *perms：有指定权限的用户可访问，通过[ ]指定具体权限，这里的权限名称与数据库中配置一致
	 *anon：所有用户可访问，通常作为指定页面的静态资源时使用
	 * @param securityManager
	 * @return
	 */
    @Bean
    public ShiroFilterFactoryBean shirFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthc");
        shiroFilterFactoryBean.setSuccessUrl("/home/index");
        
        filterChainDefinitionMap.put("/*", "anon");
        filterChainDefinitionMap.put("/authc/index", "authc");
        filterChainDefinitionMap.put("/authc/admin", "roles[admin]");
        filterChainDefinitionMap.put("/authc/renewable", "perms[Create,Update]");
        filterChainDefinitionMap.put("/authc/removable", "perms[Delete]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 匹配用户登录使用的令牌和数据库中保存的用户信息是否匹配
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(SaltUtil.ALGORITHM_NAME); // 散列算法
        hashedCredentialsMatcher.setHashIterations(SaltUtil.HASH_ITERATIONS); // 散列次数
        return hashedCredentialsMatcher;
    }

    @Bean
    public SecurityShiroRealm shiroRealm() {
    	SecurityShiroRealm shiroRealm = new SecurityShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher()); // 原来在这里
        return shiroRealm;
    }

    @Bean
    public org.apache.shiro.mgt.SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public SaltUtil saltUtil() {
        return new SaltUtil();
    }
	
}
