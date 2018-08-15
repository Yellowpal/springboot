package win.yellowpal.springboot.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danga.MemCached.MemCachedClient;

import win.yellowpal.springboot.service.RedisService;
import win.yellowpal.springboot.util.TestUtil;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {
	
	@Autowired
	MemCachedClient mcc;
	
	@Autowired
	RedisService<String, Long> redisService;
	
	@Autowired 
	private StringRedisTemplate stringRedisTemplate;
	
	@PostConstruct
	private void init(){
		stringRedisTemplate.opsForValue().set("redisDecr", "100");
		mcc.set("mccDecr", 100);
	}
	
    @RequestMapping({"/","/index"})
    @ResponseBody
    public String index(){
    	
//    	synchronized (this) {
//    		System.out.println("i:"+TestUtil.test());
//		}
//    	System.out.println(this);
//    	System.out.println(Thread.currentThread().getName());
    	
    	
//    	mcc.set("paltest", 10);
    	long result = mcc.decr("mccDecr");
    	if(result > 0){
    		System.out.println("mcc decr in==="+result);
    	}
    	
    	if(mcc.add("haha1", 1)){
    		System.out.println("add in");
    	}
    	
    	long redisResult = stringRedisTemplate.opsForValue().increment("redisDecr", -1);
    	if(redisResult > 0){
    		System.out.println("redis decr in==="+redisResult);
    	}
    	
//    	System.out.println("paltest:"+mcc.get("paltest"));
    	
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
//        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
//        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}