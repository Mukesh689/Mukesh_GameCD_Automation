package TS_002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TS_001.ScreenShot;

public class TC_017 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		 TC_017 test = new TC_017();
	        

	        try {
	            //  Setup browser
	            test.setUpBrowser();

	            //  Navigate to Login Page
	            test.driver.get("https://game0689.netlify.app/create");

	            //  Fill Registration Form
	            WebElement username = test.driver.findElement(By.id("username"));
	            username.sendKeys("test01");

	            WebElement email = test.driver.findElement(By.id("email"));
	            email.sendKeys("test01@gmail.com");

	            WebElement password = test.driver.findElement(By.id("password"));
	            password.sendKeys("Test@2025!");
	            
	            WebElement Repassword = test.driver.findElement(By.xpath("//*[@id=\"rePassword\"]"));
	            Repassword.sendKeys("Test@2025!");

	            // Select Gender = Male
	            WebElement genderDropdown = test.driver.findElement(By.xpath("//select[@name='gender']"));
	            Select select = new Select(genderDropdown);
	            select.selectByVisibleText("Male");
	            
	            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/input")).click();

	            // Click Register button
	            test.driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Register')]")).click();
	            Thread.sleep(2000);
	            
	            String Actuaurl="https://game0689.netlify.app/login";
	            
				String currentUrl = test.driver.getCurrentUrl();
				
				if(currentUrl.equals(Actuaurl)) {
					System.out.println("Test Passed: User successfully logged in and navigated to login Page.");
				}else {
					 System.out.println("Test Failed: User not navigated to expected URL.");
		                test.takeScreenshot("TC_017_Failed");
				}
	            
	        }
	        catch(Exception e) {
	        	System.out.println("Exception caught: " + e.getMessage());
	            test.takeScreenshot("TC_002_Exception");
	        }
	        finally {
	        	test.closeBrowser();
	        }

	}

}
