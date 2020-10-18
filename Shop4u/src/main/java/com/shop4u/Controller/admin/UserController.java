package com.shop4u.Controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping(value = "/danh-sach-nguoi-dung")
	public ModelAndView listProduct(HttpServletRequest request) {
		request.setAttribute("title","danh sach nguoi dung");
		return new ModelAndView("admin/User/list");
	}
}
