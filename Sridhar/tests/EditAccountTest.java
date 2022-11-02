package opencart.tests;

import org.testng.annotations.Test;

import opencart.pages.EditAccountPage;
import opencart.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class EditAccountTest {
	EditAccountPage editAcc;
	LoginPage loginPage;
	WebDriver driver;
  @Test
  public void editAccountPageTest() throws Exception {
	  loginPage.login("shridharmaskeri@gmail.com", "admin123");
	  editAcc.editFirstName("Shridhar");
	  editAcc.editFirstName("Maskeri");
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  editAcc = new EditAccountPage(driver);
	  loginPage = new LoginPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  editAcc.closeBrowser();
  }

}
