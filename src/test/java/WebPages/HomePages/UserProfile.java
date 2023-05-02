package WebPages.HomePages;

import WebDriver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class UserProfile {
    private DriverFactory driver;
    private WebDriverWait wait;
    private String articlesTitle;
    private By myArticlesWidget=By.xpath("//a[@class='nav-link active']");
    private WebElement myArticlesWidgetElement;
    private  By addToFavoritesButton=By.xpath("//button[@class='btn btn-sm btn-outline-primary']");
    private WebElement addToMyFavoritesButtonElement;
    private By getAddToFavoritesButtonByTitle;
    private WebElement getAddToMyFavoritesButtonElement;
    private By articleTitle;
    private WebElement articlesTitleElement;
    private By favoritedArticles =By.xpath("//a[contains(text(),'Favorited Articles')]");
    private WebElement favoritedArticlesElement;
    private By editProfileSettings=By.xpath("//a[@class='btn btn-sm btn-outline-secondary action-btn']");
    private WebElement editProfileSettingsElement;


    public UserProfile(){
        driver=new DriverFactory();
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30,10),Duration.ofSeconds(10));
    }




    public void checkThePostIsDisplayed(String articlesTitleData){
        this.articlesTitle=articlesTitleData;
        articleTitle=By.xpath("//h1[contains(text(),'"+articlesTitle+"')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(articleTitle));
        articlesTitleElement=driver.get().findElement(articleTitle);
        Assert.assertTrue(articlesTitleElement.isDisplayed());
        getAddToFavoritesButtonByTitle=By.xpath("//h1[contains(text(),'"+articlesTitle+"')]/../..//div[@class='pull-xs-right']");

    }

    public void addPostToFavorites(){
        wait.until(ExpectedConditions.elementToBeClickable(getAddToFavoritesButtonByTitle));
        getAddToMyFavoritesButtonElement=driver.get().findElement(getAddToFavoritesButtonByTitle);
        getAddToMyFavoritesButtonElement.click();
    }

    public void clickOnFavorites(){
        wait.until(ExpectedConditions.elementToBeClickable(favoritedArticles));
        favoritedArticlesElement=driver.get().findElement(favoritedArticles);
        favoritedArticlesElement.click();
    }

    public void checkIfthePostIsAddedToFavorites(){
        wait.until(ExpectedConditions.elementToBeClickable(favoritedArticles));
        favoritedArticlesElement=driver.get().findElement(favoritedArticles);
        favoritedArticlesElement.click();
        Assert.assertTrue(driver.get().findElement(getAddToFavoritesButtonByTitle).isDisplayed());
    }

    public void getToProfileSettings(){
        wait.until(ExpectedConditions.elementToBeClickable(editProfileSettings));
        editProfileSettingsElement=driver.get().findElement(editProfileSettings);
        Assert.assertTrue(editProfileSettingsElement.isDisplayed());
        editProfileSettingsElement.click();
    }
}
