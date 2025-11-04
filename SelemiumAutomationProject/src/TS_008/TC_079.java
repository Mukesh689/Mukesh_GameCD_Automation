package TS_008;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TS_001.ScreenShot;

public class TC_079 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {

        TC_079 test = new TC_079();

        try {
            // Step 1: Set up browser
            test.setUpBrowser();
            test.driver.manage().window().maximize();

            // Step 2: Navigate to Product Page
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(3000);

            // Step 3: Find all game cards
            List<WebElement> gameCards = test.driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div/div[4]"));
            
            if (gameCards.isEmpty()) {
                System.out.println("FAIL: No game cards found on the page.");
                test.takeScreenshot("TC_AddToCart_NoCards");
            } else {
                System.out.println("Found " + gameCards.size() + " game cards. Checking 'Add to Cart' buttons...");
                boolean allHaveButton = true;
                // Step 4: Loop through each game card and check for Add to Cart button
                for (int i = 0; i < gameCards.size(); i++) {
                    WebElement card = gameCards.get(i);
                    List<WebElement> addToCartButtons = card.findElements(By.xpath(".//button[contains(text(),'Add to Cart')]"));

                    if (addToCartButtons.isEmpty()) {
                        System.out.println("❌ FAIL: 'Add to Cart' button missing in card #" + (i + 1));
                        allHaveButton = false;
                    }
                }
                // Step 5: Print final result
                if (allHaveButton) {
                    System.out.println("PASS: 'Add to Cart' button is visible on every game card.");
                } else {
                    System.out.println("FAIL: Some game cards do not have 'Add to Cart' button.");
                    test.takeScreenshot("TC_AddToCart_MissingButtons");
                }
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
