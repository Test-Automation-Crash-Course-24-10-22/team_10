package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import runner.BaseRunner;


public class Tests extends BaseRunner {

    @BeforeClass
    public void BeforeClass() {
        setDriver();
    }

    @Test(priority = 4, description="User authorization with valid data")
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

    @Test(priority = 3, description="User authorization with invalid data")
    public void userAuthorizationWithInvalidData() {

        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        String actualTitle = loginPage
                .loginBoxClick()
                .emailSendKeys("098683808")
                .loginButtonClick()
                .errorMassageIsDisplay();

        String expectedTitle = "Введено невірну адресу ел. пошти або номер телефону";

        softAssert.assertEquals(expectedTitle, actualTitle);

        actualTitle = loginPage
                .emailClear()
                .emailSendKeys("ser.antones@..")
                .loginButtonClick()
                .errorMassageIsDisplay();

        softAssert.assertEquals(expectedTitle, actualTitle);

        actualTitle = loginPage
                .emailClear()
                .emailSendKeys("0986838080")
                .passSendKeys("12345")
                .loginButtonClick()
                .errorPassMassageIsDisplay();

        expectedTitle = "Введено невірний пароль!";

        softAssert.assertEquals(expectedTitle, actualTitle);

        softAssert.assertAll();
    }


    @Test(priority = 2, description="Adding one product to the cart")
    public void addingOneProductToTheCart() {

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

        String actualTitle = productPage
                .openProductPage()
                .cartAddButtonClick()
                .notificationMassage();

        String expectedTitle = "1";

        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test(priority = 1, description="Changing the amount of goods in the cart")
    public void changingTheAmountOfGoodsInTheCart() {

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

    @Test(priority = 0, description="Removing the product from the cart")
    public void removingTheProductFromTheCart() {
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
