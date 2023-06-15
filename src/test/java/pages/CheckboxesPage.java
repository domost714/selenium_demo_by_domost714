package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    private WebElement titleText;
    @FindBy(css = "#checkboxes > input[type=checkbox]:nth-child(1)")
    private WebElement firstCheckbox;
    @FindBy(css = "#checkboxes > input[type=checkbox]:nth-child(3)")
    private WebElement secondCheckbox;
    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        String text = titleText.getText();
        return text;
    }

    public boolean isSelected(int number) {
        if (number == 1) {
            return firstCheckbox.isSelected();
        }
        else {
            return secondCheckbox.isSelected();
        }
    }
}
