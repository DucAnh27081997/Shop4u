package com.shop4u.Api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop4u.Model.TestDTO;
import com.shop4u.service.TestService;

@RestController
@RequestMapping("/api")
public class RestTestController {

	@Autowired
	TestService TestService;

	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	@ResponseBody
	public List<TestDTO> getAllTest() {
		List<TestDTO> lstTest = TestService.getAllTest();
		return lstTest;
	}
	
	@RequestMapping(value = "/TestByParameters", method = RequestMethod.POST)
	@ResponseBody
	public List<TestDTO> TestByParameters(@RequestParam(value = "key") String key,@RequestParam(value = "value") String value,
			@RequestParam(value = "begin") int begin,
			@RequestParam(value = "max") int max) {
		List<TestDTO> lstTest = TestService.getAllTest();
		return lstTest;
	}
	
	@RequestMapping(value = "/Test/{id}", method = RequestMethod.GET)
	@ResponseBody
	public TestDTO getTestById(@PathVariable("id") int id) {
		TestDTO Test = TestService.getTestById(id);
		if (Test != null)
			return Test;
		else
			return null;
	}

	@RequestMapping(value = "/Test/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String DeleteTestById(@PathVariable("id") int id) {
		TestDTO Test = TestService.getTestById(id);
		if (Test != null) {
			TestService.deleteTest(id);
			return "success";
		} else
			return "fail";
	}

	@RequestMapping(value = "/Test", method = RequestMethod.POST)
	@ResponseBody
	public String AddTest(@RequestBody TestDTO Test) {
		try {
			Test.setDateCreate(new Date());
			TestService.addTest(Test);
			return "success";
		} catch (Exception e) {
			return "fail: " + e.getMessage();
		}
	}

	@RequestMapping(value = "/Test", method = RequestMethod.PUT)
	@ResponseBody
	public String UpdateTest(@RequestBody TestDTO Test) {
		try {
			if (TestService.getTestById(Test.getId()) != null) {
				TestService.updateTest(Test);
				return "success";
			} else {
				return "fail: ko ton tai!";
			}
		} catch (Exception e) {
			return "fail: " + e.getMessage();
		}
	}
}

