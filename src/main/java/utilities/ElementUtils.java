package utilities;

import base.BaseCls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils extends BaseCls {
    WebDriver driver;
    WebDriverWait wait;
    public ElementUtils(WebDriver driver) {
        wait= new WebDriverWait(driver,5);
    }

    public void click(By location){
        wait.until(ExpectedConditions.presenceOfElementLocated(location)).click();
    }

    public String getText(By location){
        return wait.until(ExpectedConditions.presenceOfElementLocated(location)).getText();
    }


}
