package WebPages.HomePages;

import WebDriver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    DriverFactory driver;
    private WebDriverWait wait;

    private By signUpBanner=By.xpath("//h1[@class='text-xs-center']");
    WebElement signupBannerElement;
    private By emailInput=By.xpath("//input[@type='email']");
    WebElement emaiInputElement;

    private By passwordInput=By.xpath("//input[@type='password']");
    WebElement passwordElement;
    private By signUpButton=By.xpath("//button[@type='submit']");
    WebElement signInButtonElement;
    private By errorMessage=By.xpath("//ul[@class='error-messages']");
    WebElement errorMessageElement;

    public SignUpPage(){
        driver=new DriverFactory();
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30,10),Duration.ofSeconds(10));
    }

    public void verifyifTheBannerIsShowingUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBanner));
        signupBannerElement=driver.get().findElement(signUpBanner);
        Assert.assertTrue(signupBannerElement.isDisplayed());
    }

    public void verifyifTheCredentialsFiedlsAreShowingUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        emaiInputElement=driver.get().findElement(emailInput);
        passwordElement=driver.get().findElement(passwordInput);
        Assert.assertTrue(emaiInputElement.isDisplayed());
        Assert.assertTrue(passwordElement.isDisplayed());
    }


    public void fillTheUsername(String username){
        emaiInputElement.clear();
        emaiInputElement.sendKeys(username);
    }

    public void fillthePassword(String password){
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void verifyTheSignInButtonIsEnabled(){
        signInButtonElement=wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
        //signInButtonElement=driver.get().findElement(signUpButton);
        Assert.assertTrue(signInButtonElement.isEnabled());
    }
    public void clickOnTheSignUpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signInButtonElement.click();
    }
    public void verifyIfTheerrorMessageisShowing(){
        errorMessageElement=wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        //errorMessageElement=driver.get().findElement(errorMessage);
        Assert.assertTrue(errorMessageElement.isDisplayed());
    }
}
