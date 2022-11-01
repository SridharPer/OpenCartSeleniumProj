package Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
//    private WebDriver driver;
    
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
    
    @FindBy(xpath = "//*[@id=\"form-login\"]/button")
    @CacheLookup
    WebElement loginSubmit;

	WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
//        driver = new ChromeDriver();
		this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
        
        Assert.assertEquals(driver.getTitle().toString(), "Your Store");
    }
    
    public void login(String email, String password) throws InterruptedException {
            myAccount.click();
            
            loginBtn.click();
            
            emailBox.sendKeys(email);
                        
            passwordBox.sendKeys(password);
            
            loginSubmit.click();
            
            Thread.sleep(1000);
    }
    
//    public void closeBrowser() {
//        driver.quit();
//    }
}
