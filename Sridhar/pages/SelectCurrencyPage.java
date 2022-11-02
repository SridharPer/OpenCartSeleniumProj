package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public SelectCurrencyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void changeCurrencyToEuro() throws InterruptedException {
		currencyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		euro.click();
		
		Thread.sleep(3000);
	}
	
	public void changeCurrencyToPound() throws InterruptedException {
		currencyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		poundSterling.click();
		
		Thread.sleep(3000);
	}
	
	public void changeCurrencyToUSDollar() throws InterruptedException {
		currencyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		usDollar.click();
		
		Thread.sleep(3000);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
