package TS_004;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_058 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_058 test=new TC_058(); 
		
		 try {
	            // 1️.Launch browser
	            test.setUpBrowser();

	            // 2️. Open the home page
	            test.driver.get("https://game0689.netlify.app/");
	            Thread.sleep(2000);

	            WebElement navbar = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/nav"));
	            Thread.sleep(2000);
	            
	            JavascriptExecutor js = (JavascriptExecutor) test.driver;
	            js.executeScript("window.scrollBy(0, 1500)");
	            Thread.sleep(2000);
	            
	            if (navbar.isDisplayed()) {
	                System.out.println("Test Passed: Navbar is not visible after scrolling.");
	                test.takeScreenshot("TC_Navbar_Not_Displayed");
	            } else {
	                System.out.println(" Test Failed: Navbar is visible after scrolling.");
	            }

	        } catch (Exception e) {
	            System.out.println("Exception Error: " + e.getMessage());
	            test.takeScreenshot("TC_NavbarFixed_Exception");
	        } finally {
	            test.closeBrowser();
	        }
	}
}
