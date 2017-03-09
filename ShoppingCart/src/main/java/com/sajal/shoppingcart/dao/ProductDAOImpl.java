package com.sajal.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sajal.shoppingcart.model.Product;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	Session ss=sessionFactory.getCurrentSession();

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Product> product() {
		return ss.createQuery("from Product").list();
	}

	public boolean save(Product product) {
		try {
			ss.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			ss.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			ss.delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		try {
			ss.delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByID(String id) {
		return (Product) ss.createQuery("from Product where id = '" + id + "'")
				.uniqueResult();
	}

	public Product getProductByName(String name) {
		return (Product) ss.createQuery("from Product where name = '" + name + "'")
				.list().get(0);
	}

}