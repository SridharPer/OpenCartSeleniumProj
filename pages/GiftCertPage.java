package opencart.pages;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.SeleniumUtilities;

public class GiftCertPage {
	WebDriver driver;
	static int count;
	
	public GiftCertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[starts-with(text(),'Gift')]")
	WebElement giftBtn;
	
	@FindBy(id="input-to-name")
	WebElement recNameInp;
	
	@FindBy(id="input-to-email")
	WebElement recEmailInp;
	
	@FindBy(id="input-from-name")
	WebElement nameInp;
	
	@FindBy(id="input-from-email")
	WebElement emailInp;
	
	@FindBy(id = "input-theme-7")
	WebElement birthdayBtn;
	
	@FindBy(id = "input-theme-6")
	WebElement christmasBtn;
	
	@FindBy(id = "input-theme-8")
	WebElement generalBtn;
	
	@FindBy(id = "input-message")
	WebElement msgInp;
	
	@FindBy(id = "input-amount")
	WebElement amtInp;
	
	@FindBy(name = "agree")
	WebElement agreeBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@id='content']/p")
	WebElement purchaseSucc;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continueBtn;
	
	public void fillGiftCertificate(String recName, String recEmail, String name, String email, String choice, String message, String amount) throws Exception {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		
		util.scroll(0, 500);
		
		SeleniumUtilities.logger("Home Page Opened.");
		
		giftBtn.click();
		
		SeleniumUtilities.logger("Gift Certificate link clicked.");
		
		recNameInp.sendKeys(recName);
		SeleniumUtilities.logger("Recipient Name Entered.");
		
		recEmailInp.sendKeys(recEmail);
		SeleniumUtilities.logger("Recipient Email Entered.");
		
		nameInp.sendKeys(name);
		SeleniumUtilities.logger("From Name Entered.");
		
		emailInp.sendKeys(email);
		SeleniumUtilities.logger("From Email Entered.");
		
		if(choice.equalsIgnoreCase("birthday")) {
			birthdayBtn.click();
		}
		else if(choice.equalsIgnoreCase("christmas")) {
			christmasBtn.click();
		}
		else if(choice.equalsIgnoreCase("general")) {
			generalBtn.click();
		}
		else {
			Assert.assertEquals(true, "Invalid checkbox selected!");
		}
		
		SeleniumUtilities.logger("Gift Certificate Theme selected");
		
		SeleniumUtilities.takeSnapShot("\\GiftCertificateImgs\\beforeSubmitForm1_" + count + ".png");
		
		util.scroll(0, 150);
		
		msgInp.sendKeys(message);
		SeleniumUtilities.logger("Message Entered");
		
		amtInp.clear();
		amtInp.sendKeys(amount);
		SeleniumUtilities.logger("Amount Entered");
		
		agreeBtn.click();
		SeleniumUtilities.logger("Agree Button selected");
		
		Thread.sleep(1000);
		
		SeleniumUtilities.takeSnapShot("\\GiftCertificateImgs\\beforeSubmitForm2_" + count + ".png");
		
		submitBtn.click();
		SeleniumUtilities.logger("Submit Button Clicked");
		
		Thread.sleep(1000);
		
		String expectedTitle = "Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.";
		
		Assert.assertEquals(purchaseSucc.getText(), expectedTitle);
		
		SeleniumUtilities.takeSnapShot("\\GiftCertificateImgs\\afterSubmitForm1_" + count + ".png");
		
		continueBtn.click();
		SeleniumUtilities.logger("Continue Button Clicked");
		
		SeleniumUtilities.takeSnapShot("\\GiftCertificateImgs\\afterSubmitForm2_" + count + ".png");
		
		count++;
	}
	
}
