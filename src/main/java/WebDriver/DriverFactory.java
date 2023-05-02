package WebDriver;

import Utilities.ConfigReader.ConfigReaderProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Properties;

//The driverFactory class is for initiating the driver but collecting the data from the properties File
public class DriverFactory {
    private ConfigReaderProperties configReaderProperties;
    //The RemoteWebDriver is used in case we need to execute our tests in another computer
    private final RemoteWebDriver remoteWebDriver;
    //I use the InheritableThreadLocal in case we need to do some parallel testing with TestNG
    private static InheritableThreadLocal<RemoteWebDriver> driverPool=new InheritableThreadLocal<>();

    public DriverFactory(){
        configReaderProperties=new ConfigReaderProperties();
        this.remoteWebDriver=createRemoteDriver();
    }

    public RemoteWebDriver get(){
        return this.remoteWebDriver;
    }
    public RemoteWebDriver createRemoteDriver(){
        if(driverPool.get()==null){
            String browserFromProperties=configReaderProperties.init_props().getProperty("browser");
            switch(browserFromProperties){
                case "chrome":
                    driverPool.set(createChromeDriver(false));
                    break;
                case "chrome-headless":
                    driverPool.set(createChromeDriver(true));
                    break;
                case "firefox":
                    driverPool.set(createFirefoxDriver(false));
                    break;
                case "firefox-headless":
                    driverPool.set(createFirefoxDriver(true));
                    break;
                default:
                    throw new RuntimeException("Unknown driver for " + browserFromProperties + " browser");
            }
        }
        return driverPool.get();
    }

    private RemoteWebDriver createChromeDriver(boolean isHeadless) {
        WebDriverManager.chromedriver().setup();
        if (isHeadless) {
            return new ChromeDriver(new ChromeOptions().setHeadless(true).addArguments("window-size=1920,1080"));
        }
        try {
            return new ChromeDriver();
        } catch (WebDriverException e) {
            return new ChromeDriver();
        }
    }

    private RemoteWebDriver createFirefoxDriver(boolean isHeadless) {
        WebDriverManager.firefoxdriver().setup();
        if (isHeadless) {
            return new FirefoxDriver(new FirefoxOptions().setHeadless(true).addArguments("window-size=1920,1080"));
        }
        try {
            return new FirefoxDriver();
        } catch (WebDriverException e) {
            return new FirefoxDriver();
        }
    }

    public void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }



}
