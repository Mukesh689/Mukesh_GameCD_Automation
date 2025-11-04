package TS_006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import TS_001.ScreenShot;

public class TC_069 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {
        TC_069 test = new TC_069();

        try {
            test.setUpBrowser();
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(2000);

            WebElement searchBar = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/input"));
            searchBar.sendKeys("Gr"); // partial
            Thread.sleep(1000);

            WebElement result = test.driver.findElement(By.xpath("//*[contains(text(),'Grand Theft Auto V')]"));
            if (result.isDisplayed()) {
                System.out.println(" Test Passed: Partial input displayed relevant results.");
            } else {
                System.out.println(" Test Failed: Partial input did not show expected games.");
                test.takeScreenshot("TC_069_PartialInputFailed");
            }

        } catch (Exception e) {
            System.out.println("Exception Error: " + e.getMessage());
            test.takeScreenshot("TC_069_Exception");
        } finally {
            test.closeBrowser();
        }
    }
}