
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium {

    public WebDriver driver = new ChromeDriver();

    @Test
    public void firstTest() {

        driver.get("https://selenium.dev");

        driver.quit();
    }
}
