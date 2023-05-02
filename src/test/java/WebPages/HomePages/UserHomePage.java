package WebPages.HomePages;

import WebDriver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserHomePage {
    private DriverFactory driver;
    private WebDriverWait wait;
    private By userFacePic=By.xpath("//img[@class='user-pic']");
    private By newPostButton=By.xpath("//a[contains(text(),'New Post')]");
    private WebElement newPostButtonElement;
    private WebElement userFacepicElement;
    private By yourFeed=By.xpath("//a[@class='nav-link active']");
    private WebElement yourFeedElement;


    public UserHomePage(){
        driver=new DriverFactory();
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30,10),Duration.ofSeconds(10));
    }



    public void verifyTheUserIsLoggedIn(){
        userFacepicElement=wait.until(ExpectedConditions.visibilityOfElementLocated(userFacePic));
        //userFacepicElement=driver.get().findElement(userFacePic);
        Assert.assertTrue(userFacepicElement.isDisplayed());
    }
    public void getTotTheUserProfil(){
        userFacepicElement=wait.until(ExpectedConditions.visibilityOfElementLocated(userFacePic));
        //userFacepicElement=driver.get().findElement(userFacePic);
        userFacepicElement.click();
    }

    public void clickOnNewPostButton(){
        newPostButtonElement=wait.until(ExpectedConditions.elementToBeClickable(newPostButton));
        //newPostButtonElement=driver.get().findElement(newPostButton);
        newPostButtonElement.click();
    }

    public void theUserIsOntheHomePage(){
        yourFeedElement=wait.until(ExpectedConditions.visibilityOfElementLocated(yourFeed));
        //yourFeedElement=driver.get().findElement(yourFeed);
        Assert.assertTrue(yourFeedElement.isDisplayed());
    }
}
