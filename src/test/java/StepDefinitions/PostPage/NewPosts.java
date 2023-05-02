package StepDefinitions.PostPage;

import WebPages.PostPages.PostsPage;
import WebPages.HomePages.UserHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class NewPosts {

    private PostsPage postsPage;
    private UserHomePage userHomePage;

    public NewPosts(){
        postsPage=new PostsPage();
        userHomePage=new UserHomePage();
    }

    @When("the user clicks on the button New Post")
    public void theUserClicksOnTheButtonNewPost() {
        userHomePage.clickOnNewPostButton();
    }

    @Then("the user is on the page of adding new post")
    public void theUserIsOnThePageOfAddingNewPost() {
        postsPage.theUserIsOnTheNewPostPage();
    }

    @When("the user fill all the fields")
    public void theUserFillAllTheFields(Map<String,String> dataForNewPost) {
        postsPage.addNewPost(dataForNewPost);
    }

    @Then("the user pusblishes the articles by clicking on the button")
    public void theUserPusblishesTheArticlesByClickingOnTheButton() {
        postsPage.publishTheArticles();
    }

    @And("the user verifies that the post published")
    public void theUserVerifiesThatThePostPublished() {
        postsPage.postPublishedSuccessfully();
    }


}
