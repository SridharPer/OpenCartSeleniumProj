package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {
	private WebDriver driver;
	@FindBy(xpath = "//input[@name='firstname']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//a[@class='list-group-item'][contains(text(), 'Edit Account')]")
	@CacheLookup
	WebElement editBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	@CacheLookup
	WebElement continueBtn;
	
	public EditAccountPage(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void editFirstName(String firstName) throws InterruptedException {
		
		editBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		continueBtn.click();
		Thread.sleep(3000);
		
	}
	
	public void editLastName(String lastName) throws InterruptedException {
		
		editBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		continueBtn.click();
		Thread.sleep(3000);
		
	}
	
	public void editEmail(String email) throws InterruptedException {
		
		editBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		this.email.clear();
		this.email.sendKeys(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		continueBtn.click();
		Thread.sleep(3000);
		
	}
	
	
	
	public void closeBrowser() {
		driver.quit();
	}
}