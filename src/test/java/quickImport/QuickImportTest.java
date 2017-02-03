package quickImport;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Iliya on 01/26/2017.
 */
public class QuickImportTest extends TestBase {

    @Test(priority=1)

    public void testQuickImportLoginToDMS() throws Exception {
        driver.get(baseUrl + "dms/login");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("autotest");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("login2")).click();


        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.id("file_url")).clear();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/Renault_v10.csv");
        driver.findElement(By.linkText("Import Now")).click();

        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Assert.assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());
        //Thread.sleep(6000);

        //WebElement source = driver.findElement(By.xpath("//*[@id='height_body']/div/div[1]/div[1]"));
        //Assert.assertEquals("Import complete", source.getText());

       /* ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));*/


        //Assert.assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());
        //WebElement source = driver.findElement(By.xpath("//*[@id='height_body']/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/div"));
        //Assert.assertEquals("autotest", source.getText());

    }


}
