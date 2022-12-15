package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseRunner {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @AfterSuite
    public void afterSuite() {

        if (driver != null) {
            driver.quit();
        }
    }
}
