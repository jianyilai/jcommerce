


	public class Product {
		
		public Product(String productName, String productImage, String productPrice,
				String productDescription) {
			super();
			this.productName = productName;
			this.productImage = productImage;
			this.productPrice = productPrice;
			this.productDescription = productDescription;
		}
		
		protected String productName;
		protected String productImage;
		protected String productPrice;
		protected String productDescription;
		
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

