package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	static {
		
		Product product = new Product();
		
		//Adding First Category
		product.setId(1);
		product.setName("Television");
		product.setDescription("This is desc for good television.");
		product.setBrand("Sony");
	
		//Second category
		product = new Product();
		product.setId(2);
		product.setName("CDPlayer");
		product.setDescription("This is desc for good cd player.");
		product.setBrand("Sony");
		
		//Third category
		product = new Product();
		product.setId(3);
		product.setName("Mobile");
		product.setDescription("This is desc for good Mobile.");
		product.setBrand("LG");

	}

	/*
	 * Get Product
	 * */
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory
					.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * List Products
	 * */
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product", Product.class)
						.getResultList();
	}

	/*
	 * Add Product
	 * */
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * Update Product
	 * */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * Delete Product
	 * */
	@Override
	public boolean delete(Product product) {
		
		try {
			product.setActive(false);
			return this.update(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		
		System.out.println("List of Active Products");
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return (List<Product>) sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class).setParameter("active", true)
					.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return (List<Product>) sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductsByCategory, Product.class).setParameter("active", true).setParameter("categoryId", categoryId)
					.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return (List<Product>) sessionFactory.getCurrentSession()
				.createQuery("FROM Product ORDER BY id WHERE active = :active", Product.class).setParameter("active", true)
					.setFirstResult(0).setMaxResults(count)
						.getResultList();
	}

}
