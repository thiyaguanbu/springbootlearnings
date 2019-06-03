package com.springbootswagger.example;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springbootswagger.example.model.Product;
import com.springbootswagger.example.repository.ProductJpaRepository;
import com.springbootswagger.example.services.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSwaggerApplicationTests {
	
	
	
	@Autowired
	ProductJpaRepository repository;
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Test
	@Transactional
	public void testSave() {
		Product p = new Product();
		p.setId(35);
		p.setDescription("androidphone");
		p.setImageUrl("www.flipkart.com/androidphone1");
		p.setPrice(new BigDecimal("1000"));
		p.setProductId("v2");
		p.setVersion(9);
		repository.save(p);
		Product resultProduct = productServiceImpl.getProductById(35);
		assertNotNull(resultProduct);
		assertEquals("androidphone", resultProduct.getDescription());
	}
	
	@Test
	@Transactional
	public void testGetandSaveandDelete() {
		Product p = new Product();
		p.setId(35);
		p.setDescription("androidphone");
		p.setImageUrl("www.flipkart.com/androidphone1");
		p.setPrice(new BigDecimal("1000"));
		p.setProductId("v2");
		p.setVersion(9);
		repository.saveAndFlush(p);
		Product resultProduct = productServiceImpl.getProductById(35);
		assertNotNull(resultProduct);
		assertEquals("androidphone", resultProduct.getDescription());
		productServiceImpl.deleteProduct(35);
	}
	
	
	
	@Test
	@Transactional
	public void testFindById() {
		Product p = new Product();
		Product resultProduct = productServiceImpl.getProductById(25);
		assertNotNull(resultProduct);
		assertEquals("headphone", resultProduct.getDescription());
	}
	
	
	@Test
	public void contextLoads() {
	}

}
