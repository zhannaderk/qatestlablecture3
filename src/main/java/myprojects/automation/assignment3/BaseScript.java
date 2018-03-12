package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        String driverPath;
        switch (browser) {
            case BrowserType.CHROME:
                driverPath = getChromeDriverName();
                break;
            case BrowserType.FIREFOX:
                driverPath = "/geckodriver.exe";
                break;
            case BrowserType.IE:
                driverPath = "/IEDriverServer.exe";
                break;
            default:
                driverPath = "/chromedriver.exe";
                break;
        }
        System.setProperty(
                "webdriver.chrome.driver",
                new File(BaseScript.class.getResource(driverPath).getFile()).getPath());
        return new ChromeDriver();
    }

    /**
     * That is for other os type (mac and linux) for chrome driver
      * @return path for chrome driver
     */
    private static String getChromeDriverName() {
        String osName = System.getProperty("os.name").toLowerCase();
        String result;
        if (osName.contains("mac")) {
            result = "/chromedriver-mac";
        } else if (osName.contains("linux")) {
            result = "/chromedriver-linux";
        } else {
            result = "/chromedriver.exe";
        }
        return result;
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new CustomEventListener());
        return eventFiringWebDriver;
    }
}
