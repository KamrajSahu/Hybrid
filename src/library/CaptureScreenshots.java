package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshots {
	
	
	
	public static void takescreenshot(WebDriver driver){
		
		
		 TakesScreenshot ts1=(TakesScreenshot)driver;
			
	     File src=ts1.getScreenshotAs(OutputType.FILE);
	        
	     File destination=new File("./screenshots/"+System.currentTimeMillis()+".png");
	        
	     try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
