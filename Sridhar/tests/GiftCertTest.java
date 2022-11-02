package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import opencart.pages.GiftCertPage;
import opencart.pages.LoginPage;
import opencart.pages.LogoutPage;
import utilities.SeleniumUtilities;

public class GiftCertTest {
	WebDriver driver;
	SeleniumUtilities util;
	
	GiftCertPage gift;
	LoginPage myLogin;
	
	String csvPath = "C:\\Users\\Administrator\\Documents\\openCartData\\giftDetails.csv";
	
	
	@BeforeTest
	public void setUp() {
		  driver = new ChromeDriver();
		  util = new SeleniumUtilities(driver);
		  driver.get(util.getBaseURL());
		  //Maximize current window
		  util.maximizeWindow();
		  gift = new GiftCertPage(driver);
		  util.setImplicitWait(10);
	}
  @Test
  public void fillGiftCert() throws Exception {
	  String recName = "";
	  String recEmail = "";
	  String name = "";
	  String email = "";
	  String choice = "";
	  String message = "";
	  String amount = "";
	  
	  String[][] data = util.readCSV(csvPath);
	  
	  for(String[] row: data) {
		 recName = row[0];
		 recEmail = row[1];
		 name = row[2];
		 email = row[3];
		 choice = row[4];
		 message = row[5];
		 amount = row[6];
		 gift.fillGiftCertificate(recName, recEmail, name, email, choice,message, amount);
	  }
	  
  }
  
  @AfterTest
  public void tearDown() throws InterruptedException {
//	  Thread.sleep(5000);
	  driver.quit();
  }
}
