package com.shop4u.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop4u.dao.Part1DAO;
import com.shop4u.entity.Part1;

@Repository
public class Part1DAOImpl implements Part1DAO {

	@Autowired
	private SessionFactory factory;
	@Override
	public void deletePart1(int id) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			Part1 Part1 = (Part1) session.get(Part1.class, id);
			session.delete(Part1);
			tran.commit();
		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void addPart1(Part1 Part1) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			session.save(Part1);
			tran.commit();

		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void updatePart1(Part1 Part1) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			session.update(Part1);
			tran.commit();

		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Part1 getPart1ById(int id) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			Part1 Part1 = (Part1) session.get(Part1.class, id);
			tran.commit();
			return Part1;
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
	public List<Part1> getAllPart1(int idTest) {
		Session session;
		try {

			session = factory.openSession();
			
			String hql = "select * from part1 where id_Test = "+String.valueOf(idTest);
			Query query = session.createQuery(hql);
			//List results = 
			/*
			 * Criteria criteria = session.createCriteria(Part1.class);
			 * criteria.add(Restrictions.eq("id_Test", idTest));
			 */
			List<Part1> lst = query.list();
			
			return lst != null ? lst : null;
			
		} catch (HibernateException mye) {
			System.out.println(mye.getMessage());
			return null;
		}
	}

}
