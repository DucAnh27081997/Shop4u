package com.shop4u.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeControllerOfAdmin")
public class HomeController {
	@RequestMapping(value = "dang-nhap",method = RequestMethod.GET)
	public ModelAndView Login(@RequestParam(name="error", required = false ) String error) {		
		System.out.println(error);
		return new ModelAndView("admin/Home/login");
	}
}
