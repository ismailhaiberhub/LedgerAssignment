package WebPages.HomePages;

import WebDriver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class HomePage {

    private DriverFactory driver;
    private By banner= By.xpath("//h1[@class='logo-font']");
    private WebElement bannerElement;
    private By signInButton=By.xpath("//a[contains(text(),'Sign in')]");

    private WebElement signUpButtonElement;
    private WebDriverWait wait;
    public HomePage(){
        driver=new DriverFactory();
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30,10),Duration.ofSeconds(10));

    }

    public void checkifTheBannerIsShowing(){
        bannerElement=driver.get().findElement(banner);
        wait.until(ExpectedConditions.visibilityOf(bannerElement)) ;
       Assert.assertTrue(bannerElement.isDisplayed());
    }

    public void checkIfTheButtonSignInIsShowing(){
        signUpButtonElement= driver.get().findElement(signInButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)) ;
        Assert.assertTrue(signUpButtonElement.isDisplayed());
    }

    public void clickOnTheSigninButton(){
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.get().findElement(signInButton).click();
    }



}
