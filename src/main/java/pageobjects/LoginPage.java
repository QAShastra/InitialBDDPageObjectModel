package pageobjects;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends BasePage {
    WebDriver driver;
    // Locators
    By usernameField = By.cssSelector("input[name='username']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public void enterUsername(String text) {
        sendKeys(usernameField, text);
    }
    public void enterPassword(String text) {
        sendKeys(passwordField, text);
    }
    public void click() {
        clickElement(loginButton);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void verifyErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));
        if (driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed()) {
            System.out.println("Error message is displayed");
        } else {
            System.out.println("Error message is not displayed");
        }
    }

    public void logout() {
        driver.findElement(By.cssSelector("a[id='welcome']")).click();
        driver.findElement(By.cssSelector("a[href='/web/index.php/auth/logout']")).click();
    }

    public void verifyHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6[1]")));
        if (driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6[1]")).isDisplayed()) {
            System.out.println("User is on Home Page");
        } else {
            System.out.println("User is not on Home Page");
        }
    }
}