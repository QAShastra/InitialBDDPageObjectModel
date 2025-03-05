package drivermanager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    WebDriver driver = null;
   //threadLocal object for driver
    public static ThreadLocal<WebDriver> mydriver = new ThreadLocal<>();
    public  WebDriver launchBrowser(String browser) throws MalformedURLException {
        if (browser.equals("Chrome")) {
         ///   System.setProperty("webdriver.chrome.driver", "C:\\QAShastra\\MyTrainings\\Selenium\\Selenium Grid\\drivers\\chromedriver.exe");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");

            mydriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));


            //mydriver.set(new ChromeDriver());
        } else if (browser.equals("Firefox")) {
            //firefox capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            //capabilities.setCapability("moz:firefoxOptions", new FirefoxOptions().setBinary("C:\\QAShastra\\MyTrainings\\Selenium\\Selenium Grid\\drivers\\geckodriver.exe"));

            mydriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));

            // mydriver.set(new FirefoxDriver());
        }

         getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return mydriver.get();
    }

}