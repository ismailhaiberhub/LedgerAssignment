package StepDefinitions.PostPage;

import WebPages.PostPages.EditPosts;
import WebPages.HomePages.UserHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditingPosts {

    private UserHomePage userHomePage;
    private EditPosts editPosts;

    public EditingPosts(){
        userHomePage=new UserHomePage();
        editPosts=new EditPosts();
    }


    @When("the user deletes the post")
    public void theUserDeletesThePost() {
        editPosts.deletingApost();
    }

    @Then("the user is on his feed page")
    public void theUserIsOnHisFeedPage() {
        userHomePage.theUserIsOntheHomePage();
    }


}
