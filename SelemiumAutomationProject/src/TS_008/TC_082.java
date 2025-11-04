package TS_008;

//import java.util.List;

//import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import TS_001.ScreenShot;

public class TC_082 extends ScreenShot {

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
            
            test.driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
            
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button")).click();
            Thread.sleep(2000);
         
            System.out.println("Count value is increase");
            // Step 5: Count number of cart items
            
            String cartCount = test.driver.findElement(By.xpath("//li[@class='cart-item']//span")).getText();            

            // Step 6: Validate multiple items added
            if (cartCount.equals("2")) {
                System.out.println("PASS: Multiple games successfully added to cart.");
            } else {
                System.out.println("FAIL: Multiple games not added to cart.");
                test.takeScreenshot("TC_082_Failed");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_082_Exception");
        } finally {
            // Step 7: Close browser
            test.closeBrowser();
        }
    }
}
