package TS_006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import TS_001.ScreenShot;

public class TC_070 extends ScreenShot {

	    public static void main(String[] args) throws InterruptedException {
	        TC_070 test = new TC_070();
	        try {
	            test.setUpBrowser();
	            test.driver.get("https://game0689.netlify.app/product");
	            Thread.sleep(2000);
	            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/input")).sendKeys("add");
	            Thread.sleep(1000);
	            WebElement noResult = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/p"));
	            if (noResult.isDisplayed()) {
	                System.out.println("Test Passed: 'No results found' message displayed for invalid input.");
	            } else {
	                System.out.println("Test Failed: Error message not displayed.");
	                test.takeScreenshot("TC_070_InvalidInputFailed");
	            }
	        } catch (Exception e) {
	            System.out.println("Exception Error: " + e.getMessage());
	            test.takeScreenshot("TC_070_Exception");
	        } finally {
	            test.closeBrowser();
	        }
	    }
	}
