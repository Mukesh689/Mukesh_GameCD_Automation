package TS_010;

import org.openqa.selenium.By;
import TS_001.ScreenShot;

public class TC_092 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {
        TC_092 test = new TC_092();

        try {
            test.setUpBrowser();
            test.driver.manage().window().maximize();

            test.driver.get("https://game0689.netlify.app/product");
            Thread.sleep(3000);

            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button")).click();
            test.driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/button")).click();
            Thread.sleep(2000);

            String displayedTotal = test.driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/h3")).getText();
            System.out.println(displayedTotal.trim());

            String Total = "Total: $86.22";
            System.out.println(Total);

            if (displayedTotal.trim().equals(Total)) {
                System.out.println("PASS: Total price correctly reflects sum of all items.");
            } else {
                System.out.println("FAIL: Total price mismatch");
                test.takeScreenshot("TC_092_TotalMismatch");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            test.takeScreenshot("TC_092_Exception");
        } finally {
            test.closeBrowser();
        }
    }
}
