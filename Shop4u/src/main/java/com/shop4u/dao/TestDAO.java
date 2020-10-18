package com.shop4u.dao;

import com.shop4u.entity.Test;

public interface TestDAO {
	public void addTest(Test test);
	public void updateTest(Test test);
	public void deleteTest(int id);
	public Test getTestById(int id);
	public java.util.List<Test> getAllTest();
}
