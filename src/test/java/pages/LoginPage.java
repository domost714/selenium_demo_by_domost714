package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div/h2")
    private WebElement titleText;
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"login\"]/button/i")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"flash\"]")
    private WebElement snackbar;
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTitleText() {
        String text = titleText.getText();
        return text;
    }
    public void typeIntoUsernameField(String password) {
        usernameField.clear();
        usernameField.sendKeys(password);
    }
    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }
    public String getSnackbarText() {
        String text = snackbar.getText();
        return text;
    }
}
