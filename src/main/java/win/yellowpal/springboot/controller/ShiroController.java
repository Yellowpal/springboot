package win.yellowpal.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shiro")
public class ShiroController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
