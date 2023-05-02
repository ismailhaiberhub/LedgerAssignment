package WebPages.SettingsPages;

import WebDriver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Settings {

    private DriverFactory driver;
    private WebDriverWait wait;
    private By settingsBanner= By.xpath("//h1[@class='text-xs-center']");
    private WebElement settingsBannerelement;
    private By logoutButton=By.xpath("//button[contains(text(),'Or click here to logout')]");
    private WebElement logoutButtonElement;
    private By usernameInput=By.xpath("//input[@placeholder='Username']");
    private WebElement usernameInputElement;
    private By updateProfileButton=By.xpath("//button[@type='submit']");
    private WebElement updateProfileButtonElement;

    public Settings(){
        driver=new DriverFactory();
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30,10),Duration.ofSeconds(10));
    }

    public void verifyTheVisibilityofSettingsPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsBanner));
        settingsBannerelement=driver.get().findElement(settingsBanner);
        Assert.assertEquals(settingsBannerelement.getText(),"Your Settings");
    }

    public void logout(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButtonElement=driver.get().findElement(logoutButton);
        Actions action=new Actions(driver.get());
        action.click(logoutButtonElement);

    }

}
