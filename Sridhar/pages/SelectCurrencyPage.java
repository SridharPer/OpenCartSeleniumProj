package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SelectCurrencyPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='d-none d-md-inline'][contains(text(),'Currency')]")
	@CacheLookup
	WebElement currencyBtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']/li[1]")
	@CacheLookup
	WebElement euro;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']/li[2]")
	@CacheLookup
	WebElement poundSterling;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']/li[3]")
	@CacheLookup
	WebElement usDollar;
	
	@FindBy(xpath = "//div[@class = 'price'][1]/span[@class='price-new']")
	@CacheLookup
	WebElement checkPrice;
	
	public SelectCurrencyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void changeCurrencyToEuro() throws InterruptedException {
		currencyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		euro.click();
		
		char expectedPrice = '€';
		char actualPrice = checkPrice.getText().charAt(checkPrice.getText().length()-1);
		Assert.assertEquals(actualPrice, expectedPrice);
	}
	
	public void changeCurrencyToPound() throws InterruptedException {
		currencyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		poundSterling.click();
		
		char expectedPrice = '£';
		char actualPrice = checkPrice.getText().charAt(0);
		Assert.assertEquals(actualPrice, expectedPrice);
	}
	
	public void changeCurrencyToUSDollar() throws InterruptedException {
		currencyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		usDollar.click();
		
		char expectedPrice = '$';
		char actualPrice = checkPrice.getText().charAt(0);
		Assert.assertEquals(actualPrice, expectedPrice);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
