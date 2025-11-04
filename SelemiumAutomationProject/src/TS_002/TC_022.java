package TS_002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TS_001.ScreenShot;

public class TC_022 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_022 test=new TC_022();
		
		try {
			test.setUpBrowser();
			
			test.driver.get("https://game0689.netlify.app/create");
			
			 WebElement genderDropdown = test.driver.findElement(By.xpath("//select[@name='gender']"));
	         Select select1 = new Select(genderDropdown);
	         select1.selectByVisibleText("Male");
	         
	         if(genderDropdown.isDisplayed()) {
	        	 System.out.println("Test passed: Male gender is visible");
	         }
	         else {
	        	 System.out.println("Test Failed:Male is not visible");
	        	 test.takeScreenshot("TC_022_Failed ");
	         }  
	            
		}catch(Exception e) {
			System.out.println("Exception msg:"+e.getMessage());
			test.takeScreenshot("Exception Error");
	}
		finally {
			test.closeBrowser();
		}

}
}