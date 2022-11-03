package opencart.tests;

import org.testng.annotations.Test;

import opencart.pages.ChangePasswordPage;
import opencart.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ChangePasswordTest {
	ChangePasswordPage changePass;
	LoginPage loginPage;
	WebDriver driver;

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	  changePass = new ChangePasswordPage(driver);
	  loginPage = new LoginPage(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @Test(dataProvider = "changepass-details")
  public void changePasswordPageTest(String pass, String confPass) throws Exception {
	  loginPage.login("temp@gmail.com", "admin1");
	  changePass.changePassword(pass, confPass);
  }
  
  @DataProvider(name="changepass-details")
  public String[][] getDetails(){
	  String[][] details = new String[1][2];
	  details[0][0] = "admin";
	  details[0][1] = "admin";
	  return details;
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
