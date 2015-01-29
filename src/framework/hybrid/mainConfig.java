

package framework.hybrid;

import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import library.Openapp;
import library.ReadFiles;
import library.Submit;
import library.Textbox;
import library.dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mainConfig {
	
	Sheet sh;
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
	sh=ReadFiles.ReadExcelFiles("./testdata/input.xls", 1);
	driver=new FirefoxDriver();	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void readHybrid(){
		
		int rows=sh.getRows();
		for(int i=1;i<rows;i++){
			
			String object_type=sh.getCell(0,i).getContents();
			String locator_type=sh.getCell(1,i).getContents();
			String locator_value=sh.getCell(2,i).getContents();
			String action=sh.getCell(3,i).getContents();
			String actual_data=sh.getCell(4,i).getContents();
			String discription=sh.getCell(0,i).getContents();
			
			if(object_type.equalsIgnoreCase("url")){
				
				Openapp.openUrl(driver, actual_data);
			}
			
			if(object_type.equalsIgnoreCase("textbox")){
				
				if(locator_type.equalsIgnoreCase("xpath")){
					
					Textbox.typeBXpath(driver, locator_value, actual_data);
				}
				
                  if(locator_type.equalsIgnoreCase("id")){
					
					Textbox.typeById(driver, locator_value, actual_data);
				}
				
			}
			
			if(object_type.equalsIgnoreCase("submit")){
				
				if(locator_type.equalsIgnoreCase("xpath")){
					Submit.clickByXpath(driver, locator_value);
				}
				
				if(locator_type.equalsIgnoreCase("id")){
					Submit.clickById(driver, locator_value);
			}
				if(locator_type.equalsIgnoreCase("name")){
					Submit.clickByName(driver, locator_value);
			}
			
			
		}
			
if(object_type.equalsIgnoreCase("tab")){
				
				if(locator_type.equalsIgnoreCase("xpath")){
					Submit.clickByXpath(driver, locator_value);
				}
				
				if(locator_type.equalsIgnoreCase("id")){
					Submit.clickById(driver, locator_value);
			}
			
			
		}
			
			if(object_type.equalsIgnoreCase("dropdown")){
				
				if(locator_type.equalsIgnoreCase("id")){
					
					if(action.equalsIgnoreCase("index")){
						
					int index_dd=Integer.parseInt(actual_data);
						
						dropdown.selectByIdAndIndex(driver, locator_value, index_dd);
					}
					

					if(action.equalsIgnoreCase("value")){
						
						dropdown.selectByIdAndvalue(driver, locator_value, actual_data);
					}
					
	                if(action.equalsIgnoreCase("visibletext")){
						
						dropdown.selectByIdAndVisibleText(driver, locator_value, actual_data);
					}
					
					
				}
if(locator_type.equalsIgnoreCase("name")){
					
					if(action.equalsIgnoreCase("index")){
						
					int index_dd=Integer.parseInt(actual_data);
						
						dropdown.selectByNameAndIndex(driver, locator_value, index_dd);
					}
					

					if(action.equalsIgnoreCase("value")){
						
						dropdown.selectByNameAndvalue(driver, locator_value, actual_data);
					}
					
	                if(action.equalsIgnoreCase("visibletext")){
						
						dropdown.selectByNameAndVisibleText(driver, locator_value, actual_data);
					}
					
					
				}
			}
		
		
		
	}

	}
}