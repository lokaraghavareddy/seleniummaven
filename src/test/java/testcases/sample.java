package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sample {
	WebDriver driver;

	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
		
	
	
	
	@Test
	public void m1() {
		
		driver.get("https://www.facebook.com");
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "LOkA");
		
	
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		
	}

}