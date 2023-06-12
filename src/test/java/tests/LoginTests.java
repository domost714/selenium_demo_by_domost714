package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainMenuPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests {
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
    public void goToLoginPage() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainMenuPage.selectFormAuthentication();
        assertTrue(loginPage.getTitleText().contains("Login Page"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
