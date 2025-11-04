package TS_002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TS_001.ScreenShot;

public class TC_024 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		TC_024 test=new TC_024();
		
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
            Repassword.sendKeys("Test@2025");

            // Select Gender = Male
            WebElement genderDropdown = test.driver.findElement(By.xpath("//select[@name='gender']"));
            Select select = new Select(genderDropdown);
            select.selectByVisibleText("Male");
            
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/input")).click();

            // Click Register button
            test.driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Register')]")).click();
            Thread.sleep(2000);
            
          WebElement Errmsg = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/p[1]"));
          
          if(Errmsg.isDisplayed()) {
        	  System.out.println("Test passed:Error message is display");
          }
          else {
        	  System.out.println("Test Failed:Error message is not display");
        	  test.takeScreenshot("TC_024_Failed");
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
