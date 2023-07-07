package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class DropdownPage {
    private WebDriver driver;
    @FindBy(css = "#content > div > h3")
    private WebElement titleText;
    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        String text = titleText.getText();
        return text;
    }

    public List getDropdownContent() {
        Select optionDropdown = new Select(dropdown);
        List<WebElement> options = optionDropdown.getOptions();
        List<String> namesOfOptions = new ArrayList<>();
        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
        }
        return namesOfOptions;
    }
}
