package stepdefinitions;

import drivermanager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

public class LoginSteps {
   public static WebDriver driver = null;


    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
         loginPage.navigateToLoginPage();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() throws InterruptedException {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }
    @When("the user enters invalid credentials")
    public void the_user_enters_in_valid_credentials() throws InterruptedException {
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPassword1212121212121212121");
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
             loginPage.verifyHomePage();
     }

    @Then("the user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {
        loginPage.verifyErrorMessage();

    }


    @When("the user enters {string} in the username field")
    public void the_user_enters_in_the_username_field(String string) {
        loginPage.enterUsername(string);
    }
    @When("the user enters {string} in the password field")
    public void the_user_enters_in_the_password_field(String string) {
        loginPage.enterPassword(string);

    }
    @When("the user clicks button")
    public void the_user_clicks_button() {
        loginPage.click();

    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThe(String string) {
        if(string.equals("dashboardpage")){
            loginPage.verifyHomePage();
        }else if(string.equals("errorpage")){
            loginPage.verifyErrorMessage();
        }
    }

}