package com.shop4u.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.shop4u.entity.Test;
import com.shop4u.Model.TestDTO;
import com.shop4u.dao.TestDAO;
import com.shop4u.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDAO TestDAO;
	
	@Override
	public void addTest(TestDTO x) {
		Test Test = new Test();
		
		Test.setName(x.getName());
		Test.setLinkMP4(x.getLinkMP4());
		Test.setId(x.getId());
		Test.setDateCreate(x.getDateCreate());
		
		TestDAO.addTest(Test);
	}

	@Override
	public void updateTest(TestDTO x) {
		Test Test = new Test();
		
		Test.setName(x.getName());
		Test.setLinkMP4(x.getLinkMP4());
		Test.setId(x.getId());
		Test.setDateCreate(x.getDateCreate());
		
		TestDAO.updateTest(Test);
	}

	@Override
	public void deleteTest(int id) {
		
		TestDAO.deleteTest(id);
	}

	
	@Override
	public TestDTO getTestById(int id) {

		Test test = TestDAO.getTestById(id);
		if(test!=null) {
			TestDTO x = new TestDTO();
			
			x.setName(test.getName());
			x.setLinkMP4(test.getLinkMP4());
			x.setId(test.getId());
			x.setDateCreate(test.getDateCreate());
			return x;
		}
		return null;
	}

	@Override
	public List<TestDTO> getAllTest() {
		List<Test> lst = TestDAO.getAllTest();
		List<TestDTO> result = new ArrayList<TestDTO>();
		for (Test item : lst) {
			
			TestDTO x = new TestDTO();
			x.setId(item.getId());
			x.setName(item.getName());
			x.setLinkMP4(item.getLinkMP4());
			x.setDateCreate(item.getDateCreate());
			result.add(x);
		}
		return result;
	}
}
