package hooks;

import drivermanager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class MyHooks {
    DriverManager driverManager =null;
     private WebDriver   driver       = null;
    @Before
    public void setup() throws MalformedURLException {
        System.out.println("This is setup method");
        driverManager = new DriverManager();
        driver =driverManager.launchBrowser("Firefox");
    }

    @After
    public void tearDown() {
        System.out.println("This is tearDown method");
        driver.quit();
    }
}
