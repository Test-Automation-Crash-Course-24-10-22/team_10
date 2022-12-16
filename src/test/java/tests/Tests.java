package tests;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import runner.BaseRunner;

import java.time.Duration;

public class Tests extends BaseRunner {

    @BeforeClass
    public void BeforeClass() {
        setDriver();
    }

    @Test(priority = 4)
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

    @Test(priority = 3)
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


    @Test(priority = 2)
    public void AddingOneProductToTheCart() {

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

        String actualTitle = productPage
                .openProductPage()
                .cartAddButtonClick()
                .notificationMassage();

        String expectedTitle = "1";

        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test(priority = 1)
    public void ChangingTheAmountOfGoodsInTheCart() {

        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        String actualTitle = cartPage
                .openProductPage()
                .cartAddButtonClick()
                .cartClick()
                .cartButtonPlusClick()
                .cartButtonMinusClick()
                .notificationMassage();

        String expectedTitle = "1";

        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test(priority = 0)
    public void RemovingTheProductFromTheCart() {
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        String actualTitle = cartPage
                .openProductPage()
                .cartAddButtonClick()
                .cartClick()
                .cartButtonMenuClick()
                .cartButtonDeleteClick()
                .massageIsDisplay();

        String expectedTitle = "Кошик порожній";

        Assert.assertEquals(expectedTitle, actualTitle);


    }
}
