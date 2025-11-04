package TS_001;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot extends SetupPage {
	
	 public void setUpBrowser() {
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\muthu\\eclipse-workspace\\SeleniumPractice\\Drivers\\chromedriver.exe");

	        ChromeOptions options = new ChromeOptions();

	        // Disable all Chrome popups and password manager
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-save-password-bubble");
	        options.addArguments("--disable-extensions");
	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-popup-blocking");
	        options.addArguments("--remote-allow-origins=*");

	        // Disable Chrome password manager service
	        options.setExperimentalOption("prefs", Map.of(
	            "credentials_enable_service", false,
	            "profile.password_manager_enabled", false
	        ));

	        driver = new ChromeDriver(options);
	        System.out.println("Browser launched successfully.");
	    }

	 public void takeScreenshot(String testName) {
//		 driver = new ChromeDriver();
	        try {
	            Date d = new Date();
	            String Filename=d.toString().replace(":", "_").replace(" ","_")+".png";
	    		
	    		TakesScreenshot ts=(TakesScreenshot) driver;
	    		File temp=ts.getScreenshotAs(OutputType.FILE);
	    		File scrr=new File("./Screenshots/"+testName+"_"+Filename);
	    		
	    		FileHandler.copy(temp, scrr);
	            System.out.println("Screenshot saved at: "+testName+ Filename);
	        } catch (IOException e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	        }
	    }

}
