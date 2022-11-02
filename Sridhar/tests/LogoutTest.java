package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.LogoutPage;

public class LogoutTest {
	WebDriver driver;
	LoginPage myLogin;
	LogoutPage myLogout;
	
	
	@BeforeTest
	public void setUp() {
		  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
		  //Maximize current window
		  driver.manage().window().maximize();
		  myLogin = new LoginPage(driver);
		  myLogout = new LogoutPage(driver);
	}
  @Test
  public void logoutTest() throws Exception {
	  myLogin.login("temp@gmail.com", "admin");
	  myLogout.logout();
  }
  
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}
