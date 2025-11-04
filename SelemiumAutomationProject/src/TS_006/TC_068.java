package TS_006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_068 extends ScreenShot {

	public static void main(String[] args) throws InterruptedException {
        TC_068 test = new TC_068();

        try {
            test.setUpBrowser();
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(2000);

            WebElement searchBar = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/input"));
            searchBar.sendKeys("Forza Horizon 5");
            Thread.sleep(1000);

//            WebElement searchBtn = test.driver.findElement(By.xpath("//button[contains(text(),'Search') or @type='submit']"));
//            searchBtn.click();
//            Thread.sleep(2000);

            WebElement result = test.driver.findElement(By.xpath("//*[contains(text(),'Forza Horizon 5')]"));
            if (result.isDisplayed()) {
                System.out.println("Test Passed: Search returned correct results for .");
            } else {
                System.out.println("Test Failed: No correct results displayed.");
                test.takeScreenshot("TC_068_SearchFailed");
            }

        } catch (Exception e) {
            System.out.println("Exception Error: " + e.getMessage());
            test.takeScreenshot("TC_068_Exception");
        } finally {
            test.closeBrowser();
        }
	}
}
