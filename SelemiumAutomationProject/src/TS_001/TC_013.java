package TS_001;

import org.openqa.selenium.By;

public class TC_013 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		TC_013 test=new TC_013();
		test.setUpBrowser();
		try {
		
		test.driver.get("https://game0689.netlify.app/login");
		Thread.sleep(2000);
		
		test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/a/button")).click();
		
		
		String currentUrl = test.driver.getCurrentUrl();
		String expectedurl="https://game0689.netlify.app/";
		
		if(currentUrl.equals(expectedurl)) {
			System.out.println("Test passed:The page should redirect to home page");
		}
		else {
			System.out.println("Test Failed:The page shouldn't redirect to home page ");
			test.takeScreenshot("TC_010_Failed");
		}
		}catch(Exception e) {
			System.out.println("Exception error:"+e.getMessage());
			test.takeScreenshot("Exception_msg");
		}
		finally {
		test.closeBrowser();
		}

	}

}
