package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseCls {
    public Properties prop;
    public WebDriver driver;

    public BaseCls() {
        prop = initProperties();
    }

    public WebDriver initDriver() {
        //System.setProperty("webdriver.chrome.driver","path of the chrome driver");
        //Since I've installed chrome driver in my system file, I don't need to set that property.

        String browser = prop.getProperty("browser");
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public Properties initProperties() {
        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream("./src/main/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }


}
