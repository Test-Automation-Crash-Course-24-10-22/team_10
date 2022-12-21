package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{


    @FindBy(xpath = "(//button[@class='header__button ng-star-inserted'])")
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login page click")
    public LoginPage loginBoxClick() {
        driver.get("https://rozetka.com.ua/ua/");
        loginBox.click();
        return this;
    }
    @Step("email send keys")
    public LoginPage emailSendKeys(String str) {
        email.sendKeys(str);
        return this;
    }
    @Step("Email clear")
    public LoginPage emailClear() {
        email.clear();
        return this;
    }
    @Step("Pass send keys")
    public LoginPage passSendKeys(String str) {
        pass.sendKeys(str);
        return this;
    }
    @Step("Login button click")
    public LoginPage loginButtonClick() {
        loginButton.click();
        return this;
    }
    @Step("Get title")
    public String  getTitle() {

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(titlePage));
        return titlePage.getText();
    }

    @Step("Error massage is display")
    public String  errorMassageIsDisplay() {

        return errorMassage.getText();
    }
    @Step("Error pass massage is display")
    public String errorPassMassageIsDisplay() {

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(errorPassMassage));
        return errorPassMassage.getText();
    }


}