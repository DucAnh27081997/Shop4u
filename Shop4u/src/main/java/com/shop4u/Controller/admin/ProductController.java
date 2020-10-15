package com.shop4u.Controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("adminProductController")
@RequestMapping("/admin")
public class ProductController {
	@RequestMapping(value = "/danh-sach-san-pham")
	public ModelAndView listProduct(HttpServletRequest request) {
		request.setAttribute("title","danh sach san pham");
		return new ModelAndView("admin/Product/list");
	}
	@RequestMapping(value = "/danh-sach-bai-test")
	public ModelAndView listTest(HttpServletRequest request) {
		request.setAttribute("title","danh sach bai test");
		return new ModelAndView("admin/Test/listTest");
	}
}
