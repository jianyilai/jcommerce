

public class location {
	

	public location(String shopName, String shopImage, String shopLocation, String shopDescription) {
		super();
		this.shopName = shopName;
		this.shopImage = shopImage;
		this.shopLocation = shopLocation;
		this.shopDescription = shopDescription;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopImage() {
		return shopImage;
	}
	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}
	public String getShopLocation() {
		return shopLocation;
	}
	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}
	public String getShopDescription() {
		return shopDescription;
	}
	public void setShopDescription(String shopDescription) {
		this.shopDescription = shopDescription;
	}
	
	protected String shopName;
	protected String shopImage;
	protected String shopLocation;
	protected String shopDescription;

}
