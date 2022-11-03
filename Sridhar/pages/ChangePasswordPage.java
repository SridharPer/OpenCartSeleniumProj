package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.SeleniumUtilities;

public class ChangePasswordPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='list-group-item'][contains(text(),'Password')]")
	@CacheLookup
	WebElement passwordBtn;
	
	@FindBy(id="input-password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="input-confirm")
	@CacheLookup
	WebElement confirmPassword;
	
	@FindBy(xpath = "//button[@class = 'btn btn-primary'][contains(text(),'Continue')]")
	@CacheLookup
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
	WebElement result;
		
		public ChangePasswordPage(WebDriver driver) {
//			driver = new ChromeDriver();
//			driver.get(baseUrl);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		public void changePassword(String password, String confirmPassword) throws Exception {
			
			passwordBtn.click();
			SeleniumUtilities.logger("Change Password Button Clicked");
			
			this.password.sendKeys(password);
			SeleniumUtilities.logger("Password Entered");
			
			this.confirmPassword.sendKeys(confirmPassword);
			SeleniumUtilities.logger("Confirm Password Entered");
			
			SeleniumUtilities.takeSnapShot("\\ChangePassImgs\\beforeChangePass.png");
			
			continueBtn.click();
			SeleniumUtilities.logger("Continue Button Clicked");
			Thread.sleep(2000);
			String expectedResult = "Success: Your password has been successfully updated.";
			String actualResult = result.getText();
			
			Assert.assertEquals(actualResult,expectedResult);
			
			SeleniumUtilities.takeSnapShot("\\ChangePassImgs\\afterChangePass.png");
		}
		
		
		public void closeBrowser() {
			driver.quit();
		}
}
