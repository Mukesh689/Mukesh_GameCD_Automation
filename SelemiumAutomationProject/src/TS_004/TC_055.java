package TS_004;

import org.openqa.selenium.By;

import TS_001.ScreenShot;

public class TC_055 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
TC_055 test=new TC_055();
		
		try {
			test.setUpBrowser();
			
			test.driver.get("https://game0689.netlify.app/product");
			Thread.sleep(2000);
			
			test.driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[1]")).click();
		
			String currentUrl = test.driver.getCurrentUrl();			
			String exceedUrl="https://game0689.netlify.app/";
			if(currentUrl.equals(exceedUrl)) {
				System.out.println("Test Pass:The page is redirect to home page");
			}
			else {
				System.out.println("Test Failed:The page is not redirect to home page");
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
