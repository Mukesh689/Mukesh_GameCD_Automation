package TS_001;

import org.openqa.selenium.By;

public class TC_010 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_010 test=new TC_010();
		
		try {
			test.setUpBrowser();
//			test.driver.get("https://game0689.netlify.app/login");
			test.driver.get("https://game0689.netlify.app/login");
			
			test.driver.findElement(By.xpath("//a[img[@alt='mail']]")).click();
			Thread.sleep(2000);
			
			String Mail="www.Email.com";
			
			String currentUrl = test.driver.getCurrentUrl();
			
			if(Mail.equals(currentUrl)) {
				
				System.out.println("The page is redirect to Email page");
			}
			else {
				System.out.println("The page is not redirect to Email page");
				test.takeScreenshot("TC_010_Failed");
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
