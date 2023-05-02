package AppHooks;

import WebDriver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hooks {

    private DriverFactory driver;

    @Before
    public void LaunchBrower() throws InterruptedException {
        driver= new DriverFactory();
        driver.createRemoteDriver();
        driver.get().manage().window().maximize();
        driver.get().get("https://react-redux.realworld.io/#/?_k=q6su8a");
    }

    @After
    public void CloseBrowser(){
       driver.closeDriver();
    }
}
