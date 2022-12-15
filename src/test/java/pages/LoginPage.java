package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "(//button[@class='header__button ng-star-inserted'])[1]")
    private WebElement loginBox;

    @FindBy(xpath = "//input[@id='auth_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='auth_pass']")
    private WebElement pass;

    @FindBy(xpath = "//button[contains(.,'Увійти')]")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='main-auth__user-name']")
    private WebElement titlePage;

    @FindBy(xpath = "//p[contains(.,'Введено невірну адресу ел. пошти або номер телефону')]")
    private WebElement errorMassage;

    @FindBy (xpath = "//strong[contains(.,'Введено невірний пароль!')]")
    private WebElement errorPassMassage;

    public LoginPage() {}

    public LoginPage loginBoxClick() {
        loginBox.click();
        return this;
    }

    public LoginPage emailSendKeys(String str) {
        email.sendKeys(str);
        return this;
    }

    public LoginPage emailClear() {
        email.clear();
        return this;
    }

    public LoginPage passSendKeys(String str) {
        pass.sendKeys(str);
        return this;
    }

    public LoginPage loginButtonClick() {
        loginButton.click();
        return this;
    }

    public String  getTitle() {
        return titlePage.getText();
    }

    public String  errorMassageIsDisplay() {
        return errorMassage.getText();
    }

    public String errorPassMassageIsDisplay() {
        return errorPassMassage.getText();
    }

}