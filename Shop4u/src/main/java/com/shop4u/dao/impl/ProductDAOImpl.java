package com.shop4u.dao.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop4u.dao.ProductDAO;
import com.shop4u.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void deleteProduct(int id) {
		Session session = factory.openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			Product product = (Product) session.get(Product.class, id);
			session.delete(product);
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
	public void addProduct(Product product) {
		Session session = factory.openSession() ;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			session.save(product);
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
	public void updateProduct(Product product) {
		Session session = factory.openSession() ;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			session.update(product);
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
	public Product getProductById(int id) {
		Session session = factory.openSession() ;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();					
			Product product = (Product)session.get(Product.class, id);
			tran.commit();
			return product;
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
	public List<Product> getAllProduct() {
		Session session;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			return criteria.list();
		} catch (HibernateException mye) {
			System.out.println(mye.getMessage());
			return null;
		}
	}

}
