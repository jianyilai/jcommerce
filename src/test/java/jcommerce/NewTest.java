package jcommerce;

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test
	public void checkTitle() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/jcommerce/ProductServlet/dashboard");
		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "Products");

		System.out.println("title: " + webDriver.getTitle());
	}
	
	@Test
	public void addAccount() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/jcommerce/register.jsp");

		// Fill in form with credentials and click submit
		webDriver.findElement(By.name("username")).sendKeys("NewTest");

		webDriver.findElement(By.name("password")).sendKeys("NewTest");

		webDriver.findElement(By.name("email")).sendKeys("test@email.com");

		webDriver.findElement(By.xpath("//form/input[4]")).click();

	}

	@Test
	public void checkLogin() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/jcommerce/login.jsp");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "Login");

		System.out.println("title: " + webDriver.getTitle());

		// Fill in form with credentials and click submit
		webDriver.findElement(By.name("username")).sendKeys("NewTest");

		webDriver.findElement(By.name("password")).sendKeys("NewTest");

		webDriver.findElement(By.className("btn")).click();

		// Assert the title to check that we are indeed logged in
		Assert.assertEquals(webDriver.getTitle(), "Products");
		System.out.println("new title: " + webDriver.getTitle());
	}
	
	@Test
	public void deleteAccount() {
		webDriver.navigate().to("http://localhost:8090/jcommerce/AccountServlet/dashboard");
		webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[4]/a[2]")).click();
	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Users\\jimmy\\Downloads\\chromedriver_win32\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.quit();
	}

}