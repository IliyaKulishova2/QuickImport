package quickImport;

import mainPack.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Iliya on 01/26/2017.
 */
public class TestBase {
    protected WebDriver driver;
    public static String baseUrl;


    @BeforeSuite
    @Parameters({"browserName" })
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        baseUrl = "http://www.map2.iliya.dxloo.com/";
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            WebDriverFactory.killDriverInstance();
        }
    }

}
