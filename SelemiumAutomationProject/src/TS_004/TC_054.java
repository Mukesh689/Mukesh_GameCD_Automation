package TS_004;

import org.openqa.selenium.By;

import TS_001.ScreenShot;

public class TC_054 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_054 test=new TC_054();
		
		try {
			test.setUpBrowser();
			
			test.driver.get("https://game0689.netlify.app/");
			
			boolean Hdisplayed = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/nav")).isDisplayed();
			
			if(Hdisplayed) {
				System.out.println("Test Passed:Nav bar is visible in home");
			}
			else {
				System.out.println("Test Failed:Nav is not visible in home");
				test.takeScreenshot("Test_Failed");
			}
			
			test.driver.get("https://game0689.netlify.app/product");
			
            boolean Pdisplayed = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/nav")).isDisplayed();
			
			if(Pdisplayed) {
				System.out.println("Test Passed:Nav bar is visible in product");
			}
			else {
				System.out.println("Test Failed:Nav is not visible in product");
				test.takeScreenshot("Test_Failed");
			}
			
			test.driver.get("https://game0689.netlify.app/contact");
           boolean Cdisplayed = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/nav")).isDisplayed();
			
			if(Cdisplayed) {
				System.out.println("Test Passed:Nav bar is visible in contact");
			}
			else {
				System.out.println("Test Failed:Nav is not visible in contact");
				test.takeScreenshot("Test_Failed");
			}	
			
		}catch(Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            test.takeScreenshot("Exception_Error");
		}
		finally {
			test.closeBrowser();
		}
		

	}

}
