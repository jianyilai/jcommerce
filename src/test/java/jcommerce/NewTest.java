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

  @Test(priority = 1)
  public void checkTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/jcommerce/locationServlet/dashboard");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "All Shops");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Assert the new title to check that the title contain All Shops and the button
	  //had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("All Shops"));
	  System.out.println("new title: "+webDriver.getTitle());
  }
  
  @Test(priority = 2)
  public void navigateToCreate() {
	  //Navigate the website to the create a location
	  webDriver.navigate().to("http://localhost:8090/jcommerce/add_shop_location.jsp");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "Add Locations");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Assert the new title to check that the title contain Add Locations
	  //and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Add Locations"));
	  System.out.println("new title: "+webDriver.getTitle());
  }
  
  @Test(priority = 3)
  public void createLocation() {
	  //Navigate the website to the create a location
	  webDriver.navigate().to("http://localhost:8090/jcommerce/add_shop_location.jsp");
	  
	  //input data in input boxes to create a new location
	  webDriver.findElement(By.id("shopName")).sendKeys("SG Petshop");
	  webDriver.findElement(By.id("shopImage")).sendKeys("https://cf.shopee.sg/file/f3046e761ebf9e090382f82eb225fb39");
	  webDriver.findElement(By.id("shopLocation")).sendKeys("3 Lor Bakar Batu, #03-04A, Singapore 348741");
	  webDriver.findElement(By.id("shopDescription")).sendKeys("SG Petshop - We are the No.1 social enterprise pet shop in Singapore. We deliver Dog Food, Cat Food, Pet Supplies, Pet Accessories, Pet Toys.");
	  
	  //click on the send to servlet button to put data into the database
	  webDriver.findElement(By.xpath("/html/body/div/form/input[4]")).click();


  }
  

  @Test(priority = 4)
  public void editLocation() {
	  //Navigate the website to the create a location
	  webDriver.navigate().to("http://localhost:8090/jcommerce/locationServlet/dashboard");
	  
	  //click on the edit button to bring user to the edit page
	  webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[3]/td[5]/a[1]")).click();
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "User Management Application");
	  
	  //clears out the previous input and input a new set of data
	  webDriver.findElement(By.id("editShopName")).clear();
	  webDriver.findElement(By.id("editShopName")).sendKeys("The Petshop");
	  
	  //click on the update button
	  webDriver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();


  }
  
  @Test(priority = 5)
  public void deleteLocation() {
	  //Navigate the website to the location servlet and make sure it is in the correct page
	  webDriver.navigate().to("http://localhost:8090/jcommerce/locationServlet/dashboard");
	  Assert.assertEquals(webDriver.getTitle(), "All Shops");

	  // click on the delete button
	  webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[3]/td[5]/a[2]")).click();
	  
	  

  }
  
  
  
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