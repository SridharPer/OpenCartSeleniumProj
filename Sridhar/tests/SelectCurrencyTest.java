package opencart.tests;

import org.testng.annotations.Test;

import opencart.CustomOpenCartDriver;
import opencart.pages.SelectCurrencyPage;
import utilities.SeleniumUtilities;

import org.testng.annotations.BeforeMethod;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SelectCurrencyTest {
	WebDriver driver;
	String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	CustomOpenCartDriver customDriver;
	SelectCurrencyPage selectCurrency;
	SeleniumUtilities util;
	
	 @BeforeMethod
	  public void setUp() {
		  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
		//Mazimize current window
		  driver.manage().window().maximize();
		  selectCurrency = new SelectCurrencyPage(driver);
		  util = new SeleniumUtilities(driver);
	  }
	 public static void takeSnapShot(String fileWithPath) throws Exception{
		 // This code will capture screenshot of current screen      
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        // This will store screenshot on Specific location
        ImageIO.write(image, "png", new File(fileWithPath)); 
    }
	 
  @Test(priority = 1)
  public void selectEuroTest() throws Exception {
	  selectCurrency.changeCurrencyToEuro();
	  util.scroll(0,550);
	  takeSnapShot(baseFilePath + "\\SelectCurrencyImgs\\afterCurrencyEuro.png");
	  util.scroll(550,0);
  }
  
  @Test(priority = 2)
  public void selectUSDollar() throws Exception {
	  selectCurrency.changeCurrencyToUSDollar();
	  util.scroll(0,550);
	  takeSnapShot(baseFilePath + "\\SelectCurrencyImgs\\afterCurrencyUSDollar.png");
	  util.scroll(550,0);
  }

  @Test(priority = 3)
  public void selectPoundTest() throws Exception {
	  selectCurrency.changeCurrencyToPound();
	  util.scroll(0,550);
	  takeSnapShot(baseFilePath + "\\SelectCurrencyImgs\\afterCurrencyPound.png");
	  util.scroll(550,0);
  }
 
  @AfterMethod
  public void tearDown() throws Exception {
	  selectCurrency.closeBrowser();
  }

}