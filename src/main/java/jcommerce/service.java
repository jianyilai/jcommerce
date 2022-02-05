package jcommerce;

public class service {
	public service(String serviceName, String serviceImage, String servicePrice, String serviceDescription) {
		super();
		this.serviceName = serviceName;
		this.serviceImage = serviceImage;
		this.servicePrice = servicePrice;
		this.serviceDescription = serviceDescription;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceImage() {
		return serviceImage;
	}
	public void setServiceImage(String serviceImage) {
		this.serviceImage = serviceImage;
	}
	public String getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	protected String serviceName;
	 protected String serviceImage;
	 protected String servicePrice;
	 protected String serviceDescription;
	
}
