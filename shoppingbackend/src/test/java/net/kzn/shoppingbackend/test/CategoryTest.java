package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("This is desc for good Mobile.");
		category.setImageURL("mb_image.png");
		assertEquals("Successfully added a new category", true, categoryDAO.add(category));
	}
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(3);
		assertEquals("Successfully added a new category", "Television", category.getName());
	}*/
	
	/*
	 * Updating Single Category
	 * */
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(3);
		
		category.setName("TV");
		assertEquals("Successfully updated in table",true, categoryDAO.update(category));
	}*/
	
	/*
	 * Delete Single Category
	 * */
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted in table",true, categoryDAO.delete(category));
	}*/
	
	
	
}