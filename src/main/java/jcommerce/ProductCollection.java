package jcommerce;

import java.util.*;

public class ProductCollection {
	private ArrayList<Product> products = new ArrayList<>();
	private int capacity;
	private boolean presult;

	public ProductCollection() {
		/*
		 * products.add(new Product("Absolute Holistic Kibbles"
		 * ,"https://cdn.shopify.com/s/files/1/1149/5008/products/AbsoluteHolisticKibblesintheBagBeef_LambDogDryFood1_480x480.jpg?v=1612415262"
		 * ,
		 * "32","Crafted to meet the unique needs of your pets, this recipe provides dogs of all life stages with a high digestibility diet to reduce intestinal issues."
		 * )); products.add(new Product("Heka Grain-Free"
		 * ,"https://cdn.shopify.com/s/files/1/1149/5008/products/HekaDuck1.8kgFront.png?v=1621506213"
		 * ,
		 * "24","Heka Pet Food started when we saw a need for healthy pet food that focuses on the healing and well-being of our pets."
		 * ));
		 */

		this.capacity = 20;
	}

	public ProductCollection(int capacity) {
		this.capacity = capacity;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		if (products.size() != capacity) {
			products.add(product);
		}
	}

	public void deleteProduct(Product product) {
		products.remove(product);
	}

	public void updateProduct(Product product) {
		product.productName = "Doggy Kibble";
	}
	
	public String getThisProduct(Product product) {
		String name = product.productName;
		presult = products.contains(name);
		return name;
	}

}
