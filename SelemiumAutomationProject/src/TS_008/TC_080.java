package TS_008;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_080 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {

        TC_080 test = new TC_080();

        try {
            // Step 1: Setup browser
            test.setUpBrowser();
            test.driver.manage().window().maximize();

            // Step 2: Navigate to Product Page
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(3000);

            // Step 3: Click “Add to Cart” on the first visible game card
            WebElement addToCartButton = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button"));
            addToCartButton.click();
            Thread.sleep(2000); // wait for cart update
            
            String cartname = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[1]/div/h3[1]")).getText();
            
            String cartitem = "Watch Dogs: Legion";

            if (cartitem.equals(cartname)) {
                System.out.println("PASS: Game successfully added to cart.");
            } else {
                System.out.println("FAIL: Game not visible in cart.");
                test.takeScreenshot("TC_AddToCart_Failed");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_AddToCart_Exception");

        } finally {
            // Step 6: Close browser
            test.closeBrowser();
        }
    }
}