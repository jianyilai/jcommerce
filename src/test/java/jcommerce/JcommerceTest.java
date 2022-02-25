package jcommerce;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class JcommerceTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		
  
  // to ensure the website loaded is the one needed to be checked
  @Test
  public void checkTitle() {
	  //Loads website as a new page
	  webDriver.navigate().to("http://localhost:8090/jcommerce/ProductServlet/dashboard");
	  
	  //Assert the title to check that the page loaded is the correct one
	  Assert.assertEquals(webDriver.getTitle(), "List of Products");
	  
	  System.out.println("page title: "+webDriver.getTitle());
  }
      
  @Test
  public void checkProduct() {
	  webDriver.navigate().to("http://localhost:8090/jcommerce/createProduct.jsp");
	  	 
	  webDriver.findElement(By.name("productName")).sendKeys("Puppia Paloma House");
	  webDriver.findElement(By.name("productImage")).sendKeys("https://cdn.shopify.com/s/files/1/1149/5008/products/Puppia-Paloma-House-for-Dogs-_2-Colors_-4.jpg?v=1600844945");
	  webDriver.findElement(By.name("productPrice")).sendKeys("99");
	  webDriver.findElement(By.name("productDescription")).sendKeys("Reversible and washable cushion. Includes free matching bone shaped toy.");
	  
	  webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
	  webDriver.navigate().to("http://localhost:8090/jcommerce/ProductServlet/dashboard");
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
