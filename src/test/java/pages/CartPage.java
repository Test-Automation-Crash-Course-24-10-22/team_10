package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {


    @FindBy(xpath = "//div[@id='#scrollArea']/div/div[2]/rz-product-main-info/div/div/ul/li/rz-product-buy-btn/app-buy-button/button/span")
    private WebElement cartAddButton;

    @FindBy(xpath = "//*[@id='#scrollArea']/div[1]/div[2]/rz-product-main-info/div[1]/div/ul/li[1]/rz-product-buy-btn/app-buy-button/button")
    private WebElement cart;

    @FindBy(xpath = "//button[@type='button'])[8]")
    private WebElement cartButtonPlus;

    @FindBy(xpath = "//button[@type='button'])[7]")
    private WebElement cartButtonMinus;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button/rz-icon-counter/span")
    private WebElement notification;


    public CartPage() {}

    public String openProductPage() {

        return "https://rozetka.com.ua/ua/apple_iphone_13_128gb_starlight/p318463900/";
    }

    public CartPage cartAddButtonClick() {
        cartAddButton.click();
        return this;
    }

    public CartPage cartClick() {
        cart.click();
        return this;
    }

    public CartPage cartButtonPlusClick() {
        cartButtonPlus.click();
        return this;
    }

    public CartPage cartButtonMinusClick() {
        cartButtonMinus.click();
        return this;
    }

    public String notificationMassage() {
        return notification.getText();
    }



}
