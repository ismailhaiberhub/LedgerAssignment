package StepDefinitions.SettingsDef;

import WebPages.HomePages.UserHomePage;
import WebPages.HomePages.UserProfile;
import WebPages.SettingsPages.Settings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SettingsStepDef {

    private Settings settings;
    private UserHomePage userHomePage;
    private UserProfile userProfile;

    public SettingsStepDef(){
        settings=new Settings();
        userHomePage=new UserHomePage();
        userProfile=new UserProfile();
    }


    @When("the user clicks on his profile")
    public void theUserClicksOnHisProfile() {
        userHomePage.getTotTheUserProfil();
    }

    @And("the user clicks on Edit Profile Settings")
    public void theUserClicksOnEditProfileSettings() {
        userProfile.getToProfileSettings();
    }

    @Then("the user is on the settings")
    public void theUserIsOnTheSettings() {
        settings.verifyTheVisibilityofSettingsPage();
    }

    @And("the user can click on the button to logout")
    public void theUserCanClickOnTheButtonToLogout() {
        settings.logout();
    }
}
