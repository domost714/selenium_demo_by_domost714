package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div/h2")
    private WebElement titleText;
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTitleText() {
        String text = titleText.getText();
        return text;
    }
}
