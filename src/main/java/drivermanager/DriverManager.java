package drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    WebDriver driver = null;

   //threadLocal object for driver
    public static ThreadLocal<WebDriver> mydriver = new ThreadLocal<>();

    public  WebDriver launchBrowser(String browser) {
        if (browser.equals("Chrome")) {

            mydriver.set(new ChromeDriver());
        } else if (browser.equals("Firefox")) {

            mydriver.set(new FirefoxDriver());
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();


        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return mydriver.get();
    }


}