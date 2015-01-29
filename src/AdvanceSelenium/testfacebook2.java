package AdvanceSelenium;

import java.io.File;

import library.CaptureScreenshots;
import library.Submit;
import library.Textbox;
import library.dropdown;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class testfacebook2 {
	
	// How to implement moduler approach
	
	
	@Test
	public void Test1() throws Exception{
			
	
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
	 
		CaptureScreenshots.takescreenshot(driver);
		
		Textbox.typeById(driver, "email", "Selenium@gmail.com");
				
		CaptureScreenshots.takescreenshot(driver);
		
		Textbox.typeById(driver, "pass", "password");
		
		CaptureScreenshots.takescreenshot(driver);
		
		Submit.clickById(driver, "loginbutton");
		
		CaptureScreenshots.takescreenshot(driver);
		
		dropdown.selectByIdAndIndex(driver, "day", 5);
		
	}

}
