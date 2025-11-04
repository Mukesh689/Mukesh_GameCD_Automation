package TS_006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_071 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {

        TC_071 test = new TC_071();

        try {
            // Step 1: Setup browser
            test.setUpBrowser();
            test.driver.manage().window().maximize();

            // Step 2: Open the product page
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(2000);

            // Step 3: Enter lowercase search term
            WebElement searchBox = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/input"));
            searchBox.sendKeys("gta");
            Thread.sleep(1000);

            // Step 4:Capture lowercase search result
            String lowerCaseResult = test.driver.getPageSource();

            // Step 5:Clear and enter uppercase search term
            searchBox = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/input"));
            searchBox.clear();
            searchBox.sendKeys("GTA");
            Thread.sleep(1000);

            // Step 6:Capture uppercase search result
            String upperCaseResult = test.driver.getPageSource();

            // Step 7: Compare results
            if (lowerCaseResult.equals(upperCaseResult)) {
                System.out.println("Pass Tested: Search is case-insensitive.Same results for 'gta' and 'GTA'.");
            } else {
                System.out.println("Fail Tested: Search is case-sensitive.Different results for 'gta' and 'GTA'.");
                test.takeScreenshot("TC_071_Failed");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_Exception");

        } finally {
            // Step 8: Close the browser
            test.closeBrowser();
        }
    }
}
