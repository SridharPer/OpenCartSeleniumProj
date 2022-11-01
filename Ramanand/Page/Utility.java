package Page;

import java.io.File;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
    Logger log= Logger.getLogger("devpinoyLogger");
	WebDriver driver;
	String filePath = "C:\\Users\\ramanand_thakur\\Desktop\\SS\\";
	
	public Utility(WebDriver driver) {
		this.driver = driver;
		log.debug("Utility Class initialized... Ready To Take ScreenShots");
	}
	
	public void takeSS(String title) throws IOException {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timeStamp = time.toString().replace(":", "").replace(" ", "_");
		
	      try {
	    	  File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	  FileUtils.copyFile(s, new File(filePath+timeStamp+"_"+title+".png"));
	    	  log.debug("Screenshot Captured: "+title);
		} catch (Exception e) {
		}

		}
}
