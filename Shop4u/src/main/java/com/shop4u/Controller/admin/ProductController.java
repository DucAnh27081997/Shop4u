package com.shop4u.Controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shop4u.Model.TestDTO;
import com.shop4u.service.TestService;

@Controller("adminProductController")
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	TestService testService;
	
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
	
	@RequestMapping(value = "/chi-tiet-bai-test/{id}",method = RequestMethod.GET)
	public ModelAndView Login(HttpServletRequest request,@PathVariable("id") int id) {
		request.setAttribute("title","detail");
		TestDTO test = testService.getTestById(id);
		if(test==null) {
			return new ModelAndView("admin/Test/listTest");
		}
		request.setAttribute("test",test);		
		return new ModelAndView("admin/Test/UpdateTest");
	}
}
