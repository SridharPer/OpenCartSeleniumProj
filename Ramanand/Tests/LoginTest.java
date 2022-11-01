package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Page.LoginPage;

public class LoginTest {
	 LoginPage myLogin;
     @Test
     public void loginPageTest() throws InterruptedException {
         myLogin.login("ramanant75@gmail.com", "ramu123");
     }
     @BeforeMethod
     public void beforeMethod() {
         myLogin = new LoginPage();
     }
    @AfterMethod
     public void afterMethod() throws InterruptedException {
//         myLogin.closeBrowser();
     }




}
