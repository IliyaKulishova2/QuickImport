package mainPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Iliya on 01/26/2017.
 */
public class WebDriverFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String IE = "ie";

    private static WebDriver driver;

    private WebDriverFactory() {

    }


    public static WebDriver getInstance(String browser) {
        if (driver == null) {
            if (CHROME.equals(browser)) {
                setChromeDriver();
                driver = new ChromeDriver();

            } else if (FIREFOX.equals(browser)) {
                System.setProperty("webdriver.gecko.driver", "src/drivers/firefox/geckodriver.exe");
                driver = new FirefoxDriver();


            }else if (IE.endsWith(browser)){
                /*String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
                String ieBinary = "src/drivers/ie/IEDriverServer" + (os.equals("win") ? ".exe" : ""); */
                System.setProperty("webdriver.ie.driver", "src/drivers/ie/IEDriverServer.exe");
                driver = new InternetExplorerDriver();



            } else
                throw new RuntimeException("Invalid browser property set in configuration file");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        }

        return driver;
    }


    public static void killDriverInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    private static void setChromeDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        StringBuffer chromeBinaryPath = new StringBuffer(
                "src/drivers/");

        if (osName.startsWith("win")) {
            chromeBinaryPath.append("chrome/chromedriver.exe");
        } else if (osName.startsWith("lin")) {
            chromeBinaryPath.append("chrome/chromedriver.exe");
        } else if (osName.startsWith("mac")) {
            chromeBinaryPath.append("chrome/chromedriver.exe");
        } else
            throw new RuntimeException("Your OS is invalid for webdriver tests");

        System.setProperty("webdriver.chrome.driver",
                chromeBinaryPath.toString());
    }
}
