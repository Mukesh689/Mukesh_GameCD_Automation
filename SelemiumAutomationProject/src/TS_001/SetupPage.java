package TS_001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SetupPage {
    public WebDriver driver;

    // Setup browser
    public void setUpBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\muthu\\eclipse-workspace\\SeleniumPractice\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Browser launched successfully.");
    }

    // Close browser
    public void closeBrowser() throws InterruptedException {
        if (driver != null) {
        	Thread.sleep(2000);
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}