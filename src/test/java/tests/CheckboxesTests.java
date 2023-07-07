package tests;

import conf.DataHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxesPage;
import pages.MainMenuPage;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CheckboxesTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DataHelper.chromeDriverLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to(DataHelper.websiteAddress);
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.selectCheckboxes();
    }

    @Test
    public void goToCheckboxesPageTest() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        assertTrue(checkboxesPage.getTitleText().contains("Checkboxes"));
    }

    @Test
    public void verifyDefaultValuesInCheckboxesTest() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        assertFalse(checkboxesPage.isSelected(1));
        assertTrue(checkboxesPage.isSelected(2));
    }

    @Test
    public void verifyMarkingCheckboxesTest() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.selectCheckbox(1);
        assertTrue(checkboxesPage.isSelected(1));
        checkboxesPage.selectCheckbox(1);
        assertFalse(checkboxesPage.isSelected(1));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
