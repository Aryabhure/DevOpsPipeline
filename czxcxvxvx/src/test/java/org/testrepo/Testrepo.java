package org.testrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testrepo {
	WebDriver driver;
	ChromeOptions options;
	
	@BeforeMethod
	public void setup() {
		options= new ChromeOptions();
		 options.addArguments("--headless=new");
		 options.addArguments("--window-size=1920,1000");
		 
		 options.addArguments("--disable-dev-shm-usage");
		 options.addArguments("--no sandbox");
		 options.addArguments("--disbale-gpu");
		 
		 options.addArguments("--remote-allow-origins=");
		 
		 driver= new ChromeDriver(options);
		 
		 driver.manage().window()
		      .setSize(new Dimension(1920,1000));
		 driver=new ChromeDriver();
		 driver.get("https://testpages.eviltester.com/reference/other-sites/");
		 driver.manage().deleteAllCookies();
	}
	
	@Test
	public void TC001 () {
		WebElement PageBtn = driver.findElement(By.linkText("Reference Information and Tutorials"));
		PageBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.eviltester.com/reference/");
	}
	
	@AfterMethod
	public void tearDown () {
		driver.quit();
	}

}
