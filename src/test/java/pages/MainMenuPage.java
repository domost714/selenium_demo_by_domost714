package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenuPage {
    private WebDriver driver;
    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthentication;
    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxes;

    @FindBy(linkText = "Dropdown")
    private WebElement dropdown;

    public MainMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFormAuthentication() {
        formAuthentication.click();
    }

    public void selectCheckboxes() {
        checkboxes.click();
    }

    public void selectDropdown() {
        dropdown.click();
    }
}
