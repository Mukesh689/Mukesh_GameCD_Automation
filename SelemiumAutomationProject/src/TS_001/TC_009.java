package TS_001;

import org.openqa.selenium.By;

public class TC_009 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
		
		TC_009 test=new TC_009();
		
		test.setUpBrowser();
		
		try {
			
			test.driver.get("https://game0689.netlify.app/login");
			Thread.sleep(2000);
			test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/p/a")).click();
			
			String currenturl="https://game0689.netlify.app/create";			
			String Expectedurl = test.driver.getCurrentUrl();
			
			if(currenturl.equals(Expectedurl)) {
				System.out.println("Test passed:The page should redirect to create page");
			}
			else {
			System.out.println("Test Failed:The page shouldn't redirect to create page ");
			test.takeScreenshot("TC+009_Failed");
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
