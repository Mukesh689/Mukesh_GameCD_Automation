package TS_001;

import org.openqa.selenium.By;

public class TC_012 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_012 test=new TC_012();
		try {
			test.setUpBrowser();
			test.driver.get("https://game0689.netlify.app/login");
			
			test.driver.findElement(By.xpath("//a[img[@alt='facebook']]")).click();
			Thread.sleep(2000);
			
			String facebook="www.facebook.com";
			
			String currentUrl = test.driver.getCurrentUrl();
			
			if(facebook.equals(currentUrl)) {
				
				System.out.println("The page is redirect to Facebook page");
			}
			else {
				System.out.println("The page is not redirect to Facebook page");
				test.takeScreenshot("TC_012_Failed");
			}
		}
		catch(Exception e) {
			System.out.println("Exception error:"+e.getMessage());
			test.takeScreenshot("Exception_Error");
		}
		finally {
			test.closeBrowser();
		}

	}

}
