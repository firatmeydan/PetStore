import base.BaseCls;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PetStorePage;

import java.util.Properties;

public class PetStorePageTest {

    BaseCls base;
    Properties prop;
    WebDriver driver;
    PetStorePage petStorePage;

    @BeforeTest
    public void setUp() {
        base =new BaseCls();
        prop= base.initProperties();
        driver= base.initDriver();
        petStorePage= new PetStorePage(driver,prop);
        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1, description = "checks whether the first post method expanded")
    public void isExpanded(){
        String text="Parameters";
        Assert.assertEquals(petStorePage.expanded(),text);
    }

    @Test(priority = 2, description = "checks whether the first post method collapsed again")
    public void isCollapsed(){
        Assert.assertEquals(petStorePage.collapsed(),0);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
