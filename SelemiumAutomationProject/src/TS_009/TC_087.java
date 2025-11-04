package TS_009;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_087 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {
        TC_087 test = new TC_087();

        try {
           
            test.setUpBrowser();
            test.driver.manage().window().maximize();

            // Step 2: Open Cart page
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(3000);
            
            WebElement addToCartButton = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button"));
            addToCartButton.click();
            Thread.sleep(2000);
            
            // Step 3: Find all remove buttons in the cart
            List<WebElement> removeButtons = test.driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/ul/li/div/button"));

            
            if (removeButtons.size() > 0) {
                boolean allVisible = true;

                for (WebElement btn : removeButtons) {
                    if (!btn.isDisplayed()) {
                        allVisible = false;
                        break;
                    }
                }
                if (allVisible) {
                    System.out.println("PASS: Remove button is displayed for each item in the cart.");
                } else {
                    System.out.println("FAIL: Some Remove buttons are not visible.");
                    test.takeScreenshot("TC_087_Failed_Visibility");
                }

            } else {
                System.out.println("FAIL: No Remove buttons found in the cart.");
                test.takeScreenshot("TC_087_NoRemoveButtons");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_087_Exception");
        } finally {
            // Step 5: Close the browser
            test.closeBrowser();
        }
    }
}
