package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTest {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testAddProduct() {
		product = new Product();
		
		product.setName("iPad");
		product.setDescription("This is desc for good iPad.");
		product.setBrand("Apple");
		assertEquals("Successfully added a new category", true, productDAO.add(product));
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
