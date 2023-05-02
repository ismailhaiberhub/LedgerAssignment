package StepDefinitions.Authentification;

import WebPages.HomePages.SignUpPage;
import io.cucumber.java.en.Then;

public class IncorrectCedentials {
    private SignUpPage signUpPage;

    public  IncorrectCedentials(){
        signUpPage=new SignUpPage();
    }
    @Then("^the user gets an error message$")
    public void theUserGetsanErrorMessage(){
        signUpPage.verifyIfTheerrorMessageisShowing();
    }
}
