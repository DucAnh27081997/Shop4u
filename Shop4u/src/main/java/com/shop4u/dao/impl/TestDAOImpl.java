package com.shop4u.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop4u.dao.TestDAO;
import com.shop4u.entity.Test;

@Repository
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SessionFactory factory;
	@Override
	public void deleteTest(int id) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			Test Test = (Test) session.get(Test.class, id);
			session.delete(Test);
			tran.commit();
		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void addTest(Test Test) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			session.save(Test);
			tran.commit();

		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateTest(Test test) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			session.update(test);
			tran.commit();

		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Test getTestById(int id) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			Test test = (Test) session.get(Test.class, id);
			tran.commit();
			return test;
		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getAllTest() {
		Session session;
		try {

			session = factory.openSession();
			Criteria criteria = session.createCriteria(Test.class);
			List<Test> lst = criteria.list();
			return lst != null ? lst : null;
			
		} catch (HibernateException mye) {
			System.out.println(mye.getMessage());
			return null;
		}
	}

}
