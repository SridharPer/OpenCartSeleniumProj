package utilities;

import static org.testng.Assert.assertFalse;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class SeleniumUtilities {
	WebDriver driver;
	JavascriptExecutor js;
	
	static String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	public SeleniumUtilities(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
	public static void logger(String log) {
		Logger.getLogger("group_04").debug(log);
	}
	
	
	public String getBaseURL() {
		return "http://localhost/upload/index.php?route=common/home&language=en-gb";
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void takeSnapShot(String fileWithPath) throws Exception{
		 // This code will capture screenshot of current screen      
       BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
       // This will store screenshot on Specific location
       ImageIO.write(image, "png", new File(baseFilePath + fileWithPath)); 
       logger("Screenshot taken");
   }
	
	public WebElement waitForElement(String elementLocator, String by) {
        WebElement webElement = null;
        int timeout = 20; //in seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            System.out.println(elementLocator);
            if(by.equalsIgnoreCase("xpath")) {
            	webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));
            }
            else if(by.equalsIgnoreCase("csspath")){
            	webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementLocator)));
            }
            else if(by.equalsIgnoreCase("name")) {
            	webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementLocator)));
            }
            else if(by.equalsIgnoreCase("tagname")) {
            	webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(elementLocator)));
            }
            else if(by.equalsIgnoreCase("id")) {
            	webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementLocator)));
            }
            else {
            	assertFalse(true, "Invalid Keyword : " + by);
            }
            
        } catch (WebDriverException e) {
            
        }

        if (webElement == null) {
            assertFalse(true, "WebElement not found within " + timeout + " seconds. Failing test!" + " of element: " + elementLocator + "\nCurrent page: " + driver.getCurrentUrl());
        }
        return webElement;
    }
	
	public void click(WebElement e) {
        try {
        	e.click();
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
	
	 public String getElementText(WebElement e) {
	        return e.getText();
	  }
	 
	 public void scroll(int up, int down) {
		 js.executeScript("window.scrollBy(" + up + "," + down + ")","");
	 }
	 
	 public void setImplicitWait(int seconds) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	 }
	 
	 public String[][] readCSV(String filename) throws CsvValidationException, IOException {
		 CSVReader csvRead1 = new CSVReader(new FileReader(filename));
		 String[] rowData = null;
		 int row = 0;
		 while((rowData = csvRead1.readNext()) != null) {
			 row++;
		 }
		 String[][] data = new String[row][];
		 int i = 0;
		 
		 CSVReader csvRead2 = new CSVReader(new FileReader(filename));
		 while((rowData = csvRead2.readNext()) != null) {
			 data[i] = rowData;
			 i++;
		 }
		 
		 return data;
	 }
	 
}
