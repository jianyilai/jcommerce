package jcommerce;

public class Product {
	
	public Product(String productName, String productImage, String productPrice,
			String productDescription) {
		super();
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}
	
	private String productName;
	private String productImage;
	private String productPrice;
	private String productDescription;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}

