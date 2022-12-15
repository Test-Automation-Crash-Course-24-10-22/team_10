package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import runner.BaseRunner;

public class Tests extends BaseRunner {

    @BeforeClass
    public void BeforeClass() {
        setDriver();
    }

    @Test
    public void userAuthorizationWithValidData() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        String actualTitle = loginPage
                .loginBoxClick()
                .emailSendKeys("0986838080")
                .passSendKeys("Btim69")
                .loginButtonClick()
                .getTitle();

        String expectedTitle = "Сергій Антонець";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void userAuthorizationWithInvalidData() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        String actualTitle = loginPage
                .loginBoxClick()
                .emailSendKeys("098683808")
                .loginButtonClick()
                .errorMassageIsDisplay();

        String expectedTitle = "Введено невірну адресу ел. пошти або номер телефону";

        Assert.assertEquals(expectedTitle, actualTitle);


        actualTitle = loginPage
                .emailClear()
                .emailSendKeys("ser.antones@..")
                .loginButtonClick()
                .errorMassageIsDisplay();

        Assert.assertEquals(expectedTitle, actualTitle);

        actualTitle = loginPage
                .emailClear()
                .emailSendKeys("0986838080")
                .passSendKeys("12345")
                .loginButtonClick()
                .errorPassMassageIsDisplay();

        expectedTitle = "Введено невірний пароль!";

        Assert.assertEquals(expectedTitle, actualTitle);
    }
//

    @Test
    public void AddingOneProductToTheCart() {

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

        driver.get(productPage.openProductPage());

        String actualTitle = productPage
                .cartAddButtonClick()
                .notificationMassage();

        String expectedTitle = "1";

        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test
    public void ChangingTheAmountOfGoodsInTheCart() {

        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        driver.get(cartPage.openProductPage());

        String actualTitle = cartPage
                .cartAddButtonClick()
                .cartClick()
                .cartButtonPlusClick()
                .cartButtonMinusClick()
                .notificationMassage();

        String expectedTitle = "1";

        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test
    public void RemovingTheProductFromTheCart() {
        driver.get("https://rozetka.com.ua/ua/apple_iphone_13_128gb_starlight/p318463900/");

        WebElement cartAddButton = driver.findElement(By.ByXPath
                .xpath("//div[@id='#scrollArea']/div/div[2]/rz-product-main-info/div/div/ul/li/rz-product-buy-btn/app-buy-button/button/span"));
        cartAddButton.click();

        WebElement cart = driver.findElement(By.ByXPath
                .xpath("//*[@id='#scrollArea']/div[1]/div[2]/rz-product-main-info/div[1]/div/ul/li[1]/rz-product-buy-btn/app-buy-button/button"));
        cart.click();

        WebElement cartButton_1 = driver.findElement(By.ByXPath
                .xpath("//*[@id='cartProductActions0']"));
        cartButton_1.click();

        WebElement cartButton_2 = driver.findElement(By.ByXPath
                .xpath("//*[@id='cartProductActions0']/ul/li[1]/rz-trash-icon/button"));
        cartButton_2.click();

        WebElement notification = driver.findElement(By.ByXPath
                .xpath("//h4[contains(.,'Кошик порожній')]"));
        notification.isDisplayed();

    }
}
