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

    public void selectOption(int option) {
        Select optionsDropdown = new Select(dropdown);
        optionsDropdown.selectByIndex(option);
    }

    public List getDropdownContent() {
        Select optionsDropdown = new Select(dropdown);
        List<WebElement> options = optionsDropdown.getOptions();
        List<String> namesOfOptions = new ArrayList<>();
        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
        }
        return namesOfOptions;
    }

    public String isAvailableOption(int option) {
        Select optionsDropdown = new Select(dropdown);
        List<WebElement> options = optionsDropdown.getOptions();
        return options.get(option).getAttribute("disabled");
    }

    public boolean isSelectedOption(int option) {
        Select optionsDropdown = new Select(dropdown);
        List<WebElement> options = optionsDropdown.getOptions();
        selectOption(option);
        return options.get(option).isSelected();
    }
}
