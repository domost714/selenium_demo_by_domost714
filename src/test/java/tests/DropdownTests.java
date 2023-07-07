package tests;

import conf.DataHelper;
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

import static org.testng.AssertJUnit.*;

public class DropdownTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DataHelper.chromeDriverLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to(DataHelper.websiteAddress);
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.selectDropdown();
    }

    @Test
    public void goToDropdownPageTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        assertTrue(dropdownPage.getTitleText().contains("Dropdown List"));
    }

    @Test
    public void verifyDropdownListContentTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Please select an option");
        expectedNamesOfOptions.add("Option 1");
        expectedNamesOfOptions.add("Option 2");
        assertEquals(dropdownPage.getDropdownContent(), expectedNamesOfOptions);
    }

    @Test
    public void verifyUserCannotSelectOnlyTheFirstTextTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        assertTrue(dropdownPage.isAvailableOption(0).contains("true"));
        assertEquals(dropdownPage.isAvailableOption(1), null);
        assertEquals(dropdownPage.isAvailableOption(2), null);
    }

    @Test
    public void verifyElementAreCorrectlySelectedTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        assertTrue(dropdownPage.isSelectedOption(1));
        assertTrue(dropdownPage.isSelectedOption(2));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
