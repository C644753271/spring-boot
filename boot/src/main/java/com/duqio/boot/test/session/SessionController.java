package com.duqio.boot.test.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duqio.boot.core.result.GeneralResult;
import com.duqio.boot.mvc.springmvc.autoconfigure.submit.Token;

/**
 * 
 *************************************************
 * 功能描述:  session共享的测试类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月26日 创建文件                                             
 * @see                        
 *************************************************
 */
@RestController
@RequestMapping("/sessionRestful")
public class SessionController {

	/**
	 * 用于测试是否已经开启session共享
	 * @param request
	 * @return
	 */
	@GetMapping("/sessionTest")
	public GeneralResult sessionTest(HttpServletRequest request) {
		GeneralResult result = new GeneralResult();
		//如果session没有共享，那么在访问不同的服务器时，将获取不到token
		result.setToken(request.getSession().getAttribute("token") + "");
		return result;
	}
	
	/**
	 * 在session中生成Token
	 * @return
	 */
	@Token(createToken = true)
	@GetMapping("/getToken")
	public GeneralResult getToken(){
		GeneralResult result = new GeneralResult();
		return result;
	}
	
}
