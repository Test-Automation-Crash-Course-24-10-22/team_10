
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runner.BaseRunner;

public class Tests extends BaseRunner {

    @BeforeClass
    public void  BeforeClass() {
        setDriver();

    }

//    @AfterTest
//    public void afterSuite() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }


    @Test
    public void userAuthorizationWithValidData() {

        WebElement loginBox = driver.findElement(By.ByXPath
                .xpath("(//button[@class='header__button ng-star-inserted'])[1]"));
        loginBox.click();

        WebElement email = driver.findElement(By.ByXPath
                .xpath("//input[@id='auth_email']"));
        email.sendKeys("0986838080");

        WebElement pass = driver.findElement(By.ByXPath
                .xpath("//input[@id='auth_pass']"));
        pass.sendKeys("Btim69");

        WebElement loginButton = driver.findElement(By.ByXPath
                .xpath("//button[contains(.,'�����')]"));
        loginButton.click();
    }

    @Test
    public void userAuthorizationWithInvalidData() {
        WebElement loginBox = driver.findElement(By.ByXPath
                .xpath("(//button[@class='header__button ng-star-inserted'])[1]"));
        loginBox.click();

        WebElement email = driver.findElement(By.ByXPath
                .xpath("//input[@id='auth_email']"));
        email.sendKeys("098683808");

        WebElement loginButton = driver.findElement(By.ByXPath
                .xpath("//button[contains(.,'�����')]"));
        loginButton.click();

        WebElement errorEmail = driver.findElement(By.ByXPath
                .xpath("//p[contains(.,'������� ������ ������ ��. ����� ��� ����� ��������')]"));
        errorEmail.isDisplayed();

        email.clear();
        email.sendKeys("ser.antones@..");
        loginButton.click();
        errorEmail.isDisplayed();

        email.clear();
        email.sendKeys("0986838080");

        loginButton.click();

    }

    @Test
    public void AddingOneProductToTheCart() {
        driver.get("https://rozetka.com.ua/ua/apple_iphone_13_128gb_starlight/p318463900/");

        WebElement cartAddButton = driver.findElement(By.ByXPath
                .xpath("//div[@id='#scrollArea']/div/div[2]/rz-product-main-info/div/div/ul/li/rz-product-buy-btn/app-buy-button/button/span"));
        cartAddButton.click();

        WebElement notification = driver.findElement(By.ByXPath
                .xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button/rz-icon-counter/span"));
        notification.isDisplayed();
    }

    @Test
    public void ChangingTheAmountOfGoodsInTheCart() {
        driver.get("https://rozetka.com.ua/ua/apple_iphone_13_128gb_starlight/p318463900/");

        WebElement cartAddButton = driver.findElement(By.ByXPath
                .xpath("//div[@id='#scrollArea']/div/div[2]/rz-product-main-info/div/div/ul/li/rz-product-buy-btn/app-buy-button/button/span"));
        cartAddButton.click();

        WebElement cart = driver.findElement(By.ByXPath
                .xpath("//*[@id='#scrollArea']/div[1]/div[2]/rz-product-main-info/div[1]/div/ul/li[1]/rz-product-buy-btn/app-buy-button/button"));
        cart.click();

        WebElement cartButtonPlus = driver.findElement(By.ByXPath
                .xpath("(//button[@type='button'])[8]"));
        cartButtonPlus.click();

        WebElement cartButtonMinus = driver.findElement(By.ByXPath
                .xpath("(//button[@type='button'])[7]"));
        cartButtonMinus.click();

    }

    @Test
    public void RemovingTheProductFromTheCart() {
        driver.get("https://rozetka.com.ua/ua/apple_iphone_13_128gb_starlight/p318463900/");

        WebElement cartAddButton = driver.findElement(By.ByXPath
                .xpath("//div[@id='#scrollArea']/div/div[2]/rz-product-main-info/div/div/ul/li/rz-product-buy-btn/app-buy-button/button/span"));
        cartAddButton.click();

        WebElement cart = driver.findElement(By.ByXPath
                .xpath("//*[@id=\"#scrollArea\"]/div[1]/div[2]/rz-product-main-info/div[1]/div/ul/li[1]/rz-product-buy-btn/app-buy-button/button"));
        cart.click();

        WebElement cartButton_1 = driver.findElement(By.ByXPath
                .xpath("//*[@id=\"cartProductActions0\"]"));
        cartButton_1.click();

        WebElement cartButton_2 = driver.findElement(By.ByXPath
                .xpath("//*[@id='cartProductActions0']/ul/li[1]/rz-trash-icon/button"));
        cartButton_2.click();

        WebElement notification = driver.findElement(By.ByXPath
                .xpath("//h4[contains(.,'����� �������')]"));
        notification.isDisplayed();

    }



}
