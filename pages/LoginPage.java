package opencart.pages;

import java.time.Duration;

import javax.imageio.ImageIO;

import java.io.File;
import org.openqa.selenium.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoginPage {
	static Logger log = Logger.getLogger("devpinoyLogger");
	
	private WebDriver driver;
	
	String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	static int count = 1;
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	@CacheLookup
	WebElement myAccount;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][contains(text(), 'Login')]")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath = "//input[@name = 'email']")
	@CacheLookup
	WebElement emailBox;
	
	@FindBy(xpath = "//input[@name = 'password']")
	@CacheLookup
	WebElement passwordBox;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	@CacheLookup
	WebElement loginSubmit;
	
	public LoginPage(WebDriver driver) {
//		String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
//		driver = new ChromeDriver();
//		driver.get(baseUrl);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.debug("Opened OpenCart");
	}
	
	public static void takeSnapShot(String fileWithPath) throws Exception{
		 // This code will capture screenshot of current screen      
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        // This will store screenshot on Specific location
        ImageIO.write(image, "png", new File(fileWithPath)); 
        log.debug("Screenshot taken");
    }

	
	public void login(String email, String password) throws Exception {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			myAccount.click();
			log.debug("MyAccount Link Clicked");
			
			loginBtn.click();
			log.debug("Login Link Clicked");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)", "");
			log.debug("Page scrolled");
			
			emailBox.sendKeys(email);
			log.debug("Email Entered");
			
			passwordBox.sendKeys(password);
			log.debug("Password Entered");
			
			takeSnapShot(baseFilePath + "\\LoginImgs\\beforeLogin" + count + ".png");
			
			loginSubmit.click();
			log.debug("Login Button Clicked");
			
			
			Thread.sleep(2000);
			takeSnapShot(baseFilePath + "\\LoginImgs\\afterLogin" + count + ".png");
			
			count++;
	}
	
	public void closeBrowser() {
		driver.quit();
		log.debug("Browser quit");
	}

}
