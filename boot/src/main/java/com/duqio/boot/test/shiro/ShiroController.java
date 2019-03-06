//package com.duqio.boot.test.shiro;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.duqio.boot.core.result.GeneralResult;
//import com.duqio.boot.mvc.springmvc.autoconfigure.submit.Token;
//import com.duqio.boot.secret.shiro.util.SaltUtil;
//import com.duqio.boot.test.entity.ShiroUser;
//import com.duqio.boot.test.service.ShiroService;
//
//
//@RestController
//@RequestMapping
//public class ShiroController {
//	
//	private ShiroService shiroService;
//	
//	private SaltUtil saltUtil;
//
//	@Autowired
//	public ShiroController(ShiroService shiroService, SaltUtil saltUtil) {
//		super();
//		this.shiroService = shiroService;
//		this.saltUtil = saltUtil;
//	}
//	
//	@GetMapping("/login")
//    public GeneralResult login() {
//		GeneralResult result = new GeneralResult();
//		result.setResult("Here is Login page");
//        return result;
//    }
//
//    @GetMapping("/unauthc")
//    public GeneralResult unauthc() {
//    	GeneralResult result = new GeneralResult();
//		result.setResult("Here is Unauthc page");
//        return result;
//    }
//	
//    @Token(createToken = true)
//    @GetMapping("/doLogin")
//    public GeneralResult doLogin(ShiroUser shiroUser, HttpServletRequest request) {
//    	GeneralResult result = new GeneralResult();
//        UsernamePasswordToken token = new UsernamePasswordToken(shiroUser.getShiroUsername(), shiroUser.getShiroPassword());
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//        } catch (IncorrectCredentialsException ice) {
//        	result.setResult("password error!");
//        	return result;
//        } catch (UnknownAccountException uae) {
//        	result.setResult("username error!");
//            return result;
//        }
//
//        @SuppressWarnings("unused")
//		ShiroUser user = shiroService.findShiroUserByUserNameAndPassword(shiroUser);
//        //subject.getSession().setAttribute("user", user);
////        request.getSession().setAttribute("shiroUser", value);
//        //待测试Spring session与Shiro session是否一致
//        result.setResult("success");
//        return result;
//    }
//
//    @GetMapping("/register")
//    public GeneralResult register(ShiroUser shiroUser) {
//    	GeneralResult result = new GeneralResult();
//    	saltUtil.encryptPassword(shiroUser);
//
//    	shiroService.addShiroUserService(shiroUser);
//    	result.setResult("success");
//        return result;
//    }
//	
//}
