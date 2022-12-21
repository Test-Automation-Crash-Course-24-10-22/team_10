package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{


    @FindBy(xpath = "//div[@id='#scrollArea']/div/div[2]/rz-product-main-info/div/div/ul/li/rz-product-buy-btn/app-buy-button/button/span")
    private WebElement cartAddButton;

    @FindBy(xpath = "//ul[@class='product-buttons']//button[1]")
    private WebElement cart;

    @FindBy(xpath = "(//ul[@class='header-actions']//li//button)[2]")
    private WebElement cartIcon;


    @FindBy(xpath = "//div[@class='cart-counter']//button[2]")
    private WebElement cartButtonPlus;

    @FindBy(xpath = "//div[@class='cart-counter']//button[1]")
    private WebElement cartButtonMinus;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button/rz-icon-counter/span")
    private WebElement notification;

    @FindBy(xpath = "//*[@id='cartProductActions0']")
    private WebElement cartButtonMenu;

    @FindBy(xpath = "//*[@id='cartProductActions0']/ul/li[1]/rz-trash-icon/button")
    private WebElement cartButtonDelete;

    @FindBy(xpath = "//h4[contains(.,'Кошик порожній')]")
    private WebElement massage;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open product page")
    public CartPage openProductPage() {
        driver.get("https://rozetka.com.ua/ua/apple_iphone_13_128gb_starlight/p318463900/");
        return this;
    }
    @Step("Cart add button click")
    public CartPage cartAddButtonClick() {
        cartAddButton.click();
        return this;
    }
    @Step("Cart click")
    public CartPage cartClick() {
        driver.get("https://rozetka.com.ua/ua/cart/");
        return this;
    }
    @Step("Cart page")
    public CartPage cartIconClick() {
        cartIcon.click();
        return this;
    }

    @Step("Cart button plus click")
    public CartPage cartButtonPlusClick() {
        cartButtonPlus.click();
        return this;
    }
    @Step("Cart button minus click")
    public CartPage cartButtonMinusClick() {
        cartButtonMinus.click();
        return this;
    }
    @Step("Notification massage")
    public String notificationMassage() {
        return notification.getText();
    }

    @Step("Cart button menu click")
    public CartPage cartButtonMenuClick() {
        cartButtonMenu.click();
        return this;
    }
    @Step("Cart button delete click")
    public CartPage cartButtonDeleteClick() {
        cartButtonDelete.click();
        return this;
    }
    @Step("Massage is display")
    public String massageIsDisplay() {
        return massage.getText();
    }


}
