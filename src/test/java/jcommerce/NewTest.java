package jcommerce;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		
  
//  @Test
//  public void checkId() {
//	  //Load website as a new page
//	  webDriver.navigate().to("http://localhost:8090/jcommerce/locationServlet/dashboard");
//	  WebElement we =  webDriver.findElement(By.id("content"));
//	  
//	  System.out.println("id we: "+we.getAttribute("role"));
//	  Assert.assertEquals(we.getAttribute("role"), "contentinfo");
//  }
  @Test
  public void checkTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/jcommerce/locationServlet/dashboard");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "All Shops");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Assert the new title to check that the title contain All Shops and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("All Shops"));
	  System.out.println("new title: "+webDriver.getTitle());
  }
  
  @Test
  public void navigateToCreate() {
	  //Navigate the website to the create a location
	  webDriver.navigate().to("http://localhost:8090/jcommerce/add_shop_location.jsp");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "Add Locations");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Assert the new title to check that the title contain All Shops and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Add Locations"));
	  System.out.println("new title: "+webDriver.getTitle());
  }
  
//  @Test
//  public void createLocation() {
//	  //Navigate the website to the create a location
//	  webDriver.navigate().to("http://localhost:8090/jcommerce/add_shop_location.jsp");
//	  
//	  webDriver.findElement(By.id("shopName")).sendKeys("SH Petshop");
//	  webDriver.findElement(By.id("shopImage")).sendKeys("https://cf.shopee.sg/file/f3046e761ebf9e090382f82eb225fb39");
//	  webDriver.findElement(By.id("shopLocation")).sendKeys("3 Lor Bakar Batu, #03-04A, Singapore 348741");
//	  webDriver.findElement(By.id("shopDescription")).sendKeys("SG Petshop - We are the No.1 social enterprise pet shop in Singapore. We deliver Dog Food, Cat Food, Pet Supplies, Pet Accessories, Pet Toys.");
//	  
//	  webDriver.findElement(By.xpath("/html/body/div/form/input[4]")).click();
//
//
//  }
  
//  public String generateRandomName(int length) {
//	    char[] chars =abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
//	            .toCharArray();
//	    StringBuilder sb = new StringBuilder();
//	    Random random = new Random();
//	    for (int i = 0; i < length; i++) {
//	        char c = chars[random.nextInt(chars.length)];
//	        sb.append(c);
//	    }
//	    String randomString = sb.toString();
//	    return randomString;
//	}
  
//  @Test
//  public void editLocation() {
//	  //Navigate the website to the create a location
//	  webDriver.navigate().to("http://localhost:8090/jcommerce/locationServlet/dashboard");
//	  
//	  webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[3]/td[5]/a[1]")).click();
//	  
//	  //Assert the title to check that we are indeed in the correct website
//	  Assert.assertEquals(webDriver.getTitle(), "User Management Application");
//	  
//	  
//	  webDriver.findElement(By.id("editShopName")).sendKeys("The Petshop");
//	 
//
//
//  }
  
  
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }

}