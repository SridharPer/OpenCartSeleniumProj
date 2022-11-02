package opencart.tests;

import org.testng.annotations.Test;

import opencart.CustomOpenCartDriver;
import opencart.pages.SelectCurrencyPage;

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
	
	 @BeforeMethod
	  public void setUp() {
		  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
		//Mazimize current window
		  driver.manage().window().maximize();
		  selectCurrency = new SelectCurrencyPage(driver);
	  }
	 public static void takeSnapShot(String fileWithPath) throws Exception{
		 // This code will capture screenshot of current screen      
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        // This will store screenshot on Specific location
        ImageIO.write(image, "png", new File(fileWithPath)); 
    }
	 
  @Test
  public void selectEuroTest() throws Exception {
	  takeSnapShot(baseFilePath + "\\SelectCurrencyImgs\\beforeCurrency.png");
	  selectCurrency.changeCurrencyToEuro();
  }

  @AfterMethod
  public void tearDown() throws Exception {
	  takeSnapShot(baseFilePath + "\\SelectCurrencyImgs\\afterCurrency.png");
	  selectCurrency.closeBrowser();
  }

}
