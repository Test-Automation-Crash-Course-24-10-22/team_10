package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {


    @FindBy(xpath = "//div[@id='#scrollArea']/div/div[2]/rz-product-main-info/div/div/ul/li/rz-product-buy-btn/app-buy-button/button/span")
    private WebElement cartAddButton;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button/rz-icon-counter/span")
    private WebElement notification;


    public ProductPage() {
    }

    public String openProductPage() {
        return "https://rozetka.com.ua/ua/apple_iphone_13_128gb_starlight/p318463900/";
    }

    public ProductPage cartAddButtonClick() {
        cartAddButton.click();
        return this;
    }

    public String notificationMassage() {
        return notification.getText();
    }


}
