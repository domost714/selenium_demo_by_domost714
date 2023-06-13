package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainMenuPage;
import pages.SecureAreaPage;

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
    public void goToLoginPageTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainMenuPage.selectFormAuthentication();
        assertTrue(loginPage.getTitleText().contains("Login Page"));
    }

    @Test
    public void successfulLoginTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
        mainMenuPage.selectFormAuthentication();
        loginPage.typeIntoUsernameField("tomsmith");
        loginPage.typeIntoPasswordField("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        assertTrue(secureAreaPage.getSnackbarText().contains("secure area"));
    }

    @Test
    public void incorrectUsernameFailedLoginTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainMenuPage.selectFormAuthentication();
        loginPage.typeIntoUsernameField("tester");
        loginPage.typeIntoPasswordField("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getSnackbarText().contains("invalid"));
    }

    @Test
    public void incorrectBothFieldsFailedLoginTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainMenuPage.selectFormAuthentication();
        loginPage.typeIntoUsernameField("tester");
        loginPage.typeIntoPasswordField("haslo");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getSnackbarText().contains("invalid"));
    }

    @Test
    public void incorrectPasswordFailedLoginTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainMenuPage.selectFormAuthentication();
        loginPage.typeIntoUsernameField("tomsmith");
        loginPage.typeIntoPasswordField("haslo");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getSnackbarText().contains("invalid"));
    }

    @Test
    public void properUsernameButWithCapitalLettersFailedLoginTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainMenuPage.selectFormAuthentication();
        loginPage.typeIntoUsernameField("TOMSMITH");
        loginPage.typeIntoPasswordField("haslo");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getSnackbarText().contains("invalid"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
