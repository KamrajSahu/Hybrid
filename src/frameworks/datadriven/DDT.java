package frameworks.datadriven;


import java.util.Properties;

import jxl.Sheet;
import library.ReadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {

	
    WebDriver driver;
    
    Properties pro;
    
    Sheet sh1;
	@BeforeTest
	public void Setupbrowser() throws Exception{
		
        driver =new FirefoxDriver();
        pro=ReadFiles.ReadObject_Repository();
        sh1= ReadFiles.ReadExcelFiles("./testdata/facebook.xls", 1);
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		
	}
	
	
	 @Test(dataProvider="logins")
	   public void CreateAccount(String uname,String pass) throws InterruptedException{
		 
		driver.findElement(By.xpath(pro.getProperty("username.xpath"))).clear();
		driver.findElement(By.xpath(pro.getProperty("username.xpath"))).sendKeys(uname);
		
	    driver.findElement(By.xpath(pro.getProperty("password.xpath"))).clear();
		driver.findElement(By.xpath(pro.getProperty("password.xpath"))).sendKeys(pass);
		
	    String actual_title=driver.getTitle();
	    
	    
	    
	    Assert.assertEquals(actual_title,actual_title.startsWith("Welcome to facebook"));
	    	
		Thread.sleep(5000);	
	}
	 
	 
	 @DataProvider(name="logins")
	 public Object[][] provideData(){
		 
		 int row_num=sh1.getRows();
		  
		 // row and column 
		 Object[][] arr1=new Object[row_num][2];
		 
		 for(int i=0;i<row_num;i++){
			 
	     // Column and row		 
		 arr1[i][0]= sh1.getCell(0,i).getContents();
		 
		 arr1[i][1]=sh1.getCell(1,i).getContents();
		 
		 }
		 return arr1;
	 }
	
	
}
