package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage {
    @FindBy(xpath = "//*[@id=\"flash\"]")
    private WebElement snackbar;
    private WebDriver driver;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSnackbarText() {
        String text = snackbar.getText();
        return text;
    }
}
