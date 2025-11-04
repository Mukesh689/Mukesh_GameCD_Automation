package TS_001;

//To Check the Login Page load
public class TC_001 extends ScreenShot {
	public static void main(String[] args) throws InterruptedException {

        TC_001 test = new TC_001();

        try {
            // Setup
            test.setUpBrowser();

            // Step 1: Navigate to URL
            test.driver.get("https://game0689.netlify.app/login");
            System.out.println("Navigated to Login Page");

            // Step 2: Validate Title
            String expectedTitle = "CD Games";
            String actualTitle = test.driver.getTitle();

            System.out.println("Page Title: " + actualTitle);

            if (actualTitle.contains(expectedTitle)) {
                System.out.println("Test Passed: Login page loaded successfully.");
            } else {
                throw new Exception("Test Failed: Page title mismatch.");
            }

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            test.takeScreenshot("TC_001");

        } finally {
            test.closeBrowser();
        }
   
	} 
    }


