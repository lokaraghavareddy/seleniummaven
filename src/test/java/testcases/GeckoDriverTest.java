package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeckoDriverTest {
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
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		Dimension d = driver.manage().window().getSize();
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
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
		System.out.println("------------------------");
		System.out.println(System.getProperty("url"));
		
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+this.getClass().getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
		

}
