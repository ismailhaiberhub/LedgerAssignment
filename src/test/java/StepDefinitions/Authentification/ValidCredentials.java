package StepDefinitions.Authentification;

import WebPages.HomePages.HomePage;
import WebPages.HomePages.SignUpPage;
import WebPages.HomePages.UserHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidCredentials {
    private HomePage homePage;
    private SignUpPage signUpPage;
    private UserHomePage userHomePage;

    public ValidCredentials(){
        homePage=new HomePage();
        signUpPage=new SignUpPage();
        userHomePage=new UserHomePage();
    }

    @Given("^the user is on the main page of conduit$")
    public void TheUserIsOnTheMainPageOFConduit(){
        homePage.checkifTheBannerIsShowing();
        homePage.checkIfTheButtonSignInIsShowing();
    }
    @When("the user clicks on the button")
    public void TheUserClickOntheButton(){
        homePage.clickOnTheSigninButton();
    }
    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage(){
        signUpPage.verifyifTheBannerIsShowingUp();
        signUpPage.verifyifTheCredentialsFiedlsAreShowingUp();
    }
    @When("the user fill his {string}")
    public void TheUserFillhisUsername(String username){
        signUpPage.fillTheUsername(username);
    }
    @And("the user fill his password {string}")
    public void theUserFillhisPassword(String password){
        signUpPage.fillthePassword(password);
    }
    @And("the user clicks on Sign in Button")
    public void theUserClicksOnSignInButton(){
        signUpPage.verifyTheSignInButtonIsEnabled();
        signUpPage.clickOnTheSignUpButton();
    }
    @Then("the user can log to his account")
    public void theUserCanLogtoHisAccount(){
        userHomePage.verifyTheUserIsLoggedIn();
    }


}
