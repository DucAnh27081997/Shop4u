package com.shop4u.dao.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop4u.dao.UserDAO;
import com.shop4u.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void deleteUser(int id) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			User User = (User) session.get(User.class, id);
			session.delete(User);
			tran.commit();		
		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void addUser(User User) {
		Session session = factory.openSession() ;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			session.save(User);
			tran.commit();
			
		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void updateUser(User User) {
		Session session = factory.openSession() ;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			session.update(User);
			tran.commit();
			
		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}

	@Override
	public User getUserById(int id) {
		Session session = factory.openSession() ;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			User User = (User)session.get(User.class, id);
			tran.commit();
			return User;
		} catch (HibernateException mye) {
			tran.rollback();
			mye.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		Session session = factory.openSession();;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();	
			Criteria criteria = session.createCriteria(User.class);
			tran.commit();
			return criteria.list();
		} catch (HibernateException mye) {
			System.out.println(mye.getMessage());
			return null;
		}
		finally {
			session.close();
		}
	}


}
