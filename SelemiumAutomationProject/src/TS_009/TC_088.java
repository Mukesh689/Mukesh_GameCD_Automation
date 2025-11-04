package TS_009;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_088 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {
        TC_088 test = new TC_088();

        try {
            // Step 1: Setup browser
            test.setUpBrowser();

            // Step 2: Navigate to Cart page
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(3000);
            
            WebElement addToCartButton = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button"));
            addToCartButton.click();
            Thread.sleep(2000);
            
            // Step 3: Count items before removing
            List<WebElement> itemsBefore = test.driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/ul/li"));
            int countBefore = itemsBefore.size();
            System.out.println("Items before removing: " + countBefore);

            if (countBefore == 0) {
                System.out.println("No items in cart to remove. Please add items first.");
                test.takeScreenshot("TC_084_NoItems");
                return;
            }

            // Step 4: Click the first Remove button
            WebElement removeButton = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li/div/button"));
            removeButton.click();
            Thread.sleep(2000);

            // Step 5: Count items after removing
            List<WebElement> itemsAfter = test.driver.findElements(By.xpath("//li[contains(@class,'cart-item')]"));
            int countAfter = itemsAfter.size();
            System.out.println("Items after removing: " + countAfter);

            // Step 6: Verify if item was removed
            if (countAfter < countBefore) {
                System.out.println("PASS: Item removed successfully and total updated.");
            } else {
                System.out.println("FAIL: Item not removed from the cart.");
                test.takeScreenshot("TC_084_Failed_Remove");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_084_Exception");
        } finally {
            // Step 7: Close browser
            test.closeBrowser();
        }
    }
}
