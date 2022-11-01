package opencart.tests;

import org.testng.annotations.Test;

import opencart.pages.ChangePasswordPage;
import opencart.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LoginTest {
	LoginPage myLogin;
	WebDriver driver;
	
	@DataProvider(name="account-details")
	public String[][] getLoginDetails(){
		String[][] details = new String[3][2];
		details[0][0] = "temp@gmail.com";
		details[0][1] = "admin";
		
		details[1][0] = "temp1@gmail.com";
		details[1][1] = "admin1";
		
		details[2][0] = " ";
		details[2][1] = " ";
		
		return details;
	}
	  @Test(dataProvider = "account-details")
	  public void loginPageTest(String email, String password) throws Exception {
		  myLogin.login(email, password);
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
		  //Maximize current window
		  driver.manage().window().maximize();
		  myLogin = new LoginPage(driver);
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  myLogin.closeBrowser();
	  }
}
