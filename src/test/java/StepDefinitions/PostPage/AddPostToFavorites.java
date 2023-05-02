package StepDefinitions.PostPage;

import WebPages.HomePages.UserHomePage;
import WebPages.HomePages.UserProfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPostToFavorites {
    private UserProfile userProfile;
    private UserHomePage userHomePage;

    public AddPostToFavorites(){
        userProfile=new UserProfile();
        userHomePage=new UserHomePage();
    }


    @When("The user goes to his profile page")
    public void theUserGoesToHisProfilePage() {
        userHomePage.getTotTheUserProfil();
    }

    @And("The user add his new post to his favorites {string}")
    public void theUserAddHisNewPostToHisFavorites(String dataForNewPost) {
        userProfile.checkThePostIsDisplayed(dataForNewPost);
        userProfile.addPostToFavorites();

    }

    @And("the user access to widget of favorited articles")
    public void theUserAccessToWidgetOfFavoritedArticles() {
        userProfile.clickOnFavorites();
    }

    @Then("the user finds his new articles in the section of favorited articles")
    public void theUserFindsHisNewArticlesInTheSectionOfFavoritedArticles() {
        userProfile.checkIfthePostIsAddedToFavorites();
    }
}
