package WebAutomation;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig() {
        System.setProperty("webdriver.gecko.driver", "/home/joao/Documents/geckodriver");


        Capabilities capabilities = DesiredCapabilities.firefox();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    static {
        System.setProperty("webdriver.gecko.driver", findFile("geckodriver.mac"));
    }

    static private String findFile(String filename) {
        String paths[] = {"", "bin/", "target/classes"}; // if you have chromedriver somewhere else on the path, then put it here.
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }

    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
