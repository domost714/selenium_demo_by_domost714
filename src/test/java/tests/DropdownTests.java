package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.MainMenuPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DropdownTests {
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
    public void goToDropdownPageTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        DropdownPage dropdownPage = new DropdownPage(driver);
        mainMenuPage.selectDropdown();
        assertTrue(dropdownPage.getTitleText().contains("Dropdown List"));
    }

    @Test
    public void verifyDropdownListContent() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        DropdownPage dropdownPage = new DropdownPage(driver);
        mainMenuPage.selectDropdown();
        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Please select an option");
        expectedNamesOfOptions.add("Option 1");
        expectedNamesOfOptions.add("Option 2");
        assertEquals(dropdownPage.getDropdownContent(), expectedNamesOfOptions);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
