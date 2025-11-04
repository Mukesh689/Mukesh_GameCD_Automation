package TS_008;

import org.openqa.selenium.By;

import TS_001.ScreenShot;

public class TC_083 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {

        TC_082 test = new TC_082();

        try {
            // Step 1: Setup browser
            test.setUpBrowser();
            test.driver.manage().window().maximize();

            // Step 2: Navigate to Product Page
            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(3000);
            
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button")).click();
            Thread.sleep(2000);
            
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li/div/div/button[2]")).click();
         
            System.out.println("Count value is increase");
            // Step 5: Count number of cart items
            
            String cartCount = test.driver.findElement(By.xpath("//li[@class='cart-item']//span")).getText();            

            // Step 6: Validate multiple items added
            if (cartCount.equals("2")) {
                System.out.println("PASS: Increase games successfully added to cart.");
            } else {
                System.out.println("FAIL: Increase games not added to cart.");
                test.takeScreenshot("TC_083_Failed");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_083_Exception");
        } finally {
            // Step 7: Close browser
            test.closeBrowser();
        }
    }
}