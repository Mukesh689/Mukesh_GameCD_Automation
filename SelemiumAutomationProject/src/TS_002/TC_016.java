package TS_002;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_016 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		TC_016 test=new TC_016();
		
		
		 try {
	            // Setup
	            test.setUpBrowser();

	            // Step 1: Navigate to URL
	            test.driver.get("https://game0689.netlify.app/create");
	            
	            Thread.sleep(2000);

	            String actualurl = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/h1")).getText();
	            
	            String expectedurl="Create Account";

	            if (actualurl.equals(expectedurl)) {
	                System.out.println("Test Passed: Create page loaded successfully.");
	            } else {
	                throw new Exception("Test Failed: Page title mismatch.");
	            }

	        } catch (Exception e) {
	            System.out.println("Exception caught: " + e.getMessage());
	            test.takeScreenshot("Exception_Error");

	        } finally {
	            test.closeBrowser();
	        }

	}

}
