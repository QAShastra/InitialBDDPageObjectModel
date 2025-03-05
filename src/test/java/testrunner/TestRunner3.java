package testrunner;

 import drivermanager.DriverManager;
  import io.cucumber.testng.AbstractTestNGCucumberTests;
 import io.cucumber.testng.CucumberOptions;
 import org.openqa.selenium.WebDriver;
 import org.testng.annotations.AfterClass;
 import org.testng.annotations.DataProvider;
 import org.testng.annotations.Parameters;
 import org.testng.annotations.BeforeClass;

 import java.net.MalformedURLException;

@CucumberOptions(
     features = "src/test/resources/features",
     glue = {"stepdefinitions","hooks"},
     plugin = {"pretty", "html:target/cucumber-reports.html"}
 )
 public class TestRunner3 extends AbstractTestNGCucumberTests {
     @Override
     @DataProvider(parallel = true)
     public Object[][] scenarios() {
         return super.scenarios();
     }
     WebDriver driver = null;
     @Parameters("browser")
     @BeforeClass
     public void setup(String browser) throws MalformedURLException {
         DriverManager driverManager = new DriverManager();
        driver =   driverManager.launchBrowser(browser);
     }

    @AfterClass
    public void tearDown() {
        System.out.println("This is tearDown method");
        driver.quit();
    }
 }