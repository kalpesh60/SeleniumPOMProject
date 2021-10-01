package Testng.SeleniumSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Testng.SeleniumPages.HomePage;
import Testng.SeleniumPages.SignUP;

public class Setup {
	WebDriver driver;

	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:/Users/kalpe/eclipse-workspace/SeleniumProjectPOM/Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.browserstack.com/");
	}

	@Test(priority = 1)
	public void navigate_to_homepage_click_on_getstarted() {
	HomePage objHomePage = new HomePage(driver);
	objHomePage.veryHeader();
	objHomePage.clickOnGetStarted();
	}

	@Test(priority = 2)
	public void enter_userDetails() {
	SignUP objSignUpPage = new SignUP(driver);
	objSignUpPage.veryHeader();
	objSignUpPage.enterFullName("TestUser");
	objSignUpPage.enterBusinessEmail("TestUser@gmail.com");
	objSignUpPage.enterPasswrod("TestUserPassword");
	}
}
