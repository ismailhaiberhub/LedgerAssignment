package WebPages.PostPages;

import WebDriver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostsPage {

    private DriverFactory driver;
    private WebDriverWait wait;
    private By articleTitle=By.xpath("//input[@placeholder='Article Title']");
    private WebElement articleTitleElement;
    private By articleSubject=By.xpath("//input[@placeholder=\"What's this article about?\"]");
    private WebElement articleSubjectElement;
    private By articleContent=By.xpath("//textarea[@class='form-control']");
    private WebElement aritcleContentElement;
    private By enterTags =By.xpath("//input[@placeholder=\"Enter tags\"]");
    private WebElement enterTagsElement;
    private By publishArticleButton=By.xpath("//button[@type='button']");
    private WebElement publishArticleButtonElement;
    private By postPublished=By.xpath("//a[@class='btn btn-outline-secondary btn-sm']");
    private ArrayList<By> postPageWebElements;

    public PostsPage(){
        driver=new DriverFactory();
        postPageWebElements=new ArrayList<>();
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30,10),Duration.ofSeconds(10));
    }

    public void theUserIsOnTheNewPostPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(articleSubject));
        aritcleContentElement=driver.get().findElement(articleContent);
        Assert.assertTrue(aritcleContentElement.isDisplayed());
        loadingPostPage();
    }
    public void loadingPostPage(){
        postPageWebElements.add(articleTitle);
        postPageWebElements.add(articleSubject);
        postPageWebElements.add(articleContent);
        postPageWebElements.add(enterTags);
        articleTitleElement=driver.get().findElement(articleTitle);
        articleSubjectElement=driver.get().findElement(articleSubject);
        enterTagsElement=driver.get().findElement(enterTags);
    }

    public void addNewPost(Map<String,String> dataForPost){
        loadingPostPage();
        articleTitleElement.sendKeys(dataForPost.get("title"));
        articleSubjectElement.sendKeys(dataForPost.get("subject"));
        aritcleContentElement.sendKeys(dataForPost.get("content"));
        enterTagsElement.sendKeys(dataForPost.get("tags"));
    }

    public void publishTheArticles(){
        wait.until(ExpectedConditions.elementToBeClickable(publishArticleButton));
        publishArticleButtonElement=driver.get().findElement(publishArticleButton);
        publishArticleButtonElement.click();
    }

    public void postPublishedSuccessfully(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(postPublished));
        Assert.assertTrue(driver.get().findElement(postPublished).isDisplayed());
    }


}
