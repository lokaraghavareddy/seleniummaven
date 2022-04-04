package testcases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptureScreenshots {
	WebDriver driver ;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void firefoxTest() {
		
		driver.get("https://www.facebook.com");
		driver.navigate().to("https://www.gmail.com");
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		Dimension d = driver.manage().window().getSize();
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(800,800));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getCurrentUrl());
		List<WebElement> ele = driver.findElements(By.xpath("//a"));
		Iterator<WebElement> it = ele.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getAttribute("href"));
		}
		//Assert.assertEquals(driver.getCurrentUrl(), "LOkA");
		
	
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
		

}
