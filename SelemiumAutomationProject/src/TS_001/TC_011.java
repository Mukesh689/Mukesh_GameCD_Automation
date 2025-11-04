package TS_001;

import org.openqa.selenium.By;

public class TC_011 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_011 test=new TC_011();
		try {
			test.setUpBrowser();
			test.driver.get("https://game0689.netlify.app/login");
			
			test.driver.findElement(By.xpath("//a[img[@alt='gmail']]")).click();
			Thread.sleep(2000);
			
			String gmail="www.gmail.com";
			String currentUrl = test.driver.getCurrentUrl();
			
			if(gmail.equals(currentUrl)) {
				System.out.println("The page is redirect to gmail page");
			}
			else {
				System.out.println("The page is not redirect to gmail page");
				test.takeScreenshot("TC_011_Failed");
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