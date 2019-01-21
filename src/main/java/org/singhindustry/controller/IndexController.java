package org.singhindustry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value={"/", "/login"})
    public String loginForm(){
        return "login";
    }
	
	@GetMapping("/home")
	public String indexPage() {
		return "index";
	}
	
}
