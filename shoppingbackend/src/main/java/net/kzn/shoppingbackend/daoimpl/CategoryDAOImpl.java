package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categories = new ArrayList<Category>();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	static {
		
		Category category = new Category();
		
		//Adding First Category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is desc for good television.");
		category.setImageURL("image.png");
		categories.add(category);
	
		//Second category
		category = new Category();
		category.setId(2);
		category.setName("CDPlayer");
		category.setDescription("This is desc for good cd player.");
		category.setImageURL("cd_image.png");
		categories.add(category);
		
		//Third category
		category = new Category();
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("This is desc for good Mobile.");
		category.setImageURL("mb_image.png");
		categories.add(category);
	}
			
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "From Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		
		//Getting single category from DB
		return (Category) sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		
		try{
			//Add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		
		try{
			//Update the category
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		
		try{
			//Disable the category
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}