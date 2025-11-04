package TS_001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_004 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_003 test=new TC_003();
		
		try {
			test.setUpBrowser();
			
			test.driver.get("https://game0689.netlify.app/login");
			
			test.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
//			test.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			Thread.sleep(1000);
			
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
			
			test.driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Register')]")).click();
			Thread.sleep(2000);
			
			  WebElement loginUser = test.driver.findElement(By.id("username"));
	            loginUser.sendKeys("test01");
	            
	            WebElement loginEmail = test.driver.findElement(By.id("email"));
	            loginEmail.sendKeys("test02@gmail.com");

	            WebElement loginPassword = test.driver.findElement(By.id("password"));
	            loginPassword.sendKeys("Test@2025!");

	            test.driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Login')]")).click();
	            Thread.sleep(2000);
	            		
	            WebElement Errormsg = test.driver.findElement(By.xpath("//p[contains(text(),'Invalid username, email, or password.')]"));		
	            
	            if(Errormsg.isDisplayed()) {
	            	System.out.println("Test passed:"+Errormsg.getText());
	            	
	            }
	            else {
	            	System.out.println("Test Failed: Error is not visible");
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
