package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		
		public ChangePasswordPage(WebDriver driver) {
//			driver = new ChromeDriver();
//			driver.get(baseUrl);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void changePassword(String password, String confirmPassword) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			passwordBtn.click();
			
			this.password.sendKeys(password);
			
			this.confirmPassword.sendKeys(confirmPassword);
			
			continueBtn.click();
			Thread.sleep(5000);
			
		}
		
		
		public void closeBrowser() {
			driver.quit();
		}
}
