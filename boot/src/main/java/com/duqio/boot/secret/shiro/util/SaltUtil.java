package com.duqio.boot.secret.shiro.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.duqio.boot.test.entity.ShiroUser;

/**
 * 
 *************************************************
 * 功能描述:  盐渍加密                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月28日 创建文件                                             
 * @see                        
 *************************************************
 */
public class SaltUtil {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    public static final String ALGORITHM_NAME = "md5"; // 基础散列算法
    public static final int HASH_ITERATIONS = 2; // 自定义散列次数

    public void encryptPassword(ShiroUser shiroUser) {
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
    	shiroUser.setShiroSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(ALGORITHM_NAME, shiroUser.getShiroPassword(),
                ByteSource.Util.bytes(shiroUser.getCredentialsSalt()), HASH_ITERATIONS).toHex();
        shiroUser.setShiroPassword(newPassword);
    }
	
}
