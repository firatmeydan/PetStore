package pages;

import base.BaseCls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementUtils;

import java.util.Properties;

public class PetStorePage extends BaseCls {
    Properties prop;
    WebDriver driver;
    ElementUtils elUtils;

    public PetStorePage(WebDriver driver, Properties prop) {
        this.prop=prop;
        this.driver=driver;
        elUtils = new ElementUtils(driver);
    }

    //Locators
    By firstPost = By.xpath("(//*[@class='opblock-summary-control'])[1]");
    By secondPost = By.xpath("(//*[@class='opblock-summary-control'])[2]");
    By firstPUT = By.xpath("(//*[@class='opblock-summary-control'])[3]");
    By firstGET = By.xpath("(//*[@class='opblock-summary-control'])[4]");
    By expandText = By.xpath("//*[@class='opblock-title']");

    public String expanded() {
        elUtils.click(firstPost);
        return elUtils.getText(expandText);
    }

    public int collapsed() {
        elUtils.click(firstPost);
        return driver.findElements(expandText).size();
    }

}
