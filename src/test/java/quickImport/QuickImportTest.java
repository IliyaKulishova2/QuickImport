package quickImport;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


/**
 * Created by Iliya on 01/26/2017.
 */
public class QuickImportTest extends TestBase {


    @Test (priority=1)

    public void testQuickImportLoginToDMS() throws Exception {
        //Login to dms by manager
        driver.get(baseUrl + "dms/login");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("autotest");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("login2")).click();
    }
   /*     //Go to Inventory/QuickImport/import vehicle from csv file with status "Leave it as it is"
        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.xpath(".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[1]")).click();
        driver.findElement(By.id("file_url")).clear();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/Renault_v10.csv");
       // driver.findElement(By.linkText("Import Now")).click();
       // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Check event log for status of import
        driver.get(baseUrl + "dms/admin/log");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[3]")).getText(), "IMPORT SIMPLE");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[5]")).getText(), "success");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[6]")).getText(), "Simple Import Complete");

        //Check inventory for status of imported vehicle
        driver.get(baseUrl + "dms/inventory");
        driver.findElement(By.xpath(".//*[@id='selFilter']/option[10]")).click();
        driver.findElement(By.xpath(".//*[@id='selValue']")).sendKeys("AE22E8BE0DD780920");
        driver.findElement(By.linkText("Find")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-list']/tbody/tr[2]/td[11]")).getText(), "INVENTORY");

    }

    @Test (priority=2)

    public void testQuickImportInventory() throws Exception {

        //Go to Inventory/QuickImport/import vehicle from csv file with status "Inventory"
        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.xpath(".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[2]")).click();
        driver.findElement(By.id("file_url")).clear();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/Renault_v10.csv");
        //driver.findElement(By.linkText("Import Now")).click();

        //Check event log for status of import
        driver.get(baseUrl + "dms/admin/log");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[3]")).getText(), "IMPORT SIMPLE");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[5]")).getText(), "success");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[6]")).getText(), "Simple Import Complete");

        //Check inventory for status of imported vehicle
        driver.get(baseUrl + "dms/inventory");
        driver.findElement(By.xpath(".//*[@id='selFilter']/option[10]")).click();
        driver.findElement(By.xpath(".//*[@id='selValue']")).sendKeys("AE22E8BE0DD780920");
        driver.findElement(By.linkText("Find")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-list']/tbody/tr[2]/td[11]")).getText(), "INVENTORY");
    }

    @Test (priority=3)

    public void testQuickImportPending() throws Exception {
        //Go to Inventory/QuickImport/import vehicle from csv file with status "Pending"
        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.xpath(".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[3]")).click();
        driver.findElement(By.id("file_url")).clear();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/Renault_v10.csv");
        driver.findElement(By.linkText("Import Now")).click();

        //Check event log for status of import
        driver.get(baseUrl + "dms/admin/log");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[3]")).getText(), "IMPORT SIMPLE");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[5]")).getText(), "success");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[6]")).getText(), "Simple Import Complete");

        //Check inventory for status of imported vehicle
        driver.get(baseUrl + "dms/inventory");
        driver.findElement(By.xpath(".//*[@id='selFilter']/option[10]")).click();
        driver.findElement(By.xpath(".//*[@id='selValue']")).sendKeys("AE22E8BE0DD780920");
        driver.findElement(By.linkText("Find")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-list']/tbody/tr[2]/td[11]")).getText(), "PENDING");
    }

    @Test (priority=4)

    public void testQuickImportTruckPaperAllAsItIs() throws Exception {
        //Go to Inventory/QuickImport/import all vehicles from zip archive with status "Leave it as it is"
        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.id("isTruckpaper")).click();
        driver.findElement(By.xpath(".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[1]")).click();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/002/DealerServicesInventoryTruckPaperUpdat.zip");
        driver.findElement(By.linkText("Import Now")).click();

        //Check event log for status of import
        driver.get(baseUrl + "dms/admin/log");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[3]")).getText(), "IMPORT SIMPLE");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[5]")).getText(), "success");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[6]")).getText(), "TruckPaper Import Complete");

        //Check inventory for status of imported vehicle
        driver.get(baseUrl + "dms/inventory");
        driver.findElement(By.xpath(".//*[@id='selFilter']/option[10]")).click();
        driver.findElement(By.xpath(".//*[@id='selValue']")).sendKeys("0000000000F550BLK");
        driver.findElement(By.linkText("Find")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-list']/tbody/tr[2]/td[11]")).getText(), "INVENTORY");
    }

    @Test (priority=5)

    public void testQuickImportTruckPaperAllInventory() throws Exception {
        //Go to Inventory/QuickImport/import all vehicles from zip archive with status "Inventory"
        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.id("isTruckpaper")).click();
        driver.findElement(By.xpath(".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[2]")).click();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/002/DealerServicesInventoryTruckPaperUpdat.zip");
        driver.findElement(By.linkText("Import Now")).click();

        //Check event log for status of import
        driver.get(baseUrl + "dms/admin/log");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[3]")).getText(), "IMPORT SIMPLE");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[5]")).getText(), "success");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[6]")).getText(), "TruckPaper Import Complete");

        //Check inventory for status of imported vehicle
        driver.get(baseUrl + "dms/inventory");
        driver.findElement(By.xpath(".//*[@id='selFilter']/option[10]")).click();
        driver.findElement(By.xpath(".//*[@id='selValue']")).sendKeys("0000000000F550BLK");
        driver.findElement(By.linkText("Find")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-list']/tbody/tr[2]/td[11]")).getText(), "INVENTORY");
    }

    @Test (priority=6)

    public void testQuickImportTruckPaperAllPending() throws Exception {
        //Go to Inventory/QuickImport/import all vehicles from zip archive with status "Pending"
        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.id("isTruckpaper")).click();
        driver.findElement(By.xpath(".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[3]")).click();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/002/DealerServicesInventoryTruckPaperUpdat.zip");
        driver.findElement(By.linkText("Import Now")).click();

        //Check event log for status of import
        driver.get(baseUrl + "dms/admin/log");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[3]")).getText(), "IMPORT SIMPLE");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[5]")).getText(), "success");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[6]")).getText(), "TruckPaper Import Complete");

        //Check inventory for status of imported vehicle
        driver.get(baseUrl + "dms/inventory");
        driver.findElement(By.xpath(".//*[@id='selFilter']/option[10]")).click();
        driver.findElement(By.xpath(".//*[@id='selValue']")).sendKeys("0000000000F550BLK");
        driver.findElement(By.linkText("Find")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-list']/tbody/tr[2]/td[11]")).getText(), "PENDING");
    } */

    @Test (priority=7)

    public void testQuickImportTruckPaperWithFiltersAsItIs() throws Exception {
        //Go to Inventory/QuickImport/import vehicles from zip archive with status "Leave it as it is" and filters
        driver.get(baseUrl + "dms/inventory/quickimport");
        driver.findElement(By.id("isTruckpaper")).click();
        driver.findElement(By.xpath(".//*[@id='form-simple-import']/table[1]/tbody/tr/td[2]/select/option[1]")).click();
        driver.findElement(By.id("file_url")).sendKeys("http://admin.autoxloo.com/datafeed_input/autoxloo/002/DealerServicesInventoryTruckPaperUpdat.zip");
        driver.findElement(By.xpath(".//*[@id='addFilter']")).click();
        //Select filters Year equal 2014 - expected 12 vehicles
        driver.findElement(By.xpath(".//tr[@id='filter_1']/td/select[@id='filter']/optgroup[@id='filter-optgroup-Generic parameters']/option[6]")).click();
        driver.findElement(By.xpath(".//tr[@id='filter_1']/td[2]/select/option[1]")).click();
        driver.findElement(By.xpath(".//tr[@id='filter_1']/td[3]/input")).sendKeys("2014");
        driver.findElement(By.linkText("Import Now")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Check event log for status of import
        driver.get(baseUrl + "dms/admin/log");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[3]")).getText(), "IMPORT SIMPLE");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[5]")).getText(), "success");
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='event-log']/tbody/tr[2]/td[6]")).getText(), "TruckPaper Import Complete");

        //Check inventory for status of imported vehicle
        driver.get(baseUrl + "dms/inventory");
        driver.findElement(By.xpath(".//*[@id='owner']/option[2]")).click();
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='total_vehicles_inventory_pending']")).getText(), "12");
    }
}
