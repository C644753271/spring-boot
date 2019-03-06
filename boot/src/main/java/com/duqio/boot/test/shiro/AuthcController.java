//package com.duqio.boot.test.shiro;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.duqio.boot.core.result.GeneralResult;
//
//@RestController
//@RequestMapping("/authc")
//public class AuthcController {
//
//	@GetMapping("/index")
//    public GeneralResult index() {
//		GeneralResult result = new GeneralResult();
//		Subject subject = SecurityUtils.getSubject();
//        //User user = (User) subject.getSession().getAttribute("user");
//		result.setToken(subject.getSession().getAttribute("token") + "");
//        return result;
//    }
//
//    @GetMapping("/admin")
//    public GeneralResult admin() {
//    	GeneralResult result = new GeneralResult();
//    	result.setResult("Welcome Admin");
//        return result;
//    }
//
//    // delete
//    @GetMapping("/removable")
//    public Object removable() {
//        GeneralResult result = new GeneralResult();
//    	result.setResult("removable");
//        return result;
//    }
//
//    // insert & update
//    @GetMapping("/renewable")
//    public Object renewable() {
//    	GeneralResult result = new GeneralResult();
//     	result.setResult("renewable");
//        return result;
//    }
//	
//}
