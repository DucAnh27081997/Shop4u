package com.shop4u.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop4u.entity.Part1;
import com.shop4u.service.Part1Service;

@RestController
@RequestMapping("/api")
public class RestPartController {
	
	@Autowired
	Part1Service part1Service;
	
	@RequestMapping(value = "/Part1/{idTest}",method = RequestMethod.GET)
	public List<Part1> getListPart(@PathVariable(value = "idTest") int idTest) {
		return part1Service.getAllPart1(idTest);
	}
	
	@RequestMapping(value = "/Part1",method = RequestMethod.PUT)
	@ResponseBody
	public String  UpdatePart(@RequestBody Part1 question) {
		try {
			if (part1Service.getPart1ById(question.getId()) != null) {
				part1Service.updatePart1(question);;
				return "success";
			} else {
				return "fail: ko ton tai!";
			}
		} catch (Exception e) {
			return "fail: " + e.getMessage();
		}
	}
}
