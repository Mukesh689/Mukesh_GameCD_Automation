package TS_004;

import org.openqa.selenium.By;

import TS_001.ScreenShot;

public class TC_056 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
TC_056 test=new TC_056();
		
		try {
			test.setUpBrowser();
			
			test.driver.get("https://game0689.netlify.app/");
			Thread.sleep(2000);
			
			test.driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
		
			String currentUrl = test.driver.getCurrentUrl();			
			String exceedUrl="https://game0689.netlify.app/product";
			if(currentUrl.equals(exceedUrl)) {
				System.out.println("Test Pass:The page is redirect to product page");
			}
			else {
				System.out.println("Test Failed:The page is not redirect to product page");
				test.takeScreenshot("Test_Failed");
			}
		}
			catch(Exception e) {
	            System.out.println("Exception caught: " + e.getMessage());
	            test.takeScreenshot("Exception_Error");
			}
			finally {
				test.closeBrowser();
			}

	}

}
