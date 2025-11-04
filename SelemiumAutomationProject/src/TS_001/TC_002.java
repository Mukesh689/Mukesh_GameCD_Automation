package TS_001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//  To Enter a valid username, valid email, and valid password 
public class TC_002 extends ScreenShot {

    public static void main(String[] args) throws InterruptedException {
        TC_002 test = new TC_002();
        String expectedUrl = "https://game0689.netlify.app/";

        try {
            //  Setup browser
            test.setUpBrowser();

            //  Navigate to Login Page
            test.driver.get("https://game0689.netlify.app/login");

            //  Click Register link
            test.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
            Thread.sleep(1000);

            //  Fill Registration Form
            WebElement username = test.driver.findElement(By.id("username"));
            username.sendKeys("test01");

            WebElement email = test.driver.findElement(By.id("email"));
            email.sendKeys("test01@gmail.com");

            WebElement password = test.driver.findElement(By.id("password"));
            password.sendKeys("Test@2025!");
            
            WebElement Repassword = test.driver.findElement(By.xpath("//*[@id=\"rePassword\"]"));
            Repassword.sendKeys("Test@2025!");

            // Select Gender = Male
            WebElement genderDropdown = test.driver.findElement(By.xpath("//select[@name='gender']"));
            Select select = new Select(genderDropdown);
            select.selectByVisibleText("Male");
            
            test.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/input")).click();

            // Click Register button
            test.driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Register')]")).click();
            Thread.sleep(2000);

            // Now perform Login
            WebElement loginUser = test.driver.findElement(By.id("username"));
            loginUser.sendKeys("test01");
            
            WebElement loginEmail = test.driver.findElement(By.id("email"));
            loginEmail.sendKeys("test01@gmail.com");

            WebElement loginPassword = test.driver.findElement(By.id("password"));
            loginPassword.sendKeys("Test@2025!");

            test.driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Login')]")).click();
            Thread.sleep(2000);

            // Handle unexpected alerts (like password warnings)
            try {
                test.driver.switchTo().alert().accept();
                System.out.println("Alert closed successfully.");
            } catch (Exception noAlert) {
                System.out.println("No alert appeared after login.");
            }

            // 🔹 Validate navigation
            String currentUrl = test.driver.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Test Passed: User successfully logged in and navigated to Home Page.");
            } else {
                System.out.println("Test Failed: User not navigated to expected URL.");
                test.takeScreenshot("TC_002_Failed");
            }

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            test.takeScreenshot("TC_002_Exception");

        } finally {
            test.closeBrowser();
        }
    }
}
