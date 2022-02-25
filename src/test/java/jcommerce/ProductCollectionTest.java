package jcommerce;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductCollectionTest {

	private ProductCollection pc;
	private Product p1;
	private Product p2;
	private Product p3;
	private String name;

	private final int PRODUCT_COLLECTION_SIZE = 2;

	/**
	 * @throws java.lang.Exception
	 */

	@BeforeEach
	void setUp() throws Exception {
		pc = new ProductCollection();
		p1 = new Product("Absolute Holistic Kibbles",
				"https://cdn.shopify.com/s/files/1/1149/5008/products/AbsoluteHolisticKibblesintheBagBeef_LambDogDryFood1_480x480.jpg?v=1612415262",
				"32",
				"Crafted to meet the unique needs of your pets, this recipe provides dogs of all life stages with a high digestibility diet to reduce intestinal issues.");
		p2 = new Product("Heka Grain-Free",
				"https://cdn.shopify.com/s/files/1/1149/5008/products/HekaDuck1.8kgFront.png?v=1621506213", "24",
				"Heka Pet Food started when we saw a need for healthy pet food that focuses on the healing and well-being of our pets.");
		p3 = new Product("Puppia Paloma House",
				"https://cdn.shopify.com/s/files/1/1149/5008/products/Puppia-Paloma-House-for-Dogs-_2-Colors_-4.jpg?v=1600844945",
				"99", "Reversible and washable cushion. Includes free matching bone shaped toy.");

		pc.addProduct(p1);
		pc.addProduct(p2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetProducts() {
		List<Product> testPc = pc.getProducts();
		assertEquals(pc.getProducts().size(), PRODUCT_COLLECTION_SIZE);
	}

	@Test
	void testAddProduct() {
		List<Product> testPc = pc.getProducts();
		assertEquals(testPc.size(), PRODUCT_COLLECTION_SIZE);
		pc.addProduct(p3);
		assertEquals(pc.getProducts().size(), PRODUCT_COLLECTION_SIZE + 1);
	}

	@Test
	void testDeleteProduct() {
		List<Product> testPc = pc.getProducts();
		assertEquals(testPc.size(), PRODUCT_COLLECTION_SIZE);
		pc.deleteProduct(p1);
		assertEquals(pc.getProducts().size(), PRODUCT_COLLECTION_SIZE - 1);
	}

	@Test
	void testUpdateProduct() {
		List<Product> testPc = pc.getProducts();
		pc.updateProduct(p1);
		assertEquals(p1.productName, "Doggy Kibble");		
	}
	
	@Test
	void testFindProduct() {
		List<Product> testPc = pc.getProducts();
		name = pc.getThisProduct(p1);
		assertEquals(name, "Absolute Holistic Kibbles");		
	}
	
}
