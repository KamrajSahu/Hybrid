package AdvanceSelenium;

import java.io.File;

import library.CaptureScreenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class Testfacebook {
	
	
	@Test
	public void Test1() throws Exception{
			
	
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
	 
		CaptureScreenshots.takescreenshot(driver);
		
		driver.findElement(By.id("email")).sendKeys("testemail@gmail.com");
		
		CaptureScreenshots.takescreenshot(driver);
		
		driver.findElement(By.id("pass")).sendKeys("testemail@gmail.com");
		
		CaptureScreenshots.takescreenshot(driver);
		
		driver.findElement(By.id("loginbutton")).click();
		
		CaptureScreenshots.takescreenshot(driver);
		
	}

}
