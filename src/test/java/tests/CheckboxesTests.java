package tests;

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
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void goToCheckboxesPageTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        mainMenuPage.selectCheckboxes();
        assertTrue(checkboxesPage.getTitleText().contains("Checkboxes"));
    }

    @Test
    public void verifyDefaultValuesInCheckboxesTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        mainMenuPage.selectCheckboxes();
        assertFalse(checkboxesPage.isSelected(1));
        assertTrue(checkboxesPage.isSelected(2));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
