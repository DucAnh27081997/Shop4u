package com.shop4u.service;
import com.shop4u.Model.TestDTO;

public interface TestService {
	public void addTest(TestDTO x);

	public void updateTest(TestDTO x);

	public void deleteTest(int id);

	public TestDTO getTestById(int id);

	public java.util.List<TestDTO> getAllTest();
	
}
