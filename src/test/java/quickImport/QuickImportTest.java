package quickImport;

import org.testng.annotations.*;
import org.openqa.selenium.*;

/**
 * Created by Iliya on 01/26/2017.
 */
public class QuickImportTest extends TestBase {

    /*@BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D://Install/geckodriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        driver = new FirefoxDriver(capabilities);
        baseUrl = "http://www.map2.iliya.dxloo.com/dms/login";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }*/

    @Test

    public void testQuickImport() throws Exception {
        driver.get(baseUrl + "dms/login");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("autotest");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("login2")).click();
        Thread.sleep(6000);
    }
}
