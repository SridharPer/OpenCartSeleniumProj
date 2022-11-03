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

public class EditAccountPage {
	private WebDriver driver;
	SeleniumUtilities util;
	
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
	
	@FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
	WebElement result;
	
	public EditAccountPage(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new SeleniumUtilities(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void editFirstName(String firstName) throws Exception {
		editBtn.click();
		SeleniumUtilities.logger("Edit Account Button clicked");
		
		SeleniumUtilities.takeSnapShot("\\EditAccountImgs\\beforeFirstNameEdit.png");
		this.firstName.clear();
		SeleniumUtilities.logger("Old First Name cleared");
		
		this.firstName.sendKeys(firstName);
		SeleniumUtilities.logger("New First Name entered");
		
		SeleniumUtilities.takeSnapShot("\\EditAccountImgs\\afterFirstNameEdit.png");
	}
	
	public void editLastName(String lastName) throws Exception {
		editBtn.click();
		SeleniumUtilities.logger("Edit Account Button clicked");
		
		SeleniumUtilities.takeSnapShot("\\EditAccountImgs\\beforeLastNameEdit.png");
		this.lastName.clear();
		SeleniumUtilities.logger("Old Last Name cleared");
		
		this.lastName.sendKeys(lastName);
		SeleniumUtilities.logger("New Last Name entered");

		SeleniumUtilities.takeSnapShot("\\EditAccountImgs\\afterLastNameEdit.png");
	}
	
	public void editEmail(String email) throws Exception {
		
		editBtn.click();
		SeleniumUtilities.logger("Edit Account Button clicked");
		
		SeleniumUtilities.takeSnapShot("\\EditAccountImgs\\beforeEmailEdit.png");
		this.email.clear();
		SeleniumUtilities.logger("Old Email cleared");
		
		this.email.sendKeys(email);
		SeleniumUtilities.logger("New Email entered");
		
		SeleniumUtilities.takeSnapShot("\\EditAccountImgs\\afterEmailEdit.png");
	}
	
	
	
	public void closeBrowser() throws Exception {
		util.scroll(0, 150);
		
		continueBtn.click();
		
		Thread.sleep(2000);
		
		SeleniumUtilities.takeSnapShot("\\EditAccountImgs\\AccountEdited.png");
		
		String expectedResult = "Success: Your account has been successfully updated.";
		String actualResult = result.getText();
		Assert.assertEquals(actualResult,expectedResult);
		
		driver.quit();
	}
}
