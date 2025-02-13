package hooks;

import drivermanager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    DriverManager driverManager =null;
     private WebDriver   driver       = null;
    @Before
    public void setup() {
        System.out.println("This is setup method");
        driverManager = new DriverManager();
        driver =driverManager.launchBrowser("Chrome");
    }

    @After
    public void tearDown() {
        System.out.println("This is tearDown method");
        driver.quit();
    }
}
