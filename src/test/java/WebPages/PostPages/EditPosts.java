package WebPages.PostPages;

import WebDriver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditPosts {
    private DriverFactory driver;
    private WebDriverWait wait;
    private By deletePostbutton= By.xpath("//button[@class='btn btn-outline-danger btn-sm']");
    private WebElement deletePostElement;
    private By editPostbutton=By.xpath("//a[@class='btn btn-outline-secondary btn-sm']");
    private WebElement editPostButtonElement;

    public EditPosts(){
        driver=new DriverFactory();
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30,10),Duration.ofSeconds(10));
    }

    public void deletingApost(){
        wait.until(ExpectedConditions.elementToBeClickable(deletePostbutton));
        deletePostElement=driver.get().findElement(deletePostbutton);
        deletePostElement.click();
    }


}
