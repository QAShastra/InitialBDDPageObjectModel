package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver){
        this.driver = driver;
          wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

    }
    public WebElement getElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void isElementVisible(WebElement element){
         wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(By locator){
        getElement(locator).click();
    }
    //enter text
    public void sendKeys(By locator, String text){
        getElement(locator).sendKeys(text);
    }
    //get text
    public String getText(By locator){
        return getElement(locator).getText();
    }
    //get title
    public String getTitle(){
        return driver.getTitle();
    }
    //get current url
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    //is element displayed
    public boolean isElementDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }
    //is element enabled
    public boolean isElementEnabled(By locator){
        return getElement(locator).isEnabled();
    }
    //is element selected
    public boolean isElementSelected(By locator){
        return getElement(locator).isSelected();
    }
    //get element attribute
    public String getElementAttribute(By locator, String attribute){
        return getElement(locator).getAttribute(attribute);
    }
    //get element css value
    public String getElementCssValue(By locator, String cssValue){
        return getElement(locator).getCssValue(cssValue);
    }
    //get element tag name
    public String getElementTagName(By locator){
        return getElement(locator).getTagName();
    }
    //get element size
    public int getElementSize(By locator){
        return driver.findElements(locator).size();
    }
    // select drpdown by visible text
    public void selectDropdownByVisibleText(By locator, String text){
        getElement(locator);
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }
    // select drpdown by index
    public void selectDropdownByIndex(By locator, int index){
        getElement(locator);
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }
    // select drpdown by value
    public void selectDropdownByValue(By locator, String value){
        getElement(locator);
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }
    // get first selected option
    public String getFirstSelectedOption(By locator){
        getElement(locator);
        Select select = new Select(getElement(locator));
        return select.getFirstSelectedOption().getText();
    }
    // get all selected options
    public void getAllSelectedOptions(By locator){
        getElement(locator);
        Select select = new Select(getElement(locator));
        select.getAllSelectedOptions();
    }

}
