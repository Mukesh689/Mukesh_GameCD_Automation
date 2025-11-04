package TS_010;

import org.openqa.selenium.By;

import TS_001.ScreenShot;

public class TC_093 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {
        TC_093 test = new TC_093();

        try {
            // Step 1: Setup browser
            test.setUpBrowser();
            test.driver.manage().window().maximize();

            // Step 2: Navigate to Product page and add an item to cart
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(3000);

            // Add the first product
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button")).click();
            Thread.sleep(2000);

            // Step 3: Get initial total value
            String initialTotal = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/h3")).getText();
            System.out.println("Initial Total: " + initialTotal);

            // Step 4: Increase quantity (click + button)
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li/div/div/button[2]")).click();
            Thread.sleep(2000);

            // Step 5: Get updated total value
            String updatedTotal = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/h3")).getText();
            System.out.println("Updated Total after increasing quantity: " + updatedTotal);

            // Step 6: Validate if total has changed
            if (!initialTotal.equals(updatedTotal)) {
                System.out.println("PASS: Total updates correctly after changing quantity.");
            } else {
                System.out.println("FAIL: Total did not update after changing quantity.");
                test.takeScreenshot("TC_093_Failed");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_093_Exception");
        } finally {
            test.closeBrowser();
        }
    }
}
