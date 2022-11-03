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
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  editAcc = new EditAccountPage(driver);
	  loginPage = new LoginPage(driver);
	  driver.manage().window().maximize();
  }
  
  @Test(priority = 1)
  public void editAccountFirstName() throws Exception {
	  loginPage.login("temp@gmail.com", "admin");
	  editAcc.editFirstName("Shridhar");
  }
  
  @Test(priority = 2)
  public void editAccountLastName() throws Exception {
	  loginPage.login("temp@gmail.com", "admin");
	  editAcc.editLastName("Maskeri");
  }
  
  @Test(priority = 3)
  public void editAccountEmail() throws Exception {
	  loginPage.login("temp@gmail.com", "admin");
	  editAcc.editEmail("temp@gmail.com");
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  editAcc.closeBrowser();
  }

}
