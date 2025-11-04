package TS_002;

import org.openqa.selenium.By;
import TS_001.ScreenShot;

public class TC_026 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {
        TC_026 test = new TC_026();

        try {
            // 1️. Launch browser
            test.setUpBrowser();

            // 2️. Open the Create page
            test.driver.get("https://game0689.netlify.app/create");
            Thread.sleep(2000);

            // 3️. Click on Gmail link icon
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[6]/a[2]/img")).click();
            Thread.sleep(3000); // wait for redirect

            // 4️. Get the redirected URL
            String currentUrl = test.driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);

            if (currentUrl.equals("//*[@id=\"root\"]/div/div/form/div[6]/a[1]/img")) {
                System.out.println("Test Passed:The page is redirected to Gmail successfully.");
            } else {
                System.out.println("Test Failed:The page is NOT redirected to Gmail.");
                test.takeScreenshot("TC_026_GmailRedirectFailed");
            }

        } catch (Exception e) {
            System.out.println("Exception Occurred: " + e.getMessage());
            test.takeScreenshot("TC_026_Exception");
        } finally {
            // 6️⃣ Close browser
            test.closeBrowser();
        }
    }
}
