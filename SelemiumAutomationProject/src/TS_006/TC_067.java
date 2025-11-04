package TS_006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import TS_001.ScreenShot;

public class TC_067 extends ScreenShot {
	public static void main(String[] args) throws InterruptedException {
        TC_067 test = new TC_067();

        try {
            test.setUpBrowser();
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(2000);

            WebElement searchBar = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/input"));
            if (searchBar.isDisplayed()) {
                System.out.println("Test Passed: Search bar is visible on Product page.");
            } else {
                System.out.println("Test Failed: Search bar not visible.");
                test.takeScreenshot("TC_067_SearchBarNotVisible");
            }
        } catch (Exception e) {
            System.out.println("Exception Error: " + e.getMessage());
            test.takeScreenshot("TC_0_Exception");
        } finally {
            test.closeBrowser();
        }
    }

}
